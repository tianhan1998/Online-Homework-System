package cn.j2.onlinehomeworksystem.service.impl;

import cn.j2.onlinehomeworksystem.mapper.IClassManageDaoMapper;
import cn.j2.onlinehomeworksystem.service.IClassManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.j2.onlinehomeworksystem.entity.Class;

import java.util.List;

@Service
public class ClassManageServiceImpl implements IClassManageService {
    @Override
    public int addClass(Class aclass) {
        return classManageDao.addClass(aclass);
    }

    @Override
    public int deleteClass(Class aclass) {
        return classManageDao.deleteClass(aclass);
    }

    @Override
    public int updateClass(Class aclass) {
        return classManageDao.updateClass(aclass);
    }

    @Autowired
    private IClassManageDaoMapper classManageDao;
    @Override
    public List selectAllClass() {
        return classManageDao.selectAllClass();
    }

    @Override
    public Class selectOneClass(Integer classid) {
        return classManageDao.selectOneClass(classid);
    }
}
