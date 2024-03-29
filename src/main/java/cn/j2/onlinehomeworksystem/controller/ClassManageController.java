package cn.j2.onlinehomeworksystem.controller;

import cn.j2.onlinehomeworksystem.entity.Class;
import cn.j2.onlinehomeworksystem.entity.Result;
import cn.j2.onlinehomeworksystem.entity.Students;
import cn.j2.onlinehomeworksystem.service.IClassManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassManageController {
    @Autowired
    private IClassManageService classManageService;

    @RequestMapping("/selectAllClass")
    public Result selectAllClass(){
        Result result = new Result();
        try{
            List<Class> classList= classManageService.selectAllClass();
            if(classList!=null){
                result.setCode(200);
                result.setMsg("查询成功");
                result.setData(classList);
            }else {
                result.setCode(500);
                result.setMsg("查询失败");
            }
        }catch (Exception e){
            result.setCode(500);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/selectOneClass")
    public Result selectOneClass(Integer classid){
        Result result = new Result();
        try{
            Class c= classManageService.selectOneClass(classid);
            if(c!=null){
                result.setCode(200);
                result.setMsg("查询成功");
                result.setData(c);
            }else {
                result.setCode(500);
                result.setMsg("查询失败");
            }
        }catch (Exception e){
            result.setCode(500);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/deleteClass")
    public Result deleteClass(Class aclass){
        Result result = new Result();
        try {
            if (classManageService.deleteClass(aclass) > 0) {
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
    @RequestMapping(value = "/addClass",method = RequestMethod.POST)
    public Result addStudent(Class aclass){
        Result result = new Result();
        try {
            if (classManageService.addClass(aclass) > 0) {
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
    @RequestMapping(value = "/updateClass",method = RequestMethod.POST)
    public Result updateClass(Class aclass){
        System.out.println("updatestudents======="+aclass);
        Result result = new Result();
        try {
            if (classManageService.updateClass(aclass) > 0) {
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
}
