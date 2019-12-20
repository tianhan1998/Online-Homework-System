package cn.j2.onlinehomeworksystem.mapper;

import cn.j2.onlinehomeworksystem.entity.Grade;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGradeManageDaoMapper {
    int addGradeInfo(Grade grade);

    int deleteGradeInfo(@Param("sid") Integer sid, @Param("cname") String cname);

    List<Grade> selectGradeInfo(@Param("sid") Integer sid, @Param("cname") String cname, @Param("minUGrade") Double minUGrade, @Param("maxUGrade") Double maxUGrade, @Param("minFGrade") Double minFGrade, @Param("maxFGrade") Double maxFGrade, @Param("minTGrade") Double minTGrade, @Param("maxTGrade") Double maxTGrade);
}
