package com.ems.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.ems.dao.SearchDao;
import com.ems.tool.ConnectionManager;

public class SearchDaoImpl implements SearchDao {

	private Connection conn;
	
	private PreparedStatement ps;
	
	private Statement state;
	
	private ResultSet rs;


	public Vector<Vector<String>> Search(String message) {
		return null;
	}


	/**
	 * ��ϲ�ѯ
	 */
	public Vector<Vector<String>> search(String sql) {

		//��ȡ���ݿ�����
		conn = ConnectionManager.getConnection();

		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> emp = null;
		try {
			state = conn.createStatement();
			System.out.println(sql);
			rs = state.executeQuery(sql);
			
			
			
			//�������������ÿ��������ӵ��ڲ㼯�ϣ��ٰ��ڲ㼯�ϼӵ��������
			while(rs.next()){
				emp = new Vector<String>();
				emp.add(rs.getString(1));
				emp.add(rs.getString(2));
				emp.add(rs.getString(3));
				emp.add(rs.getString(4));
				emp.add(rs.getString(5));
				emp.add(rs.getString(6));
				emp.add(rs.getString(7));
				emp.add(rs.getString(8));
				emp.add(rs.getString(9));
				emp.add(rs.getString(10));
				emp.add(rs.getString(11));
				emp.add(rs.getString(12));
				emp.add(rs.getString(13));
				
				data.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}



	/**
	 * ɾ��Ա��
	 */
	public int delete(String empNo) {
		conn = ConnectionManager.getConnection();
		int result = -1;
		String sql = "delete from emp where empno=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(empNo));
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
}
