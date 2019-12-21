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

    public static void test(String target) {
        String s1 = "在线学习查重系统设计与实现\n" +
                "\n" +
                "课程：9门课程，依次是：毛中特，计算机网络，Java EE视图层框架技术，Oracle数据库，软件前沿技术，软件工程导论，Java EE持久层框架技术，媒体设计方法学，企业项目实战\n" +
                "\n" +
                "功能：代码查重，在线提交作业，学生信息管理，班级学习信息统计，个人学习信息统计等\n" +
                "\n" +
                "\n" +
                "学生信息管理：字段：学号，姓名，性别，所在院校，行政班级，手机号（如17java1,17java2,17java3）\n" +
                "\n" +
                "\n" +
                "\n" +
                "课程信息：字段：课程号，课程名称，课程学时，课程学分\n" +
                "\n" +
                "\n" +
                "课程成绩：字段：学号，姓名，课程名称，平时成绩，期末试卷成绩，总成绩\n" +
                "\n" +
                "班级信息：字段：班级编号，行政班级\n" +
                "\n" +
                "\n" +
                "个人学习信息统计:字段：学号，姓名，性别，行政班级，课程名称，课程成绩（平时成绩，期末试卷成绩，总成绩）\n" +
                "\n" +
                "班级学习信息统计：字段：班级编号，行政班级，平时成绩（总分，平均分），期末试卷成绩（总分，平均分），总成绩（总分，平均分）\n" +
                "\n" +
                "在线提交作业：\n" +
                "\n" +
                "代码查重：V1.0 300个字的查重，不包含标点符号。\n" +
                "\n" +
                "          V2.0 对Word文档内容的查重。\n" +
                "学号\t姓名\t性别\t所在院校\t行政班级\t手机号\n" +
                "1701xxx\t\t\t\t17java1\t\n" +
                "1702xxx\t\t\t\t17java2\t\n" +
                "1703xxx\t\t\t\t17java3\t\n" +
                "\n" +
                "课程号\t课程名称\t课程学时\t课程学分\n" +
                "\n" +
                "学号\t姓名\t课程名称\t平时成绩\t期末试卷成绩\t总成绩\n" +
                "\n" +
                "班级编号\t行政班级\n" +
                "1701\t17java1\n" +
                "1702\t17java2\n" +
                "1703\t17java3\n" +
                "\n" +
                "学号\t姓名\t性别\t行政班级\t课程名称\t平时成绩\t期末试卷成绩\t总成绩\n" +
                "\n" +
                "班级编号\t行政班级\t平时成绩总分\t平时成绩平均分\t期末试卷成绩总分\t期末试卷成绩平均分\t总成绩总分\t总成绩平均分";
        SimHashUtils hash1 = new SimHashUtils(s1, 64);
        SimHashUtils hash2 = new SimHashUtils(target, 64);
        System.out.println("======================================");
        System.out.println("海明距离"+hash1.hammingDistance(hash2));
        System.out.println("相似度"+hash1.getSemblance(hash2));
    }
}
