package cn.j2.onlinehomeworksystem.service.impl;

import cn.j2.onlinehomeworksystem.entity.Students;
import cn.j2.onlinehomeworksystem.mapper.IStudentDmlMapper;
import cn.j2.onlinehomeworksystem.service.IStudentDmlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDmlServiceImpl implements IStudentDmlService {
    @Autowired
    private IStudentDmlMapper stDmlDao;
    @Override
    public int addStudent(Students student) {
        return stDmlDao.addStudent(student);
    }

    @Override
    public int deleteStudent(int sid) {
        return stDmlDao.deleteStudent(sid);
    }

    @Override
    public int updateStudent(Students student) {
        return stDmlDao.updateStudent(student);
    }

    @Override
    public List<Students> selectStudent(Students student) {
        List<Students> list = stDmlDao.selectStudent(student);
        return list;
    }

}
