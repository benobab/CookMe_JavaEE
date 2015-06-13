package processing;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import model.UserModel;
import fabric.DaoFabric;
import instance.UserDao;
 
@ManagedBean(name = "userControlerBean")
@ApplicationScoped
@SessionScoped
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
	
	public void logout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	public boolean isConnected()
	{
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		try {
			 if(session.getAttribute("username")!=null)
			 {
				 return true;
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean isNotConnected()
	{
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		try {
			 if(session.getAttribute("username")!=null)
			 {
				 return false;
			 }
		} catch (Exception e) {
		}
		return true;
	}
	
	public String getUserConnected()
	{
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);	
		return "Bonjour "+ session.getAttribute("username")+ "           ";
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
	
	public boolean checkConnection(UserModel user)
	{
		DaoFabric daoFabric = DaoFabric.getInstance();		
		UserDao userDao = daoFabric.createUserDao();
		if(userDao.testCo(user))
		{
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("username", user.getLogin());
			return true;
		}else
		{
			System.out.println("co pas ok");
			return false;
		}
	}
	
	
}
