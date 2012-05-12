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
			//���ļ�
			WritableWorkbook book=Workbook.createWorkbook(new File(filePath));
			
			//���ɵ�һҳ�Ĺ�����
			WritableSheet sheet = book.createSheet("sheet1",0);
			
			//����
			int columnCount = table.getColumnCount();
			//����
			int rowCount = table.getRowCount();

			//��������
			WritableFont font1 = new WritableFont(WritableFont.createFont("����"),14, WritableFont.NO_BOLD);
			
			WritableCellFormat format1 = new WritableCellFormat(font1);
			
			WritableFont font2 = new WritableFont(WritableFont.TIMES,12);
			WritableCellFormat format2 = new WritableCellFormat(font2);
			
			//��Label����Ĺ�������ָ����Ԫ��λ���ǵ�һ�е�һ��(0,0) 
			Label label = null;
			
			for(int i=0;i<columnCount;i++){
				
				//������д���һ��
				String columnName = table.getColumnName(i);
				label = new Label(i,0,columnName,format1);
				sheet.addCell(label);
				
				//ÿһ�������ֵ
				for(int j=0;j<rowCount;j++){
					
					String value = table.getValueAt(j,i).toString();
					
					//jҪ��1��Ҫȥ����ͷ��
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