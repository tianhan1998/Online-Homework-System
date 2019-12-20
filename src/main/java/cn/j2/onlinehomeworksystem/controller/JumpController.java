package cn.j2.onlinehomeworksystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JumpController {
    @GetMapping("/hello")
    public String jumpHelloWorld(){
        return "HelloWorld";
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/selectAllStudent")
    public String jumpSelectAllStudent(){
        return "selectAllStudent";
    }
    @GetMapping("/updateStudent")
    public String jumpUpdateStudent(Integer sid, Model m){
        m.addAttribute("sid",sid);
        return "updateStudent";
    }
    @GetMapping("/delete")
    public String jumpDelete() {
        return "delete";
    }
    @GetMapping("/insertStudent")
    public String jumpInsertStudent(){
        return "insertStudent";
    }
    @GetMapping("/upload")
    public String jumpUpload(){
        return "upload";
    }
    @GetMapping("/welcome")
    public String jumpWelcome(){
        return "welcome";
    }
}
