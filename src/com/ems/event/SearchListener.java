/**
 * 江庆燕
 */
package com.ems.event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ems.biz.SearchBiz;
import com.ems.biz.impl.SearchBizImpl;
import com.ems.tool.ExportData;
import com.ems.view.SearchFrame;

public class SearchListener extends MouseAdapter{
	
	private SearchFrame sf;
	private JTable table;
	private DefaultTableModel dtm;
	private SearchBiz searchbiz;
	
	public SearchListener(SearchFrame sf){
		this.sf = sf;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		JButton button = (JButton) e.getSource();
		
		String name = button.getName();
		
		if(name.equalsIgnoreCase("btn_search")){//查询
			search();
		}else if(name.equalsIgnoreCase("btn_out")){//导出
			
			
		
				JFileChooser fc_save = new JFileChooser();
				fc_save.setDialogTitle("导出数据");
				fc_save.setDialogType(JFileChooser.SAVE_DIALOG);
				fc_save.showSaveDialog(sf);
				File selected_file = fc_save.getSelectedFile();
				String filename = selected_file.getAbsoluteFile().toString();
				boolean b = false;
				if(selected_file != null)
					//导出数据
					 b = ExportData.exportToExcel(sf.getTable(),filename );
				if(b)
					JOptionPane.showMessageDialog(sf, "已成功将数据导出到："+filename);
		}else if(name.equalsIgnoreCase("btn_delete")){//删除
			delete();			
		}
	}
	
	
	/**
	 * 获取数据
	 * @param degree
	 * @param dept
	 * @param merry
	 * @param job
	 * @param h1
	 * @param h2
	 * @return
	 */
	private Vector<Vector<String>> getData(String sql){				
		//调用业务层
		searchbiz = new SearchBizImpl();
		Vector<Vector<String>> data = searchbiz.search(sql);

		return data;		
	}
	
	/**
	 * 设置表头
	 * @return
	 */
	private Vector<String> getTitle(){
		Vector<String> title = new Vector<String>();
		title.add("编号");
		title.add("姓名");
		title.add("身份证");
		title.add("籍贯");
		title.add("政治面貌");
		title.add("年龄");
		title.add("性别");
		title.add("电话");
		title.add("工龄");
		title.add("学历");
		title.add("岗位");
		title.add("部门");
		title.add("婚姻");
		
		return title;
	}
	
	private void search(){

		//获取界面上输入的查询值
		String degree = sf.getCbx_degree().getSelectedItem().toString();
		System.out.println("degree:"+degree);
		String merry = sf.getCbx_merry().getSelectedItem().toString();
		
		String dept = sf.getCbx_dept().getSelectedItem().toString();
		
		String job = sf.getCbx_job().getSelectedItem().toString();
		
		int h1 = sf.getWorkage1().getAge();
		
		int h2 = sf.getWorkage2().getAge();
		
		if(h1 > h2){
			int temp = h1;
			h1 = h2;
			h2 =temp;
		}
		
		//无条件查询的基本sql语句
		StringBuffer strb = new StringBuffer("select emp.empno,name,identityno,jiguan,emp.zzmm,age,sex,emp.tel,workage,education ,positionname,deptname,ismarry from emp,dept,edu,marry ,enterpriseposition where emp.empno=marry.empno and emp.empno=edu.empno and emp.deptno=dept.deptno and enterpriseposition.positionno=emp.positiono ");
		
		//追加条件限制
		if(!degree.equals("             "))
			strb.append("and education='"+degree+"'");
		if(!merry.equals("             "))
			strb.append("and ismarry='"+merry+"'");
		if(!dept.equals("             "))
			strb.append("and deptname='"+dept+"'");	
		if(!job.equals("             "))
			strb.append("and positionname='"+job+"'");
		if(!(h2==0 && h1==0))
			strb.append("and workage between "+h1+" and "+h2);
		
		//获取表格和表格模型
		dtm = sf.getDataModel();
	
		//给表格重新注入数据
		dtm.setDataVector(getData(strb.toString()), getTitle());
	}
	
	
	private void delete(){
		
		table = sf.getTable();
		int row = table.getSelectedRow();//获取选中行index
		
		if(row == -1)
			JOptionPane.showMessageDialog(sf, "先选择要删除的员工");
		else{
			String empNo = (String) table.getModel().getValueAt(row, 0);//获取选中行第一列值，既员工编号
			String name = (String)table.getModel().getValueAt(row, 1);
			System.out.println("empNo"+empNo);
			
			int result = searchbiz.delete(empNo);//调用业务层，按编号删除员工
			
			if(result > 0){//如果数据库中删除成功，才在显示表中删除行
				dtm.removeRow(row);
			
				JOptionPane.showMessageDialog(sf, "成功删除员工："+name);
			}
			else //删除失败
				JOptionPane.showMessageDialog(sf, "删除失败");
			}
	}
}
