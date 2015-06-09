package processing;

import java.util.ArrayList;

import fabric.DaoFabric;
import instance.UserDao;
import model.UserModel;

public class AdminControler {
	//Actions relatives à l'interface d'administration
	
	public boolean isAdmin(UserModel user)
	{
		DaoFabric daoFabric = DaoFabric.getInstance();
		UserDao userDao = daoFabric.createUserDao();
		return userDao.isAdmin(user);
	}
	
	public ArrayList<UserModel> getUsers(){
			
		DaoFabric daoFabric = DaoFabric.getInstance();
		UserDao userDao = daoFabric.createUserDao();
		//check if user exists in userDao.getUsers();
		return userDao.getUsers();
	}
	
	public void setAdmin(UserModel user)
	{
		DaoFabric daoFabric = DaoFabric.getInstance();
		UserDao userDao = daoFabric.createUserDao();
		
		
	}
	
}
