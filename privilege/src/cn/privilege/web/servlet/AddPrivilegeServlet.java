package cn.privilege.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.privilege.domain.Privileges;
import cn.privilege.service.PrivilegeService;

/**
 * Servlet implementation class AddPrivilege
 */
@WebServlet("/addPrivilege")
public class AddPrivilegeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");;
		response.setContentType("text/html;charset=utf-8");
		Map<String,String[]> map=request.getParameterMap();
		Privileges p=new Privileges();
		try {
			BeanUtils.populate(p, map);
			PrivilegeService service=new PrivilegeService();
			service.addPrivilege(p);
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
