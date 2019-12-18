package cn.j2.onlinehomeworksystem.mapper;


import cn.j2.onlinehomeworksystem.entity.Grade;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradeManageMapper {
    int addGradeInfo(Grade grade);
}
