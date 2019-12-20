package cn.j2.onlinehomeworksystem.mapper;


import cn.j2.onlinehomeworksystem.entity.Students;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentDmlMapper {
    int addStudent(Students student);

    int deleteStudent(int id);

    int updateStudent(Students student);

    Students findStudentById(Integer id);

    List<Students> selectStudent(Students student);
}
