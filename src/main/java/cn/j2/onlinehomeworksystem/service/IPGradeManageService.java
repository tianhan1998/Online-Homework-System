package cn.j2.onlinehomeworksystem.service;


import cn.j2.onlinehomeworksystem.entity.PGrade;
import cn.j2.onlinehomeworksystem.entity.Students;

import java.util.List;

public interface IPGradeManageService {
    List<PGrade> selectPGrade(Students student, String cname, Double minUGrade, Double maxUGrade, Double minFGrade, Double maxFGrade, Double minTGrade, Double maxTGrade);
}
