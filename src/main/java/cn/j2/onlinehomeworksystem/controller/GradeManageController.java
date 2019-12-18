package cn.j2.onlinehomeworksystem.controller;

import cn.j2.onlinehomeworksystem.entity.Grade;
import cn.j2.onlinehomeworksystem.entity.Result;
import cn.j2.onlinehomeworksystem.service.IGradeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grade")
public class GradeManageController {
    @Autowired
    private IGradeManageService gradeManageService;

    @RequestMapping("/addGradeInfo")
    public Result addGradeInfo(Grade grade){
        Result result = new Result();
        try {
            gradeManageService.addGradeInfo(grade);
        }catch (Exception e){
            result.setCode(500);
            result.setMsg(e.getMessage());
        }
        return result;
    }
}
