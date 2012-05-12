package com.ems.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.ems.event.SearchListener;
import com.ems.tool.ComponentTool;
import com.ems.tool.GBC;

public class SearchFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JComboBox cbx_degree,cbx_merry,cbx_job,cbx_dept;
	
	private ComponentTool.AgePanel workage1,workage2;
	
	private JButton btn_search,btn_out,btn_delete;
	
	private JTable table;
	
	private DefaultTableModel dataModel;
	
	private static final String windows  = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

	
	
	//�ڵ�ǰ�����ʱ�����Ƥ������
	{
		try {
			UIManager.setLookAndFeel(windows); //�������һ���ⲿ���
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public SearchFrame(){
		
		initFrame();
		initAction();
		this.setTitle("��ѯ");
		this.setIconImage(new ImageIcon("images/search.gif").getImage());
		this.setSize(1000,700);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	/**
	 * ��ʼ������
	 */
	public void initFrame(){
		Container container = this.getContentPane();
		container.add(mainPanel());
	}
	
	/**
	 * ���ע�������
	 */
	public void initAction(){
		
		//����ťע����������
		SearchListener sl = new SearchListener(this);		
		btn_search.addMouseListener(sl);		
		btn_out.addMouseListener(sl);
		btn_delete.addMouseListener(sl);
		
		
	}
	
	/**
	 * �����壺��ѯ������ѡ��
	 * @return
	 */
	private JPanel getsearchPanel(){
		
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new GridBagLayout());
		searchPanel.setPreferredSize(new Dimension(170,400));
//		leftPanel.setLayout(new GridLayout(5,2));
		
		JLabel l_degree = new JLabel("��ѧ��:");
		JLabel l_merry = new JLabel("������:");
		JLabel l_job = new JLabel("����λ:");
		JLabel l_dept = new JLabel("������:");
		JLabel l_hiredate = new JLabel("������:");
		JLabel l_part = new JLabel("--");
		
		//ѧ��������
		Vector<String> v_degree = new Vector<String>();
		v_degree.add("             ");
		v_degree.add("��ʿ");
		v_degree.add("˶ʿ");
		v_degree.add("����");
		v_degree.add("����");
		v_degree.add("����");
		v_degree.add("Сѧ");
		cbx_degree = new JComboBox(v_degree);
		
		//����״��������
		Vector<String> v_merry = new Vector<String>();
		v_merry.add("             ");
		v_merry.add("�ѻ�");
		v_merry.add("δ��");		
		cbx_merry = new JComboBox(v_merry);
		
		//����ѡ��
		workage1 = new ComponentTool.AgePanel();
		workage2 = new ComponentTool.AgePanel();
		
		//��λ������
		Vector<String> v_job = new Vector<String>();
		v_job.add("             ");
		v_job.add("���ž���");
		v_job.add("�ܹ�ʦ");
		v_job.add("���繤��ʦ");
		v_job.add("���Է���Ա");
		v_job.add("��Ŀ����");
		v_job.add("�������ʦ");
		v_job.add("����Ա");
		v_job.add("�ͷ�Ա");
		cbx_job = new JComboBox(v_job);
		
		//����������
		Vector<String> v_dept = new Vector<String>();
		v_dept.add("             ");
		v_dept.add("������");
		v_dept.add("�г���");
		v_dept.add("���Բ�");
		v_dept.add("�ͷ���");
		cbx_dept = new JComboBox(v_dept);
			
		searchPanel.add(l_degree,new GBC(0,0,1,3).setInset(20,0,20,0));
		searchPanel.add(cbx_degree,new GBC(1,0,1,3));
		
		searchPanel.add(l_merry,new GBC(0,3,1,3).setInset(20,0,20,0));
		searchPanel.add(cbx_merry,new GBC(1,3,1,3));
		
		searchPanel.add(l_job,new GBC(0,6,1,3).setInset(20,0,20,0));
		searchPanel.add(cbx_job,new GBC(1,6,1,3));
		
		searchPanel.add(l_dept,new GBC(0,9,1,3).setInset(20,0,20,0));
		searchPanel.add(cbx_dept,new GBC(1,9,1,3));
		
		searchPanel.add(l_hiredate,new GBC(0,12));
		searchPanel.add(workage1,new GBC(1,12).setFill(GBC.BOTH));
		
		searchPanel.add(l_part,new GBC(1,13));
		searchPanel.add(workage2,new GBC(1,14).setFill(GBC.BOTH));

		
		return searchPanel;
	}
	
	/**
	 * �ұ���壺�����ǽ����ʾ̨�������ǲ�����ť��
	 * @return
	 */
	private JPanel getrightPanel(){
		JPanel centerPanel =  new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setSize(600, 400);
		centerPanel.setBorder(BorderFactory.createTitledBorder("��ѯ���"));
		
		centerPanel.add(cnterPanel());
		centerPanel.add(buttomPanel(),BorderLayout.SOUTH);
		return centerPanel;
	}
	
	/**
	 * �����壺�����ǲ�ѯ������������ȷ����ť��
	 * @return
	 */
	private JPanel getleftPanel(){
		JPanel leftPanel =  new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setBorder(BorderFactory.createTitledBorder("ѡ���ѯ����"));
		leftPanel.add(getsearchPanel(),BorderLayout.NORTH);
		leftPanel.add(leftButtomPanel());
		return leftPanel;
	}
	
	/**
	 * �ָ����:�����ѡ���������ұ��ǽ����ʾ����
	 * @return
	 */
	private JSplitPane mainPanel(){
		JSplitPane jsp = new JSplitPane();
		jsp.setLeftComponent(getleftPanel());
		jsp.setRightComponent(getrightPanel());
		return jsp;
	}
	
	/**
	 * ���ұ�����·��Ĳ�����ťд��һ�������������
	 * @return
	 */
	private JPanel buttomPanel(){
		JPanel buttomPanel =  new JPanel();
		btn_out = new JButton("�������");
		btn_out.setName("btn_out");
		
		btn_delete = new JButton("ɾ��Ա��");
		btn_delete.setName("btn_delete");
		
		
		buttomPanel.add(btn_out);
		buttomPanel.add(btn_delete);
		return buttomPanel;
	}
	
	/**
	 * ���������·��Ĳ�����ťҲд��һ�������������
	 * @return
	 */
	private JPanel leftButtomPanel(){
		
		JPanel leftButtomPanel =  new JPanel();	
		btn_search = new JButton("GO");
		btn_search.setName("btn_search");
		leftButtomPanel.add(btn_search);		
		return leftButtomPanel;
	}
	/**
	 * ��ʾ��ѯ����������
	 * �����ʾ��table��
	 * tableע����JScrollPane��
	 * @return
	 */
	private JScrollPane cnterPanel()
	{
		table = new JTable();
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		
		Vector<String> t_title = new Vector<String>();
		Vector<Vector<String>> t_data = new Vector<Vector<String>>();	
		dataModel= new DefaultTableModel();
		dataModel.setDataVector(t_data, t_title);
		
		table.setModel(dataModel);
		JScrollPane center = new JScrollPane(table);
		center.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
		center.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		center.setPreferredSize(new Dimension(600,400));
		return center;
	}
	
	/**
	 * ���Դ���
	 * @param args
	 */
	public static void main(String[] args){
		new SearchFrame();
	}

	
	
	public JComboBox getCbx_degree() {
		return cbx_degree;
	}

	public JComboBox getCbx_merry() {
		return cbx_merry;
	}

	public JComboBox getCbx_job() {
		return cbx_job;
	}

	public JComboBox getCbx_dept() {
		return cbx_dept;
	}

	public ComponentTool.AgePanel getWorkage1() {
		return workage1;
	}

	public ComponentTool.AgePanel getWorkage2() {
		return workage2;
	}

	public JButton getBtn_search() {
		return btn_search;
	}

	public JButton getBtn_out() {
		return btn_out;
	}
	
	public JButton getBtn_delete() {
		return btn_delete;
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(DefaultTableModel dataModel) {
		this.dataModel = dataModel;
	}
}