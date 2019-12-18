package cn.j2.onlinehomeworksystem.controller;

import cn.j2.onlinehomeworksystem.entity.Result;
import cn.j2.onlinehomeworksystem.entity.Students;
import cn.j2.onlinehomeworksystem.service.IStudentDmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentDmlController {

    @Autowired
    private IStudentDmlService stDmlService;

    @RequestMapping("/addStudent")
    public Result addStudent(Students student){
        Result result = new Result();
        if(stDmlService.addStudent(student)>0){
            result.setCode(200);
            result.setMsg("添加成功");
        } else{
            result.setCode(500);
            result.setMsg("添加失败");
        }
        return result;
    }

    @RequestMapping("/deleteStudent")
    public Result deleteStudent(int sid){
        Result result = new Result();
        if(stDmlService.deleteStudent(sid)>0){
            result.setCode(200);
            result.setMsg("删除成功");
        } else{
            result.setCode(500);
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/updateStudent")
    public Result updateStudent(Students student){
        Result result = new Result();
        if(stDmlService.updateStudent(student)>0){
            result.setCode(200);
            result.setMsg("修改成功");
        } else{
            result.setCode(500);
            result.setMsg("修改失败");
        }
        return result;
    }

    @RequestMapping("/selectStudent")
    public Result selectStudent(Students student){
        Result result = new Result();
        List<Students> list = stDmlService.selectStudent(student);
        if(list!=null){
            result.setCode(200);
            result.setMsg("搜索成功");
            result.setData(list);
        } else {
            result.setCode(500);
            result.setMsg("搜索失败或无目标信息");
        }
//        request.setAttribute("list",list);
        return result;
    }
}
