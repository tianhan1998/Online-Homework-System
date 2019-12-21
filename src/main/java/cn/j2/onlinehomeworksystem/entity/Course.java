package cn.j2.onlinehomeworksystem.entity;

public class Course {
    private Integer cid;
    private String cname;
    private Integer hour;
    private Double credit;

    public Course(Integer cid, String cname, Integer hour, Double credit) {
        this.cid = cid;
        this.cname = cname;
        this.hour = hour;
        this.credit = credit;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}
