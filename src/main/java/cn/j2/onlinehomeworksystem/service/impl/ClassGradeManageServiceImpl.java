package cn.j2.onlinehomeworksystem.service.impl;

import cn.j2.onlinehomeworksystem.entity.ClassGrade;
import cn.j2.onlinehomeworksystem.mapper.IClassGradeManageDaoMapper;
import cn.j2.onlinehomeworksystem.service.IClassGradeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassGradeManageServiceImpl implements IClassGradeManageService {
    @Autowired
    private IClassGradeManageDaoMapper classManageDao;
    @Override
    public List selectAllClassGrade() {
        return classManageDao.selectAllClassGrade();
    }

    @Override
    public ClassGrade selectOneClassGrade(Integer classid) {
        return classManageDao.selectOneClassGrade(classid);
    }

    @Override
    public int deleteAllClassGrade() {
        return classManageDao.deleteAllClassGrade();
    }

    @Override
    public int classGradeCompute() {
        return classManageDao.classGradeCompute();
    }
}
