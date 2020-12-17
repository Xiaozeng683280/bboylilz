package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;
import util.DBUtils;

public class ListUserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 1. 从数据库中获取用户信息
		UserDAO dao = new UserDAO();

		List<User> list = dao.listUser();
		System.out.println(list.toString());
		// 2. 动态生成响应内容
		// 获取向response中输出数据的字符�?
		PrintWriter pw = response.getWriter();
		pw.write("<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset='UTF-8'>" + "</head>");

		pw.write("<body>" + "	<table border='1' " + "width='60%' " + "cellspacing='0' " + "cellpadding='0' >");

		pw.write("<tr>" + "<th>ID</th>" + "<th>姓名</th>" + "<th>密码</th>" + "<th>邮箱</th>" +"<th>操作</th>"+ "</tr>");
		
		// 遍历List集合，获取用户信息
		for(User user:list) {
			pw.write("<tr>");
			pw.write("<td>"+user.getId()+"</td>");
			pw.write("<td>"+user.getUsername()+"</td>");
			pw.write("<td>"+user.getPassword()+"</td>");
			pw.write("<td>"+user.getEmail()+"</td>");
			
			pw.write("<td><a href='delUser?id="+user.getId()+"'  onclick='return confirm(\"是否删除用户？\")' >删除</a></td>");
			
			pw.write("</tr>");
		}
		pw.write("</table>");
		
		pw.write("<br /><a href='addUser.jsp'>添加用户</a> ");
		
		pw.write("</body></html>");
	}

}



