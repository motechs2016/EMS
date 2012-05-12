package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	

	public static void main(String[] args){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:jqy", "scott", "tiger");
			
			
			String sql = "select * from student where name =? and age=? and dept =? and degree =?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "lijie");
			ps.setInt(2,23 );
			ps.setString(3, null);
			ps.setString(4, "±¾¿Æ");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
