package cn.j2.onlinehomeworksystem.entity;

public class Grade {
    private Integer id;
    private Integer sid;
    private String sname;
    private String cname;
    private double ugrade; //平时成绩
    private double fgrade; //期末成绩
    private double tgrade; //总成绩

    public Grade(Integer id, Integer sid, String sname, String cname, double ugrade, double fgrade, double tgrade) {
        this.id = id;
        this.sid = sid;
        this.sname = sname;
        this.cname = cname;
        this.ugrade = ugrade;
        this.fgrade = fgrade;
        this.tgrade = tgrade;
    }

    public Grade() {
    }

    @Override
    public String toString() {
        return "grade{" +
                "id=" + id +
                ", sid=" + sid +
                ", sname='" + sname + '\'' +
                ", cname='" + cname + '\'' +
                ", ugrade=" + ugrade +
                ", fgrade=" + fgrade +
                ", tgrade=" + tgrade +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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
