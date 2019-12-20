package cn.j2.onlinehomeworksystem.controller;

import cn.j2.onlinehomeworksystem.entity.Result;
import cn.j2.onlinehomeworksystem.entity.Students;
import cn.j2.onlinehomeworksystem.service.IStudentDmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentDmlController {

    @Autowired
    private IStudentDmlService stDmlService;

    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    public Result addStudent(Students student){
        Result result = new Result();
        try {
            if (stDmlService.addStudent(student) > 0) {
                result.setCode(200);
                result.setMsg("添加成功");
            } else {
                result.setCode(500);
                result.setMsg("添加失败");
            }
        }catch(Exception e){
            result.setMsg(e.getMessage());
            result.setCode(500);
        }
        return result;
    }

    @RequestMapping("/deleteStudent")
    public Result deleteStudent(int sid){
        Result result = new Result();
        try {
            if (stDmlService.deleteStudent(sid) > 0) {
                result.setCode(200);
                result.setMsg("删除成功");
            } else {
                result.setCode(500);
                result.setMsg("删除失败");
            }
        }catch(Exception e){
            result.setMsg(e.getMessage());
            result.setCode(500);
        }
        return result;
    }

    @GetMapping("/findUpdateStudent/{id}")
    public Result findUpdateStudent(@PathVariable("id") Integer id){
        Result result=new Result();
        Students students;
        try{
            students=stDmlService.findStudentById(id);
            if(students!=null){
                result.setData(students);
                result.setCode(200);
                result.setMsg("查找成功");
            }else{
                result.setData(null);
                result.setCode(404);
                result.setMsg("查找失败");
            }
        }catch(Exception e){
            result.setCode(500);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/updateStudent",method = RequestMethod.POST)
    public Result updateStudent(Students student){
        System.out.println("updatestudents======="+student);
        Result result = new Result();
        try {
            if (stDmlService.updateStudent(student) > 0) {
                result.setCode(200);
                result.setMsg("修改成功");
            } else {
                result.setCode(500);
                result.setMsg("修改失败");
            }
        }catch(Exception e){
            result.setCode(500);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/selectStudent")
    public Result selectStudent(Students student){
        Result result = new Result();
        try {
            List<Students> list = stDmlService.selectStudent(student);
            if (list != null) {
                result.setCode(200);
                result.setMsg("搜索成功");
                result.setData(list);
            } else {
                result.setCode(500);
                result.setMsg("搜索失败或无目标信息");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            result.setCode(500);
        }
        return result;
    }
}
