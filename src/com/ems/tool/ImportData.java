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
		open.setDialogTitle("导入数据");
		open.setDialogType(JFileChooser.OPEN_DIALOG);
//		open.showSaveDialog(open);
		open.showOpenDialog(open);
		File selected_file = open.getSelectedFile();
		String filename = selected_file.getAbsoluteFile().toString();
	 InputStream is;
	try {
		
		//构建Workbook对象,   只读Workbook对象 
		//直接从本地文件创建Workbook 
		//从输入流创建Workbook 
		 is = new FileInputStream(filename);
	     Workbook rwb = Workbook.getWorkbook(is);
	     
	     //获取第一张Sheet表 
	     Sheet rs = rwb.getSheet(0); 
	     
		 //获取第一行，第一列的值 
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
