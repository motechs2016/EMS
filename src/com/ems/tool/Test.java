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
			//���ļ�
			WritableWorkbook book=Workbook.createWorkbook(new File("d://����.xls"));
			
			//���ɵ�һҳ�Ĺ�����
			WritableSheet sheet = book.createSheet("��һҳ",0);
			
			//��Label����Ĺ�������ָ����Ԫ��λ���ǵ�һ�е�һ��(0,0) 
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
		
		
		//�������ݵ�table
		
		String fileName = "d://����.xls";
		
		try {
			//���ļ�
			Workbook book = Workbook.getWorkbook(new File(fileName));
			
			//��ȡ��������
			Sheet sheet = book.getSheet(0);
			
			//����
			int column = sheet.getColumns();
			
			//����
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
