package cn.j2.onlinehomeworksystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JumpController {
    @GetMapping("/hello")
    public String jumpHelloWorld(){
        return "HelloWorld";
    }
}
