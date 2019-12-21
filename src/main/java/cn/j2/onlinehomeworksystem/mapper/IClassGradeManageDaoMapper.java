package cn.j2.onlinehomeworksystem.mapper;


import cn.j2.onlinehomeworksystem.entity.ClassGrade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClassGradeManageDaoMapper {
    List<ClassGrade> selectAllClassGrade();

    ClassGrade selectOneClassGrade(Integer classid);

    int classGradeCompute();
    int deleteAllClassGrade();
}
