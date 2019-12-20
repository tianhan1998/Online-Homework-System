package cn.j2.onlinehomeworksystem.service;


import cn.j2.onlinehomeworksystem.entity.Grade;

import java.util.List;

public interface IGradeManageService {
    int addGradeInfo(Grade grade);

    int deleteGradeInfo(Integer sid, String cname);

    List<Grade> selectGradeInfo(Integer sid, String cname, Double minUGrade, Double maxUGrade, Double minFGrade, Double maxFGrade, Double minTGrade, Double maxTGrade);

}
