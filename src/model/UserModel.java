package model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "UserModelBean")
@SessionScoped
public class UserModel implements Serializable{
	
	//un utilisateur
	private String firstname;
	private String lastname;
	private String email;
	private int age;
	private String login;
	private String pwd;

	public UserModel()
	{
		
	}
	public UserModel(String firstname, String lastname, int age, String email,
			String login, String pwd) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
		this.login = login;
		this.pwd = pwd;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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
	
	@Override
	public String toString() { return
	"[FIRSTNAME]:"+this.getFirstname()+",[LASTNAME]:"+this.getLastname()+",[AGE]:"+this.getAge()+",[LOGIN]:"+this.getLogin()+",[PWD]:"+this.getPwd();
	}
	
	
	
	
}
