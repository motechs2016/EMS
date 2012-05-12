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

	
	
	//在当前类加载时，完成皮肤加载
	{
		try {
			UIManager.setLookAndFeel(windows); //窗体加载一个外部外观
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public SearchFrame(){
		
		initFrame();
		initAction();
		this.setTitle("查询");
		this.setIconImage(new ImageIcon("images/search.gif").getImage());
		this.setSize(1000,700);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	/**
	 * 初始化界面
	 */
	public void initFrame(){
		Container container = this.getContentPane();
		container.add(mainPanel());
	}
	
	/**
	 * 组件注册监听器
	 */
	public void initAction(){
		
		//给按钮注册鼠标监听器
		SearchListener sl = new SearchListener(this);		
		btn_search.addMouseListener(sl);		
		btn_out.addMouseListener(sl);
		btn_delete.addMouseListener(sl);
		
		
	}
	
	/**
	 * 左边面板：查询的条件选择
	 * @return
	 */
	private JPanel getsearchPanel(){
		
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new GridBagLayout());
		searchPanel.setPreferredSize(new Dimension(170,400));
//		leftPanel.setLayout(new GridLayout(5,2));
		
		JLabel l_degree = new JLabel("按学历:");
		JLabel l_merry = new JLabel("按婚姻:");
		JLabel l_job = new JLabel("按岗位:");
		JLabel l_dept = new JLabel("按部门:");
		JLabel l_hiredate = new JLabel("按工龄:");
		JLabel l_part = new JLabel("--");
		
		//学历下拉框
		Vector<String> v_degree = new Vector<String>();
		v_degree.add("             ");
		v_degree.add("博士");
		v_degree.add("硕士");
		v_degree.add("本科");
		v_degree.add("高中");
		v_degree.add("初中");
		v_degree.add("小学");
		cbx_degree = new JComboBox(v_degree);
		
		//婚姻状况下拉框
		Vector<String> v_merry = new Vector<String>();
		v_merry.add("             ");
		v_merry.add("已婚");
		v_merry.add("未婚");		
		cbx_merry = new JComboBox(v_merry);
		
		//工龄选择
		workage1 = new ComponentTool.AgePanel();
		workage2 = new ComponentTool.AgePanel();
		
		//岗位下拉框
		Vector<String> v_job = new Vector<String>();
		v_job.add("             ");
		v_job.add("部门经理");
		v_job.add("架构师");
		v_job.add("网络工程师");
		v_job.add("测试分析员");
		v_job.add("项目经理");
		v_job.add("软件工程师");
		v_job.add("销售员");
		v_job.add("客服员");
		cbx_job = new JComboBox(v_job);
		
		//部门下拉框
		Vector<String> v_dept = new Vector<String>();
		v_dept.add("             ");
		v_dept.add("开发部");
		v_dept.add("市场部");
		v_dept.add("测试部");
		v_dept.add("客服部");
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
	 * 右边面板：上面是结果显示台，下面是操作按钮区
	 * @return
	 */
	private JPanel getrightPanel(){
		JPanel centerPanel =  new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setSize(600, 400);
		centerPanel.setBorder(BorderFactory.createTitledBorder("查询结果"));
		
		centerPanel.add(cnterPanel());
		centerPanel.add(buttomPanel(),BorderLayout.SOUTH);
		return centerPanel;
	}
	
	/**
	 * 左边面板：上面是查询条件，下面是确定按钮区
	 * @return
	 */
	private JPanel getleftPanel(){
		JPanel leftPanel =  new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setBorder(BorderFactory.createTitledBorder("选择查询条件"));
		leftPanel.add(getsearchPanel(),BorderLayout.NORTH);
		leftPanel.add(leftButtomPanel());
		return leftPanel;
	}
	
	/**
	 * 分割面板:左边是选择条件，右边是结果显示窗口
	 * @return
	 */
	private JSplitPane mainPanel(){
		JSplitPane jsp = new JSplitPane();
		jsp.setLeftComponent(getleftPanel());
		jsp.setRightComponent(getrightPanel());
		return jsp;
	}
	
	/**
	 * 把右边面板下方的操作按钮写在一个独立的面板里
	 * @return
	 */
	private JPanel buttomPanel(){
		JPanel buttomPanel =  new JPanel();
		btn_out = new JButton("导出结果");
		btn_out.setName("btn_out");
		
		btn_delete = new JButton("删除员工");
		btn_delete.setName("btn_delete");
		
		
		buttomPanel.add(btn_out);
		buttomPanel.add(btn_delete);
		return buttomPanel;
	}
	
	/**
	 * 把左边面板下方的操作按钮也写在一个独立的面板里
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
	 * 显示查询结果的主面板
	 * 结果显示在table中
	 * table注入在JScrollPane中
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
	 * 测试窗口
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