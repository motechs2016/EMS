package com.ems.tool;

import java.io.File;
import java.io.IOException;
import javax.swing.JTable;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExportData {
	
	public static boolean exportToExcel(JTable table,String filePath){
		boolean result = false;
		
		try {
			//打开文件
			WritableWorkbook book=Workbook.createWorkbook(new File(filePath));
			
			//生成第一页的工作表
			WritableSheet sheet = book.createSheet("sheet1",0);
			
			//列数
			int columnCount = table.getColumnCount();
			//行数
			int rowCount = table.getRowCount();

			//设置字体
			WritableFont font1 = new WritableFont(WritableFont.createFont("黑体"),14, WritableFont.NO_BOLD);
			
			WritableCellFormat format1 = new WritableCellFormat(font1);
			
			WritableFont font2 = new WritableFont(WritableFont.TIMES,12);
			WritableCellFormat format2 = new WritableCellFormat(font2);
			
			//在Label对象的构造子中指名单元格位置是第一列第一行(0,0) 
			Label label = null;
			
			for(int i=0;i<columnCount;i++){
				
				//将列名写入第一行
				String columnName = table.getColumnName(i);
				label = new Label(i,0,columnName,format1);
				sheet.addCell(label);
				
				//每一列下面的值
				for(int j=0;j<rowCount;j++){
					
					String value = table.getValueAt(j,i).toString();
					
					//j要加1，要去掉表头行
					label = new Label(i,j+1,value,format2);
					
					sheet.addCell(label);					
				}
			}
			
			book.write();
			book.close();
			
			result = true;
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}	
}