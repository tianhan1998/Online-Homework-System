package cn.j2.onlinehomeworksystem.mapper;

import org.springframework.stereotype.Repository;
import cn.j2.onlinehomeworksystem.entity.Class;

import java.util.List;

@Repository
public interface IClassManageDaoMapper {
    List selectAllClass();

    Class selectOneClass(Integer classid);

    int deleteClass(Class aclass);

    int updateClass(Class aclass);

    int addClass(Class aclass);
}
