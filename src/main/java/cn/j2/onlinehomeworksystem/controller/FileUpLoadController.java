package cn.j2.onlinehomeworksystem.controller;

import cn.j2.onlinehomeworksystem.entity.Result;
import cn.j2.onlinehomeworksystem.utils.SimHashUtils;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


@Controller
public class FileUpLoadController {
    @RequestMapping(value = "/fileUpLoad",method = RequestMethod.POST)
    public String upLoad(MultipartFile file, Model request) {
        System.out.println(file);
        if(file!=null){
            try {
                String path = "C:\\fileWork";
                String filename = UUID.randomUUID() + "-" + file.getOriginalFilename();
                if (filename.endsWith(".docx") || filename.endsWith(".doc")) {
                    File files = new File(path, filename);
                    if(!files.exists()){
                        files.mkdirs();
                    }
                    file.transferTo(files);
                    request.addAttribute("code",200);
                    request.addAttribute("msg","上传成功");
                } else {
                    request.addAttribute("code",500);
                    request.addAttribute("msg","文件类型错误");
                }
            }catch(Exception e){
                request.addAttribute("code",500);
                request.addAttribute("msg",e.getMessage());
            }
        }else {
            request.addAttribute("code",500);
            request.addAttribute("msg","文件不存在");
        }
        return "homeworkUpload";
    }
    @RequestMapping(value = "/checkHomeworkFileUpLoad",method = RequestMethod.POST)
    public String upLoadCheck(MultipartFile file, Model request) throws IOException {
        try {
            InputStream fis=file.getInputStream();
            XWPFDocument xdoc = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            String doc1 = extractor.getText();
            SimHashUtils.test(doc1);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "checkHomeworkUpload";
    }
}
