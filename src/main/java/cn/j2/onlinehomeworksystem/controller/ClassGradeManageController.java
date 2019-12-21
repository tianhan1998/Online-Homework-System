package cn.j2.onlinehomeworksystem.controller;

import cn.j2.onlinehomeworksystem.entity.ClassGrade;
import cn.j2.onlinehomeworksystem.entity.Result;
import cn.j2.onlinehomeworksystem.service.IClassGradeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classGrade")
public class ClassGradeManageController {
    @Autowired
    private IClassGradeManageService classManageService;
    @RequestMapping("/selectAllClassGrade")
    public Result selectAllClassGrade(){
        Result result = new Result();
        try{
            List classList = classManageService.selectAllClassGrade();
            if(classList!=null){
                result.setCode(200);
                result.setMsg("查询成功");
                result.setData(classList);
            }else {
                result.setData(500);
                result.setMsg("查询失败");
            }
        }catch (Exception e){
            result.setCode(500);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/selectOneClassGrade")
    public Result selectOneClassGrade(Integer classid){
        Result result = new Result();
        try{
            ClassGrade c = classManageService.selectOneClassGrade(classid);
            if(c!=null){
                result.setCode(200);
                result.setMsg("查询成功");
                result.setData(c);
            }else {
                result.setData(500);
                result.setMsg("查询失败");
            }
        } catch (Exception e){
            result.setCode(500);
            result.setMsg(e.getMessage());
        }
        return result;
    }
    @GetMapping("/deleteAllClassGrade")
    public Result deleteAllClassGrade(){
        Result result=new Result();
        try{
            if(classManageService.deleteAllClassGrade()>=0){
                result.setCode(200);
                result.setMsg("清空成功");
            }else{
                result.setCode(500);
                result.setMsg("清空失败");
            }

        }catch (Exception e){
            result.setMsg(e.getMessage());
            result.setCode(500);
        }
        return result;
    }

    @RequestMapping("/classGradeCompute")
    public Result classGradeCompute(){
        Result result = new Result();
        try{
            if(classManageService.classGradeCompute()>0){
                result.setCode(200);
                result.setMsg("班级成绩计算成功");
            }else {
                result.setData(500);
                result.setMsg("班级成绩计算失败");
            }
        } catch (Exception e){
            result.setCode(500);
            result.setMsg(e.getMessage());
        }
        return result;
    }
}
