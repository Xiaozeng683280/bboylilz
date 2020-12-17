package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtils;

public class UserDAO {
	
	/**
	 * 根据用户id删除用户数据的方法
	 * @param id 用户的id
	 * @return true-删除成功 false-删除失败
	 */
	public boolean delUser(int id) {
		String sql="delete from t_user where id=?";
		
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, null);
		}
		
		return false;
	}
	
	
	
	
	/**
	 * 添加用户信息的方法
	 * @param user 封装了用户信息的对象
	 * @return true-添加成功 false-添加失败
	 */
	public boolean addUser(User user) {
		
		String sql="insert into t_user values(null,?,?,?)";
		
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, null);
		}
		return false;
	}
	
	
	
	/**
	 * 用户查询所有用户信息的方法
	 * @return 封装了用户信息的集合
	 */
	public List<User> listUser(){
		List<User> list=new ArrayList<User>();
		String sql="select * from t_user";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtils.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				// 用于封装本行数据的User对象
				User user=new User();
				System.out.println(user.toString());
				// 从rs中获取数据，封装到user对象中
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				
				// 将user对象存入list集合
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		
		return list;
	}

}
