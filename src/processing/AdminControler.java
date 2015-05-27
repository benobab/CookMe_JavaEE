package processing;

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
}
