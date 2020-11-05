package com.qbert.model;

import java.util.Base64;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Contacts")
public class Contacts{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contact_id;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(nullable = false, name="fk_user_id")
	private User fuser;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true )
	private String number="";
	
	private String address;
	@Lob
	private byte[] image;
	
	@Transient
	private String base;
	
	public Contacts() {
		super();
	}

	public Contacts(int contact_id, User fuser, String name, String number, String address, byte[] image) {
		super();
		this.contact_id = contact_id;
		this.fuser = fuser;
		this.name = name;
		this.number = number;
		this.address = address;
		this.image = image;
	}

	public int getContact_id() {
		return contact_id;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}

	public User getFuser() {
		return fuser;
	}

	public void setFuser(User fuser) {
		this.fuser = fuser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getBase() {
		return Base64.getEncoder().encodeToString(this.getImage());
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contacts [contact_id=");
		builder.append(contact_id);
		builder.append(", fuser=");
		builder.append(fuser);
		builder.append(", name=");
		builder.append(name);
		builder.append(", number=");
		builder.append(number);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}
	
	
}
