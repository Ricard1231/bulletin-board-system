package business;

import java.util.Date;

public class User {
	public int uid;
	public String username;
	public String name;
	public String email;
	public String password;
	public String gender;
	public Date date_of_birth;
	public String ulogo;
	
	public User() {
		super();
	}

	public User(int uid, String username, String name, String email, String password, String gender, Date date_of_birth, String ulogo) {
		this.uid = uid;
		this.username = username;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.ulogo = ulogo;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date) {
		this.date_of_birth = date;
	}

	public String getUlogo() {
		return ulogo;
	}

	public void setUlogo(String ulogo) {
		this.ulogo = ulogo;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", date_of_birth=" + date_of_birth + ",ulogo=" + ulogo + "]";
	}

}