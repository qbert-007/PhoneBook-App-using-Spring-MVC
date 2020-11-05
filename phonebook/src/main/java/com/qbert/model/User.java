package com.qbert.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	@Column(nullable = false)
	private String user_name;
	
	@Column(unique = true,nullable = false)
	private String user_email;
	
	@Column(unique = true,nullable = false)
	private String user_password;
	
	@Column(nullable = false)
	private long user_number;
	
	private byte user_status=0;

	
	public User() {
		super();
	}

	public User(int user_id, String user_name, String user_email, String user_password, long user_number,
			byte user_status ) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_password = user_password;
		this.user_number = user_number;
		this.user_status = user_status;
		
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public long getUser_number() {
		return user_number;
	}

	public void setUser_number(long user_number) {
		this.user_number = user_number;
	}

	public byte getUser_status() {
		return user_status;
	}

	public void setUser_status(byte user_status) {
		this.user_status = user_status;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [user_id=");
		builder.append(user_id);
		builder.append(", user_name=");
		builder.append(user_name);
		builder.append(", user_email=");
		builder.append(user_email);
		builder.append(", user_password=");
		builder.append(user_password);
		builder.append(", user_number=");
		builder.append(user_number);
		builder.append(", user_status=");
		builder.append(user_status);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
