package com.ems.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFileChooser;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ImportData {
	public static void main(String[] args){
		
		JFileChooser open = new JFileChooser();
		open.setDialogTitle("��������");
		open.setDialogType(JFileChooser.OPEN_DIALOG);
//		open.showSaveDialog(open);
		open.showOpenDialog(open);
		File selected_file = open.getSelectedFile();
		String filename = selected_file.getAbsoluteFile().toString();
	 InputStream is;
	try {
		
		//����Workbook����,   ֻ��Workbook���� 
		//ֱ�Ӵӱ����ļ�����Workbook 
		//������������Workbook 
		 is = new FileInputStream(filename);
	     Workbook rwb = Workbook.getWorkbook(is);
	     
	     //��ȡ��һ��Sheet�� 
	     Sheet rs = rwb.getSheet(0); 
	     
		 //��ȡ��һ�У���һ�е�ֵ 
	     Cell c00 = null;
	     int row = rs.getRows();
	     int col = rs.getColumns();
	     String data = null;
	     for(int i = 0;i<row;i++){
	    	 for(int j = 0;j<col;j++){
	    		 Cell cell = rs.getCell(j,i); 
	    		 System.out.print(cell.getContents()+"  ");
	    	 }
	    	 System.out.println();
	     }
	     
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (BiffException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} 

	}
}
