package rest.DTO;

public class User {
private int id;
private String username;
private String description;

public User() {
	
	
}

public User(int id,String username, String description) {
	
	this.id = id;
	this.username = username;
	this.description= description;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}


	




}
