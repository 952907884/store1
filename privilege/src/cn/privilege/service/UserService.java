package cn.privilege.service;

import java.sql.SQLException;
import java.util.List;

import cn.privilege.dao.UserDao;
import cn.privilege.domain.Users;

public class UserService {
	UserDao dao = new UserDao();
	public void addUser(Users user) {
		dao.addUser(user);
	}
	public List<Users> listUser() throws SQLException {
		return dao.listUser();
	}
	public Users login(Users u) {
		return dao.login(u);
	}

}
