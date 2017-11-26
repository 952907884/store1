package cn.privilege.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import cn.privilege.dao.RoleDao;
import cn.privilege.domain.Privileges;
import cn.privilege.domain.Roles;
import cn.privilege.utils.JdbcUtil;

public class RoleService {
	RoleDao dao = new RoleDao();
	public void addRole(Roles role) throws SQLException {
		dao.addRole(role);
	}
	public List<Roles> listRole() throws SQLException {
		return dao.listRole();
	}
	public Roles findRoleById(String role_id) {
		return dao.findRoleById(role_id);
	}
	public List<Privileges> findPrivilegeAll() {
		return dao.findPrivilegeAll();
	}
	public void grantRolePrivilege(String role_id, String[] privilege_id) {
		Connection conn= null;
		try {
			conn=JdbcUtil.getConnection();
			conn.setAutoCommit(false); // 设置事务为手动提交
			dao.deleteRolePrivilege(conn,role_id);	//删除原有的权限
			dao.grantRolePrivilege(conn,role_id,privilege_id);	//添加新的权限
			
		} catch (Exception e) {
			try {
				DbUtils.rollback(conn);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				DbUtils.commitAndClose(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	//提交事物并关闭资源
		}
		
	}

}
