package cn.j2.onlinehomeworksystem.service.impl;

import cn.j2.onlinehomeworksystem.entity.Course;
import cn.j2.onlinehomeworksystem.mapper.ICourseManageDaoMapper;
import cn.j2.onlinehomeworksystem.service.ICourseManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseManageServiceImpl implements ICourseManageService {
    @Autowired
    private ICourseManageDaoMapper courseManageDao;
    @Override
    public List selectAllCourse() {
        return courseManageDao.selectAllCourse();
    }

    @Override
    public int deleteCourse(Course course) {
        return courseManageDao.deleteCourse(course);
    }

    @Override
    public int updateCourse(Course course) {
        return courseManageDao.updateCourse(course);
    }

    @Override
    public int addCourse(Course course) {
        return courseManageDao.addCourse(course);
    }

    @Override
    public Course selectCourseById(Integer cid) {
        return courseManageDao.selectCourseById(cid);
    }
}
