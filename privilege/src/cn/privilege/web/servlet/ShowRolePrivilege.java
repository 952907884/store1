package cn.privilege.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.privilege.domain.Privileges;
import cn.privilege.domain.Roles;
import cn.privilege.service.RoleService;

/**
 * Servlet implementation class ShowRolePrivilege
 */
@WebServlet("/showRolePrivilege")
public class ShowRolePrivilege extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role_id=request.getParameter("role_id");
		RoleService service = new RoleService();
		
		Roles role = service.findRoleById(role_id);
		List<Privileges> privileges = service.findPrivilegeAll();
		
		request.setAttribute("role", role); // 只是将当前角色的相关信息得到了.
		request.setAttribute("privileges", privileges); // 所有的权限

		request.getRequestDispatcher("showRolePrivilege.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
