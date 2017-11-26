package cn.privilege.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.privilege.domain.Privileges;
import cn.privilege.domain.Roles;
import cn.privilege.utils.JdbcUtil;

public class RoleDao {

	public void addRole(Roles role) throws SQLException {
		String sql="INSERT INTO `roles`(`name`,`description`)VALUES(?,?)";
		QueryRunner r = new QueryRunner(JdbcUtil.getDataSource());
		r.update(sql, role.getName(),role.getDescription());
	}

	public List<Roles> listRole() throws SQLException {
		String sql="select * from roles";
		QueryRunner r = new QueryRunner(JdbcUtil.getDataSource());
		List<Roles> list = r.query(sql, new BeanListHandler<Roles>(Roles.class));

		return list;
	}

	public Roles findRoleById(String role_id) {
		String sql="SELECT r.`id`,r.`name`, r.`description`,p.`name`"+
					"FROM `privileges` p "+
					"INNER JOIN `roleprivilege` rp ON p.id=rp.`privilege_id`"+
					"INNER JOIN `roles` r ON ?=rp.`role_id`"+
					"WHERE r.id=?";
		QueryRunner r = new QueryRunner(JdbcUtil.getDataSource());
		Roles role=null;
		try {
			role = r.query(sql, new ResultSetHandler<Roles>(){
				@Override
				public Roles handle(ResultSet rs) throws SQLException {
					Roles r = new Roles();
					List<Privileges> list = new ArrayList<Privileges>();
					if(rs.next()){
						Privileges p = new Privileges();
						r.setId(rs.getInt(1));
						r.setName(rs.getString(2));
						r.setDescription(rs.getString(3));
						p.setName(rs.getString(4));
						list.add(p);
					}else {
						List<Roles> roles = listRole();
						for (Roles rr : roles) {
							if(rr.getId()== Integer.parseInt(role_id)){
								return rr;
							}
						}
					}
					while(rs.next()){
						Privileges p = new Privileges();
						p.setName(rs.getString(4));
						list.add(p);
					}
					r.setPriList(list);
					return r;
				}
			},role_id,role_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}

	public List<Privileges> findPrivilegeAll() {
		String sql = "select * from Privileges";
		QueryRunner r = new QueryRunner(JdbcUtil.getDataSource());
		List<Privileges> list = null;
		try {
			list = r.query(sql, new BeanListHandler<>(Privileges.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void deleteRolePrivilege(Connection conn, String role_id) throws SQLException {
		String sql = "delete from roleprivilege where role_id=?";
		QueryRunner r = new QueryRunner();
		r.update(conn,sql, Integer.parseInt(role_id));
	}

	public void grantRolePrivilege(Connection conn, String role_id, String[] privilege_id) throws SQLException {
		String sql = "insert into roleprivilege values(?,?)";
		QueryRunner r = new QueryRunner();
		Object[][] params = new Object[privilege_id.length][2];
		for (int i = 0; i < params.length; i++) {
			params[i][0] = role_id;
			params[i][1] = privilege_id[i];

		}
		r.batch(conn, sql, params);
	}
	

	
	
}
