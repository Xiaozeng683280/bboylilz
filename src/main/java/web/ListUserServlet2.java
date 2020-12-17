package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.jasper.runtime.HttpJspBase;

import util.DBUtils;

public class ListUserServlet2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		//1. 从数据库中查询所有用户信�?
		String sql="select * from t_user";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtils.getConn();
			
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			//2. 动�?�生成用户列�?
			// 获取向response中输出数据的字符�?
			PrintWriter pw=response.getWriter();
			pw.write("<!DOCTYPE html>" + 
					"<html>" + 
					"<head>" + 
					"<meta charset='UTF-8'>" + 
					"</head>");
			
			pw.write("<body>" + 
					"	<table border='1' "
					+ "width='60%' "
					+ "cellspacing='0' "
					+ "cellpadding='0' >");
			
			pw.write("<tr>"
					+ "<th>ID</th>"
					+ "<th>姓名</th>"
					+ "<th>密码</th>"
					+ "<th>邮箱</th>"
					+ "</tr>");
			
			
			
			while(rs.next()) {
				pw.write("<tr>");
				pw.write("<td>"+rs.getInt("id")+"</td>");
				pw.write("<td>"+rs.getString("username")+"</td>");
				pw.write("<td>"+rs.getString("password")+"</td>");
				pw.write("<td>"+rs.getString("email")+"</td>");
				pw.write("</tr>");
				
//				System.out.println(rs.getInt("id")+","
//			                   +rs.getString("username")+","
//					           +rs.getString("password")+","
//			                   +rs.getString("email"));
			}
			
			pw.write("</table></body></html>");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		
		
		

		
		
	}
	
	
	
	
	

}
