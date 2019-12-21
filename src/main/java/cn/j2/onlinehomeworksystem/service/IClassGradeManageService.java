package cn.j2.onlinehomeworksystem.service;


import cn.j2.onlinehomeworksystem.entity.ClassGrade;

import java.util.List;

public interface IClassGradeManageService {
    List selectAllClassGrade();

    ClassGrade selectOneClassGrade(Integer classid);

    int classGradeCompute();
    int deleteAllClassGrade();
}
