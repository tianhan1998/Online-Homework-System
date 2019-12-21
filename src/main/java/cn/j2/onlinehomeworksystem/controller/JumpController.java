package cn.j2.onlinehomeworksystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JumpController {
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
    @GetMapping("/updateClass")
    public String jumpUpdateClass(Integer classid, Model m){
        m.addAttribute("classid",classid);
        return "updateClass";
    }
    @GetMapping("/updateCourse")
    public String jumpUpdateCourse(Integer cid, Model m){
        m.addAttribute("cid",cid);
        return "updateCourse";
    }
    @GetMapping("/insertClass")
    public String insertClass(){
        return "insertClass";
    }
    @GetMapping("/insertCourse")
    public String insertCourse(){
        return "insertCourse";
    }
    @GetMapping("/selectPersonGrade")
    public String jumpSelectPersonGrade(){
        return "selectPersonGrade";
    }
    @GetMapping("/selectAllCourse")
    public String jumpSAC(){
        return "selectAllCourse";
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
    @GetMapping("/selectAllClass")
    public String jumpSAClass(){
        return "selectAllClass";
    }
    @GetMapping("/uploadHomework")
    public String jumpUploadHomework(){
        return "homeworkUpload";
    }
    @GetMapping("/checkUploadHomework")
    public String checkUPW(){
        return "checkHomeworkUpload";
    }
    @GetMapping("/selectAllClassGrade")
    public String selectAllClassGrade(){
        return "selectAllClassGrade";
    }
}
