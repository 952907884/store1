package cn.privilege.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.privilege.domain.Users;
import cn.privilege.utils.JdbcUtil;

public class UserDao {

	public void addUser(Users user) {
		String sql = "INSERT INTO `users`(`username`,`password`,`nickname`) VALUES(?,?,?)";
		QueryRunner r = new QueryRunner(JdbcUtil.getDataSource());
		try {
			r.update(sql, user.getUsername(),user.getPassword(),user.getNickname());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("插入用户数据异常");
		}
	}

	public List<Users> listUser() throws SQLException {
		String sql = "SELECT * FROM `users` ";
		QueryRunner r = new QueryRunner(JdbcUtil.getDataSource());
		return r.query(sql, new BeanListHandler<Users>(Users.class));
		
	}

	public Users login(Users u) {
		String sql = "SELECT * FROM `users` where username = ? and password = ? ";
		QueryRunner r = new QueryRunner(JdbcUtil.getDataSource());
		Users user = null;
		try {
			user = r.query(sql, new BeanHandler<>(Users.class),u.getUsername(),u.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
