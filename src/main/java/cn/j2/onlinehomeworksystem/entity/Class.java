package cn.j2.onlinehomeworksystem.entity;

public class Class {
    private Integer classid;
    private String classname;
    private Double ugrade;
    private Double uavgrade;
    private Double fgrade;
    private Double favgrade;
    private Double tgrade;
    private Double tavgrade;

    public Class() {
    }

    public Class(Integer classid, String classname, Double ugrade, Double uavgrade, Double fgrade, Double favgrade, Double tgrade, Double tavgrade) {
        this.classid = classid;
        this.classname = classname;
        this.ugrade = ugrade;
        this.uavgrade = uavgrade;
        this.fgrade = fgrade;
        this.favgrade = favgrade;
        this.tgrade = tgrade;
        this.tavgrade = tavgrade;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classid=" + classid +
                ", classname='" + classname + '\'' +
                ", ugrade=" + ugrade +
                ", uavgrade=" + uavgrade +
                ", fgrade=" + fgrade +
                ", favgrade=" + favgrade +
                ", tgrade=" + tgrade +
                ", tavgrade=" + tavgrade +
                '}';
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Double getUgrade() {
        return ugrade;
    }

    public void setUgrade(Double ugrade) {
        this.ugrade = ugrade;
    }

    public Double getUavgrade() {
        return uavgrade;
    }

    public void setUavgrade(Double uavgrade) {
        this.uavgrade = uavgrade;
    }

    public Double getFgrade() {
        return fgrade;
    }

    public void setFgrade(Double fgrade) {
        this.fgrade = fgrade;
    }

    public Double getFavgrade() {
        return favgrade;
    }

    public void setFavgrade(Double favgrade) {
        this.favgrade = favgrade;
    }

    public Double getTgrade() {
        return tgrade;
    }

    public void setTgrade(Double tgrade) {
        this.tgrade = tgrade;
    }

    public Double getTavgrade() {
        return tavgrade;
    }

    public void setTavgrade(Double tavgrade) {
        this.tavgrade = tavgrade;
    }
}
