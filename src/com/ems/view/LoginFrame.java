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
 * EMS��½����
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
	
	 // ����ͳһ���
    private static final String windows  =
            "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	
	//�ڵ�ǰ�����ʱ�������Դ���غ�Ƥ�����ص�
	{
		UIManager.put("swing.boldMetal", Boolean.FALSE); //���Ĵ���������������Ϊϸ��
		try {
			UIManager.setLookAndFeel(windows); //�������һ���ⲿ���
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public LoginFrame()
	{
		//��ʼ���������
		initFrame();
		//��ʼ���¼�
		initAction();
		
		//��ǰ���屾����������
		
		this.setTitle("���¹���ϵͳ"); //ͨ��ResourceBundle�����ȡ��Դ�ļ��ڲ�ָ��Key��ӦValue,���ô������
		this.setIconImage(new ImageIcon("images/icon/TitleIcon.png").getImage());
		this.setSize(new Dimension(280,170)); //ͨ��Dimension�����װ�ߴ�ֵ,���ô���ߴ��С
		this.setResizable(false); //����ǰ��������Ϊ�����޸ĳߴ��С
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���õ�ǰ����رհ�ťĬ�϶���
		this.setLocationRelativeTo(null); //���õ�ǰ����������λ����Ļ����
		this.setVisible(true); //���õ�ǰ����������Ϊ��ʾ״̬
	}

	//��ʼ����ǰ�������
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
	
	//��ʼ����ǰ�����������¼�
	protected void initAction()
	{
		
	}
	
	//���ɵ�ǰ�����ϰ벿�����
	private JPanel getUpPanel()
	{
		JPanel panel = new JPanel(); //�����հ�������
		panel.setLayout(new GridBagLayout());
		
		panel.setOpaque(false); //�������͸��
	
		JLabel lbl_userName = new JLabel("�� ��:");
		JLabel lbl_password = new JLabel("�� ��:");
		
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
	
	//���ɵ�ǰ�����°벿�����
	private JPanel getBottomPanel()
	{
		JPanel panel = new JPanel();

		btn_login = new JButton("�� ¼");
		btn_login.setEnabled(true);
		btn_login.setName("btn_login");
		btn_cancel = new JButton("ȡ ��");
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
