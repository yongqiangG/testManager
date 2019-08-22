package com.johnny.johnnyBlog.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class WriterBugPdf {
		public static void writePdf() throws FileNotFoundException, DocumentException {
			//建立document对象
			//第一个参数是页面大小。接下来的参数分别是左、右、上和下页边距
			Document document = new Document(PageSize.A4, 50, 50, 50, 50);
			//建立读写器关联document对象
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\test11.pdf"));
			document.open();
			document.add(new Paragraph("this is a pdf by johnny"));
			document.close();
		}
		
		public static void main(String[] args) throws Exception{
			WriterBugPdf.writePdf();
		}

}
