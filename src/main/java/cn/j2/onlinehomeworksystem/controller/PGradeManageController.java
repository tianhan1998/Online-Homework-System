package cn.j2.onlinehomeworksystem.controller;

import cn.j2.onlinehomeworksystem.entity.PGrade;
import cn.j2.onlinehomeworksystem.entity.Result;
import cn.j2.onlinehomeworksystem.entity.Students;
import cn.j2.onlinehomeworksystem.service.IPGradeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pgrade")
public class PGradeManageController {
    @Autowired
    private IPGradeManageService pGradeManageService;

    @RequestMapping("/selectPGrade.do")
    public Result selectPGrade(Students student, String cname, Double minUGrade, Double maxUGrade, Double minFGrade, Double maxFGrade, Double minTGrade, Double maxTGrade){
        Result result = new Result();
        try{
            List<PGrade> pGradeList = pGradeManageService.selectPGrade(student,cname,minUGrade,maxUGrade,minFGrade,maxFGrade,minTGrade,maxTGrade);
            if(pGradeList!=null){
                result.setCode(200);
                result.setMsg("查询成功");
                result.setData(pGradeList);
            }else{
                result.setCode(500);
                result.setMsg("查询失败");
            }
        } catch (Exception e){
            result.setCode(500);
            result.setMsg(e.getMessage());
        }
        return result;
    }
}
