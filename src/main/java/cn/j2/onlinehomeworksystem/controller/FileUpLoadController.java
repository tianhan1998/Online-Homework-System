package cn.j2.onlinehomeworksystem.controller;

import cn.j2.onlinehomeworksystem.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;


@RestController
public class FileUpLoadController {
    @RequestMapping("/fileUpLoad")
    public Result upLoad(MultipartFile word) {
        Result result = new Result();
        if(word!=null){
            try {
                String path = "C:\\fileWork";
                String filename = UUID.randomUUID() + "-" + word.getOriginalFilename();
                if (filename.endsWith(".docx") || filename.endsWith(".doc")) {
                    File files = new File(path, filename);
                    word.transferTo(files);
                    result.setCode(200);
                    result.setMsg("文件上传成功");
                } else {
                    result.setCode(500);
                    result.setMsg("上传文件类型不符");
                }
            }catch(Exception e){
                result.setCode(500);
                result.setMsg(e.getMessage());
            }
        }else {
            result.setCode(500);
            result.setMsg("上传文件失败或文件不存在");
        }
        return result;
    }
}
