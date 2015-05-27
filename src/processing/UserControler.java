package processing;

import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.UserModel;
import fabric.DaoFabric;
import instance.UserDao;

@ManagedBean(name = "UserControlerBean")
@ApplicationScoped
public class UserControler {
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
		
	}
	
	public boolean addUser(UserModel user){
		DaoFabric daoFabric = DaoFabric.getInstance();		
		UserDao userDao = daoFabric.createUserDao();
		
		if(userDao.checkLogin(user.getLogin()))//renvoie true si on peut ajouter un user
		{
			//On laisse la Dao gérer
			return userDao.addUser(user);
		}else
		{
			return false;
		}
	}
	
	
}
