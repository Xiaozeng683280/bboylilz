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
			<th>����</th>
			<th>����</th>
			<th>����</th>
		</tr>
	<% 
		// ͨ��UserDAO��ѯ�û�����
		UserDAO dao=new UserDAO();
		List<User> list=dao.listUser();
		
		// �������ϣ���̬����ҳ�������
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





