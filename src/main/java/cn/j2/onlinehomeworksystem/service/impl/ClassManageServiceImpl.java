package cn.j2.onlinehomeworksystem.service.impl;

import cn.j2.onlinehomeworksystem.mapper.IClassManageDaoMapper;
import cn.j2.onlinehomeworksystem.service.IClassManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import cn.j2.onlinehomeworksystem.entity.Class;

@Service
public class ClassManageServiceImpl implements IClassManageService {
    @Autowired
    private IClassManageDaoMapper classManageDao;
    @Override
    public List<Class> selectAllClassGrade() {
        return classManageDao.selectAllClassGrade();
    }

    @Override
    public Class selectOneClassGrade(Integer classid) {
        return classManageDao.selectOneClassGrade(classid);
    }
}
