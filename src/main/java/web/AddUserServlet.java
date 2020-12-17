package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;
import util.DBUtils;

public class AddUserServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 通知Tomcat使用UTF-8对响应内容进行编码
		// response.setCharacterEncoding("UTF-8");
				
		// 通知浏览器使用utf-8对响应内容进行解码
		// Tomcat会自动使用utf-8对响应内容进行编码
		response.setContentType("text/html;charset=utf-8");		
		
		// 解决请求乱码
		request.setCharacterEncoding("UTF-8");
		
		// 1. 获取用户的表单数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		

		// 测试：将数据输出到控制台
		// System.out.println("username="+username+",password="+password+",email="+email);
		
		// 2. 将数据存入数据库
		UserDAO dao=new UserDAO();
		
		// 使用User对象封装用户信息
		User user=new User(-1, username, password, email);
		
		// 调用Dao的方法，实际执行添加操作
		boolean flag=dao.addUser(user);
		
		if(flag) {
			// 重定向到用户列表-listUser是ListUserServlet映射的路径
			response.sendRedirect("listUser2.jsp");
			// response.sendRedirect("http://www.tmooc.cn");
		}else {
			response.getWriter().write("添加失败");
		}
		
		//String result=flag?"添加成功":"添加失败";
		
		//给用户生成响应信息
		// response.getWriter().write(result);
	}

	
}





