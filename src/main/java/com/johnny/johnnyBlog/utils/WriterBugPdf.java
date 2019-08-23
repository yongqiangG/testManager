package com.johnny.johnnyBlog.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.johnny.johnnyBlog.entity.FullTestBug;

public class WriterBugPdf {
		public static String writePdf(FullTestBug bug) throws DocumentException, IOException {
			String module = bug.getModule_name();
			String person = bug.getPerson_name();
			String product = bug.getProduct_name();
			String project = bug.getProject_name();
			String version = bug.getVersion();
			//String content = bug.getBug_content();
			String content_withoutHtml = bug.getBug_content_withoutHtml();
			String title = bug.getBug_title();
			String bugtype = bug.getBugtype_name();
			String deadline = bug.getDeadline().toString();
			String fileName = String.valueOf(new Random().nextInt(1000));
			String newFileName = java.util.UUID.randomUUID().toString(); // 采用时间+UUID的方式随即命名
			String name = newFileName + fileName; // 保存在硬盘中的文件名
			String filepath = "uploadpic/pdf/";
			String pdfPath1 = "http://localhost:8885/"+filepath+name+".pdf";
    		String pdfPath = "D:\\web\\tomcat-8.5.38\\wtpwebapps\\"+filepath+name+".pdf" ;
    		System.out.println(pdfPath);
			//建立document对象
			//第一个参数是页面大小。接下来的参数分别是左、右、上和下页边距
			Document document = new Document(PageSize.A4, 50, 50, 50, 50);
			//建立读写器关联document对象
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
			writer.setStrictImageSequence(true);
			document.open();
			//use font from windows
			//Font font = new Font(BaseFont.createFont("C:/Windows/Fonts/SIMYOU.TTF",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED));
			//use font from itext.jar
			Font font = new Font(BaseFont. createFont( "STSong-Light", "UniGB-UCS2-H" ,BaseFont. NOT_EMBEDDED), 12, Font. NORMAL );
			document.add(new Paragraph("Product: "+product,font));
			document.add(new Paragraph("Module: "+module,font));
			document.add(new Paragraph("Project: "+project,font));
			document.add(new Paragraph("Deadline: "+deadline,font));
			document.add(new Paragraph("Person: "+person,font));
			document.add(new Paragraph("Version: "+version,font));
			document.add(new Paragraph("Bugtype: "+bugtype,font));
			document.add(new Paragraph("Title: "+title,font));
			document.add(new Paragraph("Contents:",font));
			String dest = "";
			if (content_withoutHtml!=null) {
	            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	            Matcher m = p.matcher(content_withoutHtml);
	            dest = m.replaceAll("");
	        }
			String[] dest1 = dest.split("<|>");
			for(String str:dest1) {
				if(str.contains("img")) {
					String imgPath = str.substring(str.indexOf('"')+1,str.indexOf('"',8));
					//读取一个图片
				    Image image = Image.getInstance("D:\\web\\tomcat-8.5.38\\wtpwebapps"+imgPath);
				    if(image.getWidth()>510) {
				    	image.scaleToFit(510, 510);
				    }
				    //插入一个图片
				    document.add(image);
				}else {
					document.add(new Paragraph(str,font));
					System.out.println(str);
				}
			}
			document.close();
			System.out.println("pdf已生成");
			return pdfPath1;
		}
		
		public static void main(String[] args) throws Exception{
			FullTestBug bug = new FullTestBug();
			bug.setBug_content_withoutHtml("111");
			bug.setBug_title("111");
			bug.setBugtype_name("111");
			bug.setDeadline(new Timestamp(System.currentTimeMillis()));
			bug.setModule_name("222");
			bug.setPerson_name("333");
			bug.setProduct_name("4444");
			bug.setVersion("555");
			bug.setProject_name("555");
			WriterBugPdf.writePdf(bug);
		}

}
