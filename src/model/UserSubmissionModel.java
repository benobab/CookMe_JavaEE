package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "UserSubmissionModelBean")
@SessionScoped
public class UserSubmissionModel {
//données pour ajouter un user
	
	private String firstname;
	private String lastname;
	private String email;
	private String age;
	private String login;
	private String pwd;
	private String repwd;
	
	
	public UserSubmissionModel()
	{
		
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getRepwd() {
		return repwd;
	}


	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	
}
