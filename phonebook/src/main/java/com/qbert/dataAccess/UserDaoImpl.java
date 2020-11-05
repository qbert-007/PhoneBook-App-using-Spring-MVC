package com.qbert.dataAccess;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.qbert.model.Contacts;
import com.qbert.model.User;

public class UserDaoImpl implements UserDao{
	HibernateTemplate template;

	
	
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public int registerUser(User u) {
		int i=0;
		i=(Integer) template.save(u);
		return i;
	}

	@Transactional
	public int registerContact(Contacts c) {
		int i=0;
		i=(Integer) template.save(c);
		return i;
	}	
	
	public User getUserByEmail(String email,String password) throws DataAccessException,IndexOutOfBoundsException{
		List<User> u=(List<User>) template.find("from User where user_email=?0 and user_password=?1", email,password);
		return u.get(0);
		
	}
	 
	public List<Contacts> getAllContacts(int fk)throws DataAccessException{
		//List<Contacts> cont=template.loadAll(Contacts.class);
		List<Contacts> cont=(List<Contacts>) template.find("from Contacts where fk_user_id=?0", fk);
		return cont;
	}
}
