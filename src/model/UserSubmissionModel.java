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
}
