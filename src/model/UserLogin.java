package model;

import instance.UserDao;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fabric.DaoFabric;


@ManagedBean(name = "UserLoginBean")
@SessionScoped
public class UserLogin implements Serializable{
//permet de récupérer les infos de login
	private String login;
	private String password;
	
	public UserLogin()
	{
		//TODO
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
