package cn.j2.onlinehomeworksystem.service;

import java.util.List;
import cn.j2.onlinehomeworksystem.entity.Class;

public interface IClassManageService {
    List<Class> selectAllClassGrade();

    Class selectOneClassGrade(Integer classid);
}
