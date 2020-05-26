package rest.interfaces;

import java.util.Collection;

import rest.DTO.User;

public interface IUser {

public Collection<User> getAll();
	
	public boolean delete( int id);
	public boolean  update(int id, String username, String description);
	public boolean create(String username, String description);
	
}
