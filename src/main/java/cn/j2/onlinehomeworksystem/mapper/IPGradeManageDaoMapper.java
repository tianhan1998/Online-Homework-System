package cn.j2.onlinehomeworksystem.mapper;

import cn.j2.onlinehomeworksystem.entity.Grade;
import cn.j2.onlinehomeworksystem.entity.PGrade;
import cn.j2.onlinehomeworksystem.entity.Students;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPGradeManageDaoMapper {
    List<PGrade> selectPGrade(@Param("student") Students student, @Param("cname") String cname, @Param("minUGrade") Double minUGrade, @Param("maxUGrade") Double maxUGrade, @Param("minFGrade") Double minFGrade, @Param("maxFGrade") Double maxFGrade, @Param("minTGrade") Double minTGrade, @Param("maxTGrade") Double maxTGrade);
}
