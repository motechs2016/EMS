package com.ems.tool;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class Test {

	public static void main(String[] args) {
		
		try {
			//打开文件
			WritableWorkbook book=Workbook.createWorkbook(new File("d://测试.xls"));
			
			//生成第一页的工作表
			WritableSheet sheet = book.createSheet("第一页",0);
			
			//在Label对象的构造子中指名单元格位置是第一列第一行(0,0) 
			Label label = new Label(0,0,"nihao");
			
			sheet.addCell(label);
			label = new Label(1,1,"hello");
			sheet.addCell(label);
			
			book.write();
			book.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//导入数据到table
		
		String fileName = "d://测试.xls";
		
		try {
			//打开文件
			Workbook book = Workbook.getWorkbook(new File(fileName));
			
			//获取工作对象
			Sheet sheet = book.getSheet(0);
			
			//行数
			int column = sheet.getColumns();
			
			//列数
			int row = sheet.getRows();
			
			for(int i=0;i<column;i++){

				Cell cell = sheet.getCell(i,0);
				
				String str = cell.getContents();
				
				
				
			}
			
			
			
			
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
}
