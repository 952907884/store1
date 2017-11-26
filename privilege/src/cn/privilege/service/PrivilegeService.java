package cn.privilege.service;

import java.sql.SQLException;
import java.util.List;

import cn.privilege.dao.PrivilegeDao;
import cn.privilege.domain.Privileges;

public class PrivilegeService {
	
	PrivilegeDao dao=new PrivilegeDao();
	public void addPrivilege(Privileges p) throws SQLException {
		dao.addPrivilege(p);
	}
	public List<Privileges> listPrivileges() throws SQLException {
		return dao.listPrivileges();
	}

}
