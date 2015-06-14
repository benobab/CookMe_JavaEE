package processing;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.ServletContext;

import fabric.DaoFabric;
import instance.UserDao;
import model.UserModel;

@ManagedBean(name = "adminControlerBean")
@ApplicationScoped
public class AdminControler {
	// Actions relatives à l'interface d'administration

	public String isAdmin(UserModel user) {
		
		// section cookie guillaume
		System.out.println("OK_1");
		CookieAdmin cookieA=new CookieAdmin();
		cookieA.setCookie("admin", "cookie de Guillaume",50 );
		if(cookieA.getCookie("admin")!=null)
		System.out.println("COOKIE: "+cookieA.getCookie("admin").getValue());
		
		DaoFabric daoFabric = DaoFabric.getInstance();
		UserDao userDao = daoFabric.createUserDao();
		if (userDao.isAdmin(user)) {
			
			
			return ("selectAdmin.jsf");
		}

		return ("login.jsf");
	}

	public ArrayList<UserModel> getUsers() {

		DaoFabric daoFabric = DaoFabric.getInstance();
		UserDao userDao = daoFabric.createUserDao();
		// check if user exists in userDao.getUsers();
		return userDao.getUsers();
	}

	public void setAdmin(UserModel user) {
		DaoFabric daoFabric = DaoFabric.getInstance();
		UserDao userDao = daoFabric.createUserDao();
	}

}
