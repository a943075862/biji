package com.qf.controller;

import com.sun.deploy.net.HttpResponse;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/14
 */
@Controller
@RequestMapping("/down")
public class DownloadController {
    /**
     * 下载文件
     * @param filename
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping("/down01")
    public void down01(String filename, HttpSession session, HttpServletResponse response) throws IOException {
        //下载目标文件的名字
        System.out.println("filename = " + filename);
        //获得下载文件的绝对路径
        String Path = session.getServletContext().getRealPath("/files");
        //文件完整路径
        String realPath=Path+"\\"+filename;
        //设置响应头，告知浏览器,要以附件的形式保持内容 filename=浏览器显示的下载文件名
        response.setHeader("content-disposition","attachment;filename="+filename);
        //读取目标文件，写出给客户端
        IOUtils.copy(new FileInputStream(realPath),response.getOutputStream());

        //上一步已是响应了，所以此handler直接是void

    }

}
