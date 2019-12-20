package cn.j2.onlinehomeworksystem.controller;

import cn.j2.onlinehomeworksystem.entity.Result;
import cn.j2.onlinehomeworksystem.service.IClassManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.j2.onlinehomeworksystem.entity.Class;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassManageController {
    @Autowired
    private IClassManageService classManageService;
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
            Class c = classManageService.selectOneClassGrade(classid);
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
}
