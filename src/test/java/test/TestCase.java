package test;

import java.util.List;

import org.junit.Test;

import dao.UserDAO;
import entity.User;

public class TestCase {
	
	UserDAO dao=new UserDAO();
	
	@Test
	public void testDelUser() {
		boolean flag=dao.delUser(2);
		System.out.println("flag="+flag);
	}
	
	
	
	@org.junit.Test
	public void testAddUser() {
		User user=new User(-1, "任我行", "123", "123@tedu.cn");
		UserDAO dao=new UserDAO();
		boolean flag=dao.addUser(user);
		System.out.println("flag="+flag);
	}
	
	
	
	@org.junit.Test
	public void testListUser() {
		UserDAO dao=new UserDAO();
		List<User> list=dao.listUser();
		for(User user:list) {
			System.out.println(user);
		}
	}

}






