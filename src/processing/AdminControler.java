package processing;

import java.text.SimpleDateFormat;
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

	private String timeCo="";
	
	
	
	public String getTimeCo() {
		return timeCo;
	}
	public void setTimeCo(String timeCo) {
		this.timeCo = timeCo;
	}



	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}
	

	
	public String isAdmin(UserModel user) {

		// section cookie guillaume

		DaoFabric daoFabric = DaoFabric.getInstance();
		UserDao userDao = daoFabric.createUserDao();
		if (userDao.isAdmin(user)) {
			CookieAdmin cookieA = new CookieAdmin();

			if (cookieA.getCookie("admin") != null) {
				timeCo = cookieA.getCookie("admin").getValue();
			}else
			{
				timeCo = getCurrentTimeStamp();
			}
			cookieA.setCookie("admin", getCurrentTimeStamp(), 50);

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
