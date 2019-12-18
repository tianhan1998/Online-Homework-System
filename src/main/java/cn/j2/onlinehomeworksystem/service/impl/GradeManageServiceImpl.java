package cn.j2.onlinehomeworksystem.service.impl;
import cn.j2.onlinehomeworksystem.entity.Grade;
import cn.j2.onlinehomeworksystem.mapper.IGradeManageMapper;
import cn.j2.onlinehomeworksystem.service.IGradeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeManageServiceImpl implements IGradeManageService {
    @Autowired
    private IGradeManageMapper gradeManageDao;
    @Override
    public int addGradeInfo(Grade grade) {

        return gradeManageDao.addGradeInfo(grade);
    }
}
