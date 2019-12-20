package cn.j2.onlinehomeworksystem.utils;

import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class SimHashUtils {
    private String tokens;
    private BigInteger strSimHash;
    private int hashbits = 64;

    public SimHashUtils(String tokens) {
        this.tokens = tokens;
        this.strSimHash = this.simHash();
    }

    private SimHashUtils(String tokens, int hashbits) {
        this.tokens = tokens;
        this.hashbits = hashbits;
        this.strSimHash = this.simHash();
    }

    private String cleanResume(String content) {
        content = Jsoup.clean(content, Whitelist.none());
        content = StringUtils.lowerCase(content);
        String[] strings = new String[]{" ", "\n", "\r", "\t", "\\r", "\\n", "\\t", "&nbsp;"};
        String[] var3 = strings;
        int var4 = strings.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String s = var3[var5];
            content = content.replaceAll(s, "");
        }

        return content;
    }

    private BigInteger simHash() {
        this.tokens = this.cleanResume(this.tokens);
        int[] v = new int[this.hashbits];
        List<Term> termList = StandardTokenizer.segment(this.tokens);
        Map<String, Integer> weightOfNature = new HashMap();
        weightOfNature.put("n", 2);
        Map<String, String> stopNatures = new HashMap();
        stopNatures.put("w", "");
        int overCount = 5;
        Map<String, Integer> wordCount = new HashMap();
        Iterator var7 = termList.iterator();

        while(true) {
            String word;
            String nature;
            label49:
            do {
                while(var7.hasNext()) {
                    Term term = (Term)var7.next();
                    word = term.word;
                    nature = term.nature.toString();
                    if (wordCount.containsKey(word)) {
                        int count = (Integer)wordCount.get(word);
                        if (count > overCount) {
                            continue;
                        }

                        wordCount.put(word, count + 1);
                        continue label49;
                    }

                    wordCount.put(word, 1);
                    continue label49;
                }

                BigInteger fingerprint = new BigInteger("0");

                for(int i = 0; i < this.hashbits; ++i) {
                    if (v[i] >= 0) {
                        fingerprint = fingerprint.add((new BigInteger("1")).shiftLeft(i));
                    }
                }

                return fingerprint;
            } while(stopNatures.containsKey(nature));

            BigInteger t = this.hash(word);

            for(int i = 0; i < this.hashbits; ++i) {
                BigInteger bitmask = (new BigInteger("1")).shiftLeft(i);
                int weight = 1;
                if (weightOfNature.containsKey(nature)) {
                    weight = (Integer)weightOfNature.get(nature);
                }

                if (t.and(bitmask).signum() != 0) {
                    v[i] += weight;
                } else {
                    v[i] -= weight;
                }
            }
        }
    }

    private BigInteger hash(String source) {
        if (source != null && source.length() != 0) {
            while(source.length() < 3) {
                source = source + source.charAt(0);
            }

            char[] sourceArray = source.toCharArray();
            BigInteger x = BigInteger.valueOf((long)sourceArray[0] << 7);
            BigInteger m = new BigInteger("1000003");
            BigInteger mask = (new BigInteger("2")).pow(this.hashbits).subtract(new BigInteger("1"));
            char[] var6 = sourceArray;
            int var7 = sourceArray.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                char item = var6[var8];
                BigInteger temp = BigInteger.valueOf((long)item);
                x = x.multiply(m).xor(temp).and(mask);
            }

            x = x.xor(new BigInteger(String.valueOf(source.length())));
            if (x.equals(new BigInteger("-1"))) {
                x = new BigInteger("-2");
            }

            return x;
        } else {
            return new BigInteger("0");
        }
    }

    private int hammingDistance(SimHashUtils other) {
        BigInteger m = (new BigInteger("1")).shiftLeft(this.hashbits).subtract(new BigInteger("1"));
        BigInteger x = this.strSimHash.xor(other.strSimHash).and(m);

        int tot;
        for(tot = 0; x.signum() != 0; x = x.and(x.subtract(new BigInteger("1")))) {
            ++tot;
        }

        return tot;
    }

    public double getSemblance(SimHashUtils s2) {
        double i = (double)this.hammingDistance(s2);
        return 1.0D - i / (double)this.hashbits;
    }

    public static void test(String[] args) {
        String s1 = "这是另一个串。";
        String s2 = "测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试。测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试，测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试。";
        String s3 = "测试测试测试测试测试测试测试测试测试测试，测试测试测试测试测试测试测试测试测试测试测试。";
        String s4 = "测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试。";
        long l3 = System.currentTimeMillis();
        SimHashUtils hash1 = new SimHashUtils(s1, 64);
        SimHashUtils hash2 = new SimHashUtils(s2, 64);
        SimHashUtils hash3 = new SimHashUtils(s3, 64);
        SimHashUtils hash4 = new SimHashUtils(s4, 64);
        System.out.println("======================================");
        System.out.println(hash1.hammingDistance(hash2));
        System.out.println(hash2.hammingDistance(hash3));
        System.out.println(hash4.hammingDistance(hash3));
        System.out.println(hash1.getSemblance(hash3));
        System.out.println(hash2.getSemblance(hash3));
        System.out.println(hash3.getSemblance(hash4));
        long l4 = System.currentTimeMillis();
        System.out.println(l4 - l3);
        System.out.println("======================================");
    }
}
