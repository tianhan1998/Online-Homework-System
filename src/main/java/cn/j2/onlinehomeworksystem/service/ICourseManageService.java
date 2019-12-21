package cn.j2.onlinehomeworksystem.service;


import cn.j2.onlinehomeworksystem.entity.Course;

import java.util.List;

public interface ICourseManageService {
    List<Course> selectAllCourse();

    Course selectCourseById(Integer cid);

    int deleteCourse(Course course);

    int updateCourse(Course course);

    int addCourse(Course course);
}
