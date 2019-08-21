package com.johnny.johnnyBlog.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
/**
 * 用来处理kindeditor图片上传
 * @author johnny
 * 上传路径uploadpic
 * 保存图片后返回值
 * 存储完毕：{"error":0,"url":"XXX/XXX/XXX.XXX"}
 * 存储失败：{"error":1,"message":"图片/文件上传错误！"}
 */
@Controller
@RequestMapping("upload")
public class UploadController {
	@RequestMapping(value = "/uploadController.do", produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public void upload(HttpServletRequest request, HttpServletResponse response) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("imgFile");
		PrintWriter out = null;
		String tips = "{\"error\": 1,\"message\": \"图片上传错误！\"}";
        try {
        	String name = "";
        	out = response.getWriter();
        	if(!file.isEmpty()) {
        		Calendar now = Calendar.getInstance();
        		String filepath="uploadpic/"+now.get(Calendar.YEAR)+"/"+(now.get(Calendar.MONTH) + 1)+"/"+now.get(Calendar.DAY_OF_MONTH);
        		//文件保存路径
        		//String path = request.getSession().getServletContext().getRealPath("/")+filepath ;
        		String path = "D:\\web\\tomcat-8.5.38\\wtpwebapps\\"+filepath ;
				
				File f = new File(path); // 判断文件夹是否存在 如果不存在则创建
				if (!f.exists()) {
					f.mkdirs();
					System.out.println("创建新文件夹"+path);
				}
				//获取原文件名
				String fileName = file.getOriginalFilename();
				String newFileName = java.util.UUID.randomUUID().toString(); // 采用时间+UUID的方式随即命名
				name = newFileName + fileName.substring(fileName.lastIndexOf(".")); // 保存在硬盘中的文件名
				//转存文件
				file.transferTo(new File(path+File.separator+name));
				//返回数据
				java.io.File file1 = new java.io.File(path+File.separator+name);
				if(file1.exists()){
					//tips = "{\"error\": 0,\"url\": \"../../johnnyBlog/"+filepath+"/"+name+"\"}";
					tips = "{\"error\": 0,\"url\": \"../../"+filepath+"/"+name+"\"}";
				}
        	}
        }catch (IOException e) {
			e.printStackTrace();
		} finally{
			out.println(tips);
			out.flush();
			out.close();
		}
	}}