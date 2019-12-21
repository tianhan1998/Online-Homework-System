package cn.j2.onlinehomeworksystem.mapper;

import cn.j2.onlinehomeworksystem.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseManageDaoMapper {
    List selectAllCourse();

    Course selectCourseById(Integer cid);

    int deleteCourse(Course course);

    int updateCourse(Course course);

    int addCourse(Course course);
}
