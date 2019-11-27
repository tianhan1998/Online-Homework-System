package cn.j2.onlinehomeworksystem;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.j2.onlinehomeworksystem.mapper")
public class OnlineHomeworkSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineHomeworkSystemApplication.class, args);
    }

}
