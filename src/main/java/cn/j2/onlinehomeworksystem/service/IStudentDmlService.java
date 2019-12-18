package cn.j2.onlinehomeworksystem.service;


import cn.j2.onlinehomeworksystem.entity.Students;

import java.util.List;

public interface IStudentDmlService {
    int addStudent(Students student);

    int deleteStudent(int sid);

    int updateStudent(Students student);

    List<Students> selectStudent(Students student);
}
