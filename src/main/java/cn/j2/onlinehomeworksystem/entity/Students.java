package cn.j2.onlinehomeworksystem.entity;

public class Students {
    private Integer sid;
    private String sname;
    private String sex;
    private String college;
    private String classname;
    private String number;

    public Students() {
    }

    public Students(Integer sid, String sname, String sex, String college, String classname, String number) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.college = college;
        this.classname = classname;
        this.number = number;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", college='" + college + '\'' +
                ", classname='" + classname + '\'' +
                ", number=" + number +
                '}';
    }
}
