package com.ems.tool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class ComponentTool {

	/**
	 * 性别面板
	 * 
	 * @author Jacky
	 * 
	 */
	public static class SexPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		private JRadioButton rb_men, rb_women;

		public SexPanel() {
			this.setOpaque(false);
			this.setLayout(new GridLayout(0, 2));

			ButtonGroup bg = new ButtonGroup();

			rb_men = new JRadioButton("男");
			rb_men.setOpaque(false);
			rb_men.setSelected(true);
			rb_women = new JRadioButton("女");
			rb_women.setOpaque(false);

			bg.add(rb_men);
			bg.add(rb_women);

			this.add(rb_men);
			this.add(rb_women);
		}

		public JRadioButton getRb_men() {
			return rb_men;
		}

		public JRadioButton getRb_women() {
			return rb_women;
		}

		@SuppressWarnings("deprecation")
		public String toString() {
			if (rb_men.isSelected())
				return rb_men.getLabel();
			else
				return rb_women.getLabel();
		}
	}

	/**
	 * 身份证面板
	 */
	public static class PostIdPanel extends JPanel{

		private static final long serialVersionUID = 1L;
		private JTextField txt_postId;
		private JLabel error_postId;
		public PostIdPanel()
		{
			this.setOpaque(false);
			this.setLayout(new GridLayout(0, 2));
			txt_postId = new JTextField(20);
			txt_postId.setName("txt_postId");
			error_postId = new JLabel("       ");
			error_postId.setName("error_postId");
			error_postId.setForeground(Color.RED);
			
			this.add(txt_postId);
			this.add(error_postId);
			
		}
		public JTextField getTxt_postId() {
			return txt_postId;
		}
		public JLabel getError_postId() {
			return error_postId;
		}
		
	}
	
	/**
	 * 年龄面板
	 * 
	 * @author Jacky
	 * 
	 */
	public static class AgePanel extends JPanel {

		private static final long serialVersionUID = 1L;

		private JComboBox cbx_age;
		private ComboBoxModel cbm;

		public AgePanel() {
			this.setOpaque(false);
			this.setLayout(new GridLayout());

			cbm = new DefaultComboBoxModel(getModel());
			cbx_age = new JComboBox(cbm);
			this.add(cbx_age);
		}

		// 产生年龄下拉列表中的数据
		private Vector<Integer> getModel() {
			Vector<Integer> vAge = new Vector<Integer>();

			for (int i = 0; i < 20; i++) {
				vAge.add(i);
			}

			return vAge;
		}

		// 用于后期获取年龄下拉列表组件对象
		public JComboBox getCbx_age() {
			return cbx_age;
		}

		public int getAge() {
			String strAge = cbx_age.getSelectedItem().toString();
			return new Integer(strAge).intValue();
		}
	}

	
	/**
	 * 备注面板
	 * 
	 * @author Jacky
	 * 
	 */
	public static class ContentPanel extends JScrollPane {

		private static final long serialVersionUID = 1L;

		private JTextArea txt_content;

		public ContentPanel() {
			this.setOpaque(false);
			this.setPreferredSize(new Dimension(80, 50));
			txt_content = new JTextArea(5, 10);
			txt_content.setFont(new Font("宋体", Font.ITALIC, 12));
			txt_content.setText("请输入备注信息,最长不能超过50字!");

			this.setViewportView(txt_content);
		}

		// 获取备注文本区域组件对象
		public JTextArea getTxt_content() {
			return txt_content;
		}

		public String toString() {
			return txt_content.getText();
		}
	}

	/**
	 * 地址面板
	 * 
	 * @author Jacky
	 * 
	 */
	public static class AddressPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		private JComboBox cbo_province, cbo_city;
		private JTextField txt_address;

		public AddressPanel() {
			this.setOpaque(false);
			this.setLayout(new GridLayout(0, 3));

			cbo_province = new JComboBox(getProvinceModel());
			cbo_city = new JComboBox(getCityModel());
			txt_address = new JTextField(13);

			this.add(cbo_province);
			this.add(cbo_city);
			this.add(txt_address);
		}

		public Vector<String> getProvinceModel() {
			Vector<String> v = new Vector<String>();
			v.add("湖南");
			v.add("湖北");
			v.add("河北");
			v.add("山西");
			v.add("陕西");
			v.add("云南");
			return v;
		}

		public Vector<String> getCityModel() {
			Vector<String> v = new Vector<String>();
			v.add("长沙");
			v.add("湘潭");
			v.add("株洲");
			v.add("常德");

			return v;
		}

		public JComboBox getCbo_province() {
			return cbo_province;
		}

		public JTextField getTxt_address() {
			return txt_address;
		}

		public JComboBox getCbo_city() {
			return cbo_city;
		}

		public String toString() {
			String address = null;
			if(txt_address.getText().length() != 0 && txt_address.getText() != null)
				address = cbo_province.getSelectedItem().toString() + " "
						+ cbo_city.getSelectedItem().toString() + " "
						+ txt_address.getText();
			else
				address = cbo_province.getSelectedItem().toString() + " "
				+ cbo_city.getSelectedItem().toString();
			
			return address;
		}

	}

	/**
	 * 联系电话面板
	 * 
	 * @author Jacky
	 * 
	 */
	public static class TelPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		private JTextField txt_areaNum, txt_phonNum;
		private JLabel lbl_split = new JLabel("-");

		public TelPanel() {
			this.setOpaque(false);
			this.setLayout(new GridBagLayout());
			txt_areaNum = new JTextField(4);
			txt_areaNum.setText("0601");

			txt_phonNum = new JTextField(14);

			this.add(txt_areaNum, new GBC(0, 0));
			this.add(lbl_split, new GBC(1, 0));
			this.add(txt_phonNum, new GBC(2, 0));
		}

		public JTextField getTxt_areaNum() {
			return txt_areaNum;
		}

		public JTextField getTxt_phonNum() {
			return txt_phonNum;
		}

		public String toString() {
			return txt_areaNum.getText() + "-" + txt_phonNum.getText();
		}
	}

	//背景面板
	public static class ImagePanel extends JPanel
	{
		private String image;
		public ImagePanel(String image)
		{
			this.image = image;
		}
		public void paintComponent(Graphics g)
		{
			g.drawImage(this.getToolkit().getImage(image), 0, 0, this);
		}
	}

	
}
