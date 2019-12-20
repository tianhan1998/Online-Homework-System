package cn.j2.onlinehomeworksystem.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import cn.j2.onlinehomeworksystem.entity.Class;

@Repository
public interface IClassManageDaoMapper {
    List<Class> selectAllClassGrade();

    Class selectOneClassGrade(Integer classid);
}
