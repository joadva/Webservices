package rest.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import rest.DTO.User;
import rest.interfaces.IUser;
import rest.util.conexion;

public class userDao implements IUser {
	
	
	Connection con = null;
	PreparedStatement ps =null;
	ResultSet rs = null;

	@Override
	public Collection<User> getAll() {
		
		try {
			con = conexion.getConnection();
			String sql =  "Select * From user";
			ps= con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			Vector<User> vector = new Vector<User>();
			
			while(rs.next()) {
				User userfind = new User();
				userfind.setId(rs.getInt("id"));
				userfind.setUsername(rs.getString("username"));
				userfind.setDescription(rs.getString("description"));
				vector.add(userfind);
			}
			
			return vector;
		}catch  (Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			try {
				
				if(rs!= null) rs.close();
				if(ps!= null) rs.close();
			}catch(Exception e2) {
				
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			con = conexion.getConnection();
			String sql =  "DELETE FROM user WHERE id=?";
			ps= con.prepareStatement(sql);
			
			ps.setInt(1,id);
			
			if(ps.executeUpdate() == 1) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e ) {
			e.printStackTrace();
			throw new RuntimeException(e);
	}finally {
		try {
			if(ps!= null) rs.close();
		}catch(Exception e2) {
			
			e2.printStackTrace();
			throw new RuntimeException(e2);
		}
	}
		
	
	}

	@Override
	public boolean update(int id, String username, String description) {
		try {
			con = conexion.getConnection();
			String sql =  "UPDATE user SET  username=?, description=? Where id=?";
			ps= con.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(1,description);
			
			if(ps.executeUpdate() == 1) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e ) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			try {
				if(ps!= null) rs.close();
			}catch(Exception e2) {
				
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}

	@Override
	public boolean create(String username, String description) {
		
		
		
		try {
			con = conexion.getConnection();
			String sql =  "INSERT INTO user (username,description) VALUES(?,?)";
			ps= con.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(1,description);
			if (ps.executeUpdate() == 1) {
				return true;
			}else {
				return false;
			}
		}catch  (Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			try {
				if(ps!= null) rs.close();
			}catch(Exception e2) {
				
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
		
	}
	
	
	

}
