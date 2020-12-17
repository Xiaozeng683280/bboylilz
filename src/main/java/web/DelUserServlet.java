package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

public class DelUserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 处理响应乱码
		response.setContentType("text/html;charset=utf-8");
		
		// 接收用户请求参数-id
		String idStr=request.getParameter("id");
		
		// 数据类型转换
		int id=Integer.parseInt(idStr);
		
		// 调用DAO的方法，执行删除逻辑
		UserDAO dao=new UserDAO();
		
		boolean flag=dao.delUser(id);
		
		// 根据删除结果，返回响应内容
		if(flag) {// 删除成功-重定向到用户列表
			response.sendRedirect("listUser2.jsp");
		}else {
			response.getWriter().write("删除失败！");
		}
	}
	
	
	

}
