package cn.j2.onlinehomeworksystem.controller;

import cn.j2.onlinehomeworksystem.entity.Grade;
import cn.j2.onlinehomeworksystem.entity.Result;
import cn.j2.onlinehomeworksystem.service.IGradeManageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeManageController {
    @Autowired
    private IGradeManageService gradeManageService;

    @RequestMapping("/addGradeInfo")
    public Result addGradeInfo(Grade grade){
        Result result = new Result();
        if(gradeManageService.addGradeInfo(grade)>0){
            result.setMsg("添加成绩成功");
            result.setCode(200);
            result.setData(grade);
        } else{
            result.setCode(500);
            result.setMsg("添加成绩失败");
        }

        return result;
    }
    @RequestMapping("/deleteGradeInfo")
    public Result deleteGradeInfo(@Param("sid") Integer sid, String cname){
        System.out.println("sid的值是：---" + sid);
        System.out.println("cname的值是：---" + cname );
        Result result = new Result();
        if(gradeManageService.deleteGradeInfo(sid,cname)>0){
            result.setMsg("删除成绩成功");
            result.setCode(200);
        } else{
            result.setCode(500);
            result.setMsg("删除成绩失败");
        }
        return result;
    }

    @RequestMapping("/selectGradeInfo")
    public Result selectGradeInfo(Integer sid, String cname, Double minUGrade, Double maxUGrade, Double minFGrade, Double maxFGrade, Double minTGrade, Double maxTGrade, HttpSession session){
        Result result = new Result();
        List<Grade> gradeList = gradeManageService.selectGradeInfo(sid,cname,minUGrade,maxUGrade,minFGrade,maxFGrade,minTGrade,maxTGrade);
        session.setAttribute("gradeList",gradeList);
        if(gradeList!=null){
            result.setMsg("搜索成绩成功");
            result.setCode(200);
            result.setData(gradeList);
        } else{
            result.setCode(500);
            result.setMsg("搜索成绩失败");
        }

        return result;
    }
}
