package processing;

import fabric.DaoFabric;
import instance.UserDao;

public class UserControlerBean {
	//actions relatives aux utilisateurs
	
	public boolean checkUser(){
		
		//TODO faire appel à la DAO
		DaoFabric daoFabric = DaoFabric.getInstance();
		UserDao userDao = daoFabric.createUserDao();
		//check if user exists in userDao.getUsers();

		System.out.println("Bonjour Monde");
		return true;
	}
}
