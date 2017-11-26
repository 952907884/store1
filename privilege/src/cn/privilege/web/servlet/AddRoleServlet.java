package cn.privilege.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.privilege.domain.Roles;
import cn.privilege.service.RoleService;

/**
 * Servlet implementation class AddRoleServlet
 */
@WebServlet("/addRole")
public class AddRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Roles role = new Roles();
		try {
			BeanUtils.populate(role, request.getParameterMap());
			RoleService service = new RoleService();
			service.addRole(role);
			response.getWriter().write("添加成功");
		} catch (Exception e) {
			response.getWriter().write("添加失败");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
