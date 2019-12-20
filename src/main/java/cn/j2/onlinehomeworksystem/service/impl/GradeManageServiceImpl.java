package cn.j2.onlinehomeworksystem.service.impl;
import cn.j2.onlinehomeworksystem.entity.Grade;
import cn.j2.onlinehomeworksystem.mapper.IGradeManageDaoMapper;
import cn.j2.onlinehomeworksystem.service.IGradeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeManageServiceImpl implements IGradeManageService {
    @Autowired
    private IGradeManageDaoMapper gradeManageDao;
    @Override
    public int addGradeInfo(Grade grade) {
        return gradeManageDao.addGradeInfo(grade);
    }

    @Override
    public int deleteGradeInfo(Integer sid, String cname) {
        return gradeManageDao.deleteGradeInfo(sid,cname);
    }

    @Override
    public List<Grade> selectGradeInfo(Integer sid, String cname, Double minUGrade, Double maxUGrade, Double minFGrade, Double maxFGrade, Double minTGrade, Double maxTGrade) {
        return gradeManageDao.selectGradeInfo(sid,cname,minUGrade,maxUGrade,minFGrade,maxFGrade,minTGrade,maxTGrade);
    }
}
