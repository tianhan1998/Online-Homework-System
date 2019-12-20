package cn.j2.onlinehomeworksystem;

import cn.j2.onlinehomeworksystem.entity.Students;
import cn.j2.onlinehomeworksystem.service.IStudentDmlService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineHomeworkSystemApplicationTests {
    @Autowired
    IStudentDmlService service;
    @Test
    public void test(){
        Students student = new Students();
        student.setSid(1701001011);
        student.setSname("赵虎");
        student.setSex("男");
        student.setClassname("17java2");
        student.setCollege("安阳师范学院");
        student.setNumber("1564261547");
        if(student!=null) {
            System.out.println("student不为空");
            service.updateStudent(student);
        } else {
            System.out.println("student为空");
        }
    }
    @Test
    void contextLoads() {
    }

}
