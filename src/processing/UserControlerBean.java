package processing;

import java.util.ArrayList;

import model.UserModel;
import fabric.DaoFabric;
import instance.UserDao;

@ManagedBean(name="userControler")

public class UserControlerBean {
	//actions relatives aux utilisateurs
	
	public boolean checkUser(UserModel user){
		
		//TODO faire appel à la DAO
		DaoFabric daoFabric = DaoFabric.getInstance();
		UserDao userDao = daoFabric.createUserDao();
		//check if user exists in userDao.getUsers();
		ArrayList<UserModel> users = userDao.getUsers();
		if(users.contains(user))
		{
			return true;
		}else
		{
			return false;
		}
		
		System.out.println("Bonjour Monde");
		return true;
	}
}
