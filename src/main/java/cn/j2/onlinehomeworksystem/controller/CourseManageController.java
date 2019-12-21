package cn.j2.onlinehomeworksystem.controller;

import cn.j2.onlinehomeworksystem.entity.Class;
import cn.j2.onlinehomeworksystem.entity.Course;
import cn.j2.onlinehomeworksystem.entity.Result;
import cn.j2.onlinehomeworksystem.service.ICourseManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseManageController {
    @Autowired
    private ICourseManageService courseManageService;

    @RequestMapping("/selectAllCourse")
    public Result selectAllCourse(){
        Result result = new Result();
        try{
            List<Course> courseList= courseManageService.selectAllCourse();
            if(courseList!=null){
                result.setCode(200);
                result.setMsg("查询课程成功");
                result.setData(courseList);
            }else {
                result.setCode(500);
                result.setMsg("查询课程失败");
            }
        }catch (Exception e){
            result.setCode(500);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/selectByIdCourse")
    public Result selectByIdCourse(Integer cid){
        Result result = new Result();
        System.out.println(cid);
        try{
            Course course = courseManageService.selectCourseById(cid);
            if(course!=null){
                result.setCode(200);
                result.setMsg("查询课程成功");
                result.setData(course);
            }else {
                result.setCode(500);
                result.setMsg("查询课程失败");
            }
        }catch (Exception e){
            result.setCode(500);
            result.setMsg(e.getMessage());
        }
        return result;
    }
    @RequestMapping("/deleteCourse")
    public Result deleteCourse(Course course){
        System.out.println(course);
        Result result = new Result();
        try {
            if (courseManageService.deleteCourse(course) > 0) {
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
    @RequestMapping(value = "/addCourse",method = RequestMethod.POST)
    public Result addStudent(Course course){
        Result result = new Result();
        try {
            if (courseManageService.addCourse(course) > 0) {
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
    @RequestMapping(value = "/updateCourse",method = RequestMethod.POST)
    public Result updateClass(Course course){
        System.out.println("updatestudents======="+course);
        Result result = new Result();
        try {
            if (courseManageService.updateCourse(course) > 0) {
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
