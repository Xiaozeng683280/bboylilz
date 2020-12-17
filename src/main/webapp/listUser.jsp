<%@page import="entity.User"%>
<%@page import="java.util.*,dao.UserDAO"%>
<%@ page pageEncoding="GBK" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<table width="60%" 
	border="1" cellspacing="0" cellpadding="0">
		<tr>
			<th>ID</th>
			<th>姓名</th>
			<th>密码</th>
			<th>邮箱</th>
		</tr>
	<% 
		// 通过UserDAO查询用户数据
		UserDAO dao=new UserDAO();
		List<User> list=dao.listUser();
		
		// 遍历集合，动态生成页面的内容
		for(User user:list){ %>
		
			<tr>
				<td><%=user.getId() %></td>
			    <td><%=user.getUsername() %></td>
			    <td><%=user.getPassword() %></td>
			    <td><%=user.getEmail() %></td>
			</tr>
			
	 <% } %>

	</table>
</body>
</html>





