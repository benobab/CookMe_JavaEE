package processing;

import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import fabric.DaoFabric;
import instance.UserDao;
import model.UserModel;

@ManagedBean(name="adminControlerBean")
@ApplicationScoped
public class AdminControler {
	//Actions relatives à l'interface d'administration
	
	public String isAdmin(UserModel user)
	{
		DaoFabric daoFabric = DaoFabric.getInstance();
		UserDao userDao = daoFabric.createUserDao();
		
		if( userDao.testCo(user))
		{
			if(userDao.isAdmin(user))
			{
				return ("selectAdmin.jsf");
			}
		}
		return ("login.jsf");
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
