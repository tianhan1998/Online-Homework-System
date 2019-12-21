package cn.j2.onlinehomeworksystem.service;

import java.util.List;
import cn.j2.onlinehomeworksystem.entity.Class;

public interface IClassManageService {
    List selectAllClass();

    Class selectOneClass(Integer classid);

    int deleteClass(Class aclass);

    int updateClass(Class aclass);

    int addClass(Class aclass);
}
