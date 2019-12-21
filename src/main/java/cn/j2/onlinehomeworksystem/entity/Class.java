package cn.j2.onlinehomeworksystem.entity;

public class Class {
    private Integer classid;
    private String classname;

    public Class() {
    }

    public Class(Integer classid, String classname) {
        this.classid = classid;
        this.classname = classname;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classid=" + classid +
                ", classname='" + classname + '\'' +
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
}
