package cn.j2.onlinehomeworksystem.entity;

public class PGrade {
    private int sid;
    private String sname;
    private String sex;
    private String classname;
    private String cname;
    private double ugrade; //平时成绩
    private double fgrade; //期末成绩
    private double tgrade; //总成绩

    public PGrade() {
    }

    public PGrade(int sid, String sname, String sex, String classname, String cname, double ugrade, double fgrade, double tgrade) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.classname = classname;
        this.cname = cname;
        this.ugrade = ugrade;
        this.fgrade = fgrade;
        this.tgrade = tgrade;
    }

    @Override
    public String toString() {
        return "PGrade{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", classname='" + classname + '\'' +
                ", cname='" + cname + '\'' +
                ", ugrade=" + ugrade +
                ", fgrade=" + fgrade +
                ", tgrade=" + tgrade +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getUgrade() {
        return ugrade;
    }

    public void setUgrade(double ugrade) {
        this.ugrade = ugrade;
    }

    public double getFgrade() {
        return fgrade;
    }

    public void setFgrade(double fgrade) {
        this.fgrade = fgrade;
    }

    public double getTgrade() {
        return tgrade;
    }

    public void setTgrade(double tgrade) {
        this.tgrade = tgrade;
    }
}
