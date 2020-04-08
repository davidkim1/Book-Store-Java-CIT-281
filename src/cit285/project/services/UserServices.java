package cit285.project.services;

import cit285.project.dao.GetUserDao;
import cit285.project.domain.User;

public class UserServices implements UserServicesAPI {
	GetUserDao dao;
	
	public UserServices() {
		dao = new GetUserDao();
	}
	
	public User getUser(String userEmail) {
		// TODO Auto-generated method stub
		System.out.print("Estoy en userServices");
		User user = null;
		
		try {
			System.out.println("\n ESTOY EN USER SERVICES. ESTE ES EL EMAIL= " + userEmail);
			user = dao.getUser(userEmail);
			System.out.println(" Estoy adentro del try en user services ");
			System.out.println(user.getEmail() + "userservicessssssssssssssssssss");
		}catch (Exception e) {
			System.out.println(" El error esta en User GetUser (exception) "+e.toString());
		}
		return user;
	}
}
