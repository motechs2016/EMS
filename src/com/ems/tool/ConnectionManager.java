package com.ems.tool;

import java.sql.*;

public class ConnectionManager {

//	private static final String DRIVER_CLASS = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
//	private static final String DATABASE_URL = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=Administer";
//	private static final String DATABASE_USRE = "sa";
//	private static final String DATABASE_PASSWORD = "jqy";
	
//	private static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=Administer;user=sa;password=jqy";

	private static final String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	private static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:oracle";
	private static final String DATABASE_USRE = "scott";
	private static final String DATABASE_PASSWORD = "tiger";
	
	/**
	 * 返回连接
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		Connection dbConnection = null;
		try { 

			Class.forName(DRIVER_CLASS);
//			dbConnection = DriverManager.getConnection(DATABASE_URL,DATABASE_USRE, DATABASE_PASSWORD);
			dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ems", "scott", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dbConnection;
	}


	/**
	 * 关闭连接
	 * @param conn
	 * @param state
	 * @param rs
	 */
	public static void freeConnection(Connection conn,Statement state ,ResultSet rs)
	{
		try{
			if(rs != null)
				rs.close();
		}catch(SQLException e){}
		finally{
			try{
				if(state != null)
					state.close();
			}catch(Exception e){}
			finally{
				try{
					if (conn != null)
						conn.close();
				}catch(Exception e){}
			}
		}
	}
	
	public static void main(String[] args){
		Connection conn = ConnectionManager.getConnection();
		
		System.out.println(conn);
	}
	
}
