package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtils;

public class AddUserServlet2 extends HttpServlet{

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
		String sql="insert into t_user values(null,?,?,?)";
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			int i=ps.executeUpdate();
			// CRUD Create read update delete
			if(i>0) {
				response.getWriter().write("恭喜您，添加成功！");
			}else {
				response.getWriter().write("添加失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("添加失败！");
		}finally {
			DBUtils.close(conn, ps, null);
		}

	}

	
}
