package cn.j2.onlinehomeworksystem.service.impl;

import cn.j2.onlinehomeworksystem.entity.PGrade;
import cn.j2.onlinehomeworksystem.entity.Students;
import cn.j2.onlinehomeworksystem.mapper.IPGradeManageDaoMapper;
import cn.j2.onlinehomeworksystem.service.IPGradeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PGradeManageServiceImpl implements IPGradeManageService {
    @Autowired
    private IPGradeManageDaoMapper pGradeManageDao;
    @Override
    public List<PGrade> selectPGrade(Students student, String cname, Double minUGrade, Double maxUGrade, Double minFGrade, Double maxFGrade, Double minTGrade, Double maxTGrade) {
        return pGradeManageDao.selectPGrade(student,cname,minUGrade,maxUGrade,minFGrade,maxFGrade,minTGrade,maxTGrade);
    }
}
