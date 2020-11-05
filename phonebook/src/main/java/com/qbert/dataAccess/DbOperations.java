package com.qbert.dataAccess;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.qbert.model.Contacts;
import com.qbert.model.User;

public class DbOperations {
	private static UserDao getDao() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao=(UserDao) context.getBean("beanDao");//later try changing
		return dao;
	}
	
	public static int saveUser(User u) {
		return DbOperations.getDao().registerUser(u);
	}
	
	public static int saveContact(Contacts c) {
		return DbOperations.getDao().registerContact(c);
	}
	
	public static User checkCredential(String email,String password) {
		UserDao dao=DbOperations.getDao();
		User u;
		try {
			u=dao.getUserByEmail(email, password);
		}catch(Exception e) {
			u=null;
		}
		return u;
	}
	
	public static List<Contacts> getUserContacts(int fk){
		try {
		 return DbOperations.getDao().getAllContacts(fk);	 
		 }catch(DataAccessException e){
			 System.out.println("got null" +e);
			 return null;
		 }
	}
}
