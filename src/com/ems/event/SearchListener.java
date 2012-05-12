/**
 * ������
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
		
		if(name.equalsIgnoreCase("btn_search")){//��ѯ
			search();
		}else if(name.equalsIgnoreCase("btn_out")){//����
			
			
		
				JFileChooser fc_save = new JFileChooser();
				fc_save.setDialogTitle("��������");
				fc_save.setDialogType(JFileChooser.SAVE_DIALOG);
				fc_save.showSaveDialog(sf);
				File selected_file = fc_save.getSelectedFile();
				String filename = selected_file.getAbsoluteFile().toString();
				boolean b = false;
				if(selected_file != null)
					//��������
					 b = ExportData.exportToExcel(sf.getTable(),filename );
				if(b)
					JOptionPane.showMessageDialog(sf, "�ѳɹ������ݵ�������"+filename);
		}else if(name.equalsIgnoreCase("btn_delete")){//ɾ��
			delete();			
		}
	}
	
	
	/**
	 * ��ȡ����
	 * @param degree
	 * @param dept
	 * @param merry
	 * @param job
	 * @param h1
	 * @param h2
	 * @return
	 */
	private Vector<Vector<String>> getData(String sql){				
		//����ҵ���
		searchbiz = new SearchBizImpl();
		Vector<Vector<String>> data = searchbiz.search(sql);

		return data;		
	}
	
	/**
	 * ���ñ�ͷ
	 * @return
	 */
	private Vector<String> getTitle(){
		Vector<String> title = new Vector<String>();
		title.add("���");
		title.add("����");
		title.add("���֤");
		title.add("����");
		title.add("������ò");
		title.add("����");
		title.add("�Ա�");
		title.add("�绰");
		title.add("����");
		title.add("ѧ��");
		title.add("��λ");
		title.add("����");
		title.add("����");
		
		return title;
	}
	
	private void search(){

		//��ȡ����������Ĳ�ѯֵ
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
		
		//��������ѯ�Ļ���sql���
		StringBuffer strb = new StringBuffer("select emp.empno,name,identityno,jiguan,emp.zzmm,age,sex,emp.tel,workage,education ,positionname,deptname,ismarry from emp,dept,edu,marry ,enterpriseposition where emp.empno=marry.empno and emp.empno=edu.empno and emp.deptno=dept.deptno and enterpriseposition.positionno=emp.positiono ");
		
		//׷����������
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
		
		//��ȡ���ͱ��ģ��
		dtm = sf.getDataModel();
	
		//���������ע������
		dtm.setDataVector(getData(strb.toString()), getTitle());
	}
	
	
	private void delete(){
		
		table = sf.getTable();
		int row = table.getSelectedRow();//��ȡѡ����index
		
		if(row == -1)
			JOptionPane.showMessageDialog(sf, "��ѡ��Ҫɾ����Ա��");
		else{
			String empNo = (String) table.getModel().getValueAt(row, 0);//��ȡѡ���е�һ��ֵ����Ա�����
			String name = (String)table.getModel().getValueAt(row, 1);
			System.out.println("empNo"+empNo);
			
			int result = searchbiz.delete(empNo);//����ҵ��㣬�����ɾ��Ա��
			
			if(result > 0){//������ݿ���ɾ���ɹ���������ʾ����ɾ����
				dtm.removeRow(row);
			
				JOptionPane.showMessageDialog(sf, "�ɹ�ɾ��Ա����"+name);
			}
			else //ɾ��ʧ��
				JOptionPane.showMessageDialog(sf, "ɾ��ʧ��");
			}
	}
}
