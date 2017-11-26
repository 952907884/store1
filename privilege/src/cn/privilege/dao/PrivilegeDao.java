package cn.privilege.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.privilege.domain.Privileges;
import cn.privilege.utils.JdbcUtil;

public class PrivilegeDao {
	
	public void addPrivilege(Privileges p) throws SQLException{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql="INSERT INTO `privileges`(`name`,`fnpath`,`description`)VALUES(?,?,?)";
		runner.update(sql, p.getName(),p.getFnpath(),p.getDescription());
	}

	public List<Privileges> listPrivileges() throws SQLException {
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql="select * from Privileges";
		return runner.query(sql, new BeanListHandler<Privileges>(Privileges.class));
	}

}
