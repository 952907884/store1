package cn.privilege.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * 数据库操作的工具类
 */
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	private static ComboPooledDataSource datasource=new ComboPooledDataSource();
	
	/**
	 * 获取数据库连接资源
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return datasource.getConnection();
	}
	
	/**
	 * 获取数据库连接池
	 * @return
	 */
	public static DataSource getDataSource(){
		return datasource;
	}
	
	/**
	 * 关闭数据库资源
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void closeAll(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
