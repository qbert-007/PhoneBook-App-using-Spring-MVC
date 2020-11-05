package com.qbert.dataAccess;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.qbert.model.Contacts;
import com.qbert.model.User;

public interface UserDao {
	public int registerUser(User u);
	public int registerContact(Contacts c);
	public User getUserByEmail(String email,String password) throws DataAccessException;
	public List<Contacts> getAllContacts(int fk)throws DataAccessException;
}
