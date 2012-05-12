package com.ems.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.ems.tool.ComponentTool;
import com.ems.tool.GBC;


/**
 * EMS登陆窗体
 * @author Jacky
 * @version 1.0 2011.01.06
 *
 */
public class LoginFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txt_userName;
	private JPasswordField pwd_password;
	private JButton btn_register,btn_login,btn_cancel;
	private JLabel error_userName,error_password;
	private JComboBox cbx_type;
	private JCheckBox cbx_save;
	
	 // 窗体统一外观
    private static final String windows  =
            "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	
	//在当前类加载时，完成资源加载和皮肤加载等
	{
		UIManager.put("swing.boldMetal", Boolean.FALSE); //更改窗体所有文字字体为细体
		try {
			UIManager.setLookAndFeel(windows); //窗体加载一个外部外观
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public LoginFrame()
	{
		//初始化窗体界面
		initFrame();
		//初始化事件
		initAction();
		
		//当前窗体本身属性设置
		
		this.setTitle("人事管理系统"); //通过ResourceBundle对象获取资源文件内部指定Key对应Value,设置窗体标题
		this.setIconImage(new ImageIcon("images/icon/TitleIcon.png").getImage());
		this.setSize(new Dimension(280,170)); //通过Dimension对象封装尺寸值,设置窗体尺寸大小
		this.setResizable(false); //将当前窗体设置为不可修改尺寸大小
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置当前窗体关闭按钮默认动作
		this.setLocationRelativeTo(null); //设置当前窗体启动后位于屏幕中央
		this.setVisible(true); //设置当前窗体启动后为显示状态
	}

	//初始化当前窗体界面
	protected void initFrame()
	{
		Container container = this.getContentPane();
		ComponentTool.ImagePanel ip = new ComponentTool.ImagePanel("images/backGround/blue.jpg");
//		container.add(getUpPanel());
//		container.add(getBottomPanel(),BorderLayout.SOUTH);
//		container.add(new ComponentTool.ImagePanel("images/backGround/blue.jpg"));
		
		ip.add(getUpPanel());
    	ip.add(getBottomPanel(),BorderLayout.SOUTH);
    	container.add(ip);
	}
	
	//初始化当前窗体界面组件事件
	protected void initAction()
	{
		
	}
	
	//生成当前窗体上半部分面板
	private JPanel getUpPanel()
	{
		JPanel panel = new JPanel(); //构建空白面板对象
		panel.setLayout(new GridBagLayout());
		
		panel.setOpaque(false); //设置组件透明
	
		JLabel lbl_userName = new JLabel("账 号:");
		JLabel lbl_password = new JLabel("密 码:");
		
		txt_userName = new JTextField();
		txt_userName.setName("txt_userName");
		txt_userName.setColumns(15);
		
		pwd_password = new JPasswordField();
		pwd_password.setName("pwd_password");
		pwd_password.setColumns(15);
		
		panel.add(lbl_userName,new GBC(0,0).setInset(2));
        panel.add(txt_userName,new GBC(1,0).setInset(2).setFill(GBC.BOTH));
        panel.add(lbl_password,new GBC(0,1).setInset(2));
        panel.add(pwd_password,new GBC(1,1).setInset(2).setFill(GBC.BOTH));
        
        
		return panel;
	}
	
	//生成当前窗体下半部分面板
	private JPanel getBottomPanel()
	{
		JPanel panel = new JPanel();

		btn_login = new JButton("登 录");
		btn_login.setEnabled(true);
		btn_login.setName("btn_login");
		btn_cancel = new JButton("取 消");
		btn_cancel.setMnemonic('C');
		btn_cancel.setName("btn_cancel");
		
		panel.add(btn_login);
		panel.add(btn_cancel);
		panel.setOpaque(false);
		return panel;
	}

	public JTextField getTxt_userName() {
		return txt_userName;
	}

	public JPasswordField getPwd_password() {
		return pwd_password;
	}

	public JButton getBtn_login() {
		return btn_login;
	}
	public JButton btn_cancel() {
		return btn_cancel;
	}
	
	public static void main(String[] args){
		new LoginFrame();
	}
}
