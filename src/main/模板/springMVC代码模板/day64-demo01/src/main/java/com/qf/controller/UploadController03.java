package com.qf.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/14
 */
@Controller
@RequestMapping("/upload03")
public class UploadController03 {
    @RequestMapping("/up01")
    public String up01(MultipartFile multipartFile,HttpSession session) throws IOException {
        //获取需要存入的路径
        String realPath = session.getServletContext().getRealPath("/files");
//        System.out.println("realPath = " + realPath);
        //获取原始文件名
        String filename = multipartFile.getOriginalFilename();

        //生成唯一的文件名
        String uniqueName = UUID.randomUUID().toString();
        uniqueName=uniqueName.replaceAll("-","");
        System.out.println("uniqueName = " + uniqueName);

        //获取文件的后缀名
        String extName = FilenameUtils.getExtension(filename);
        //拼接文件的后缀名
        filename=uniqueName+"."+extName;
//        System.out.println("extName = " + extName);
        //把文件写入服务器
        multipartFile.transferTo(new File(realPath+"\\"+filename));


        //储存文件的时候文件名需要什么操作？保证文件名的唯一性
        return "index";
    }

}
