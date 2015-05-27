package instance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.UserModel;

public class UserDao {
	
	private Connection connection;
	
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;
	
	
	public UserDao(String db_HOST, String db_PORT, String db_NAME,
			String db_USER, String db_PWD) {
		this.dB_HOST = db_HOST;
		this.dB_PORT = db_PORT;
		this.dB_NAME = db_NAME;
		this.dB_PWD = db_PWD;
		this.dB_USER = db_USER;
		
		try {
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+dB_HOST+":"+dB_PORT+"/"+dB_NAME, dB_USER, dB_PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<UserModel> getUsers()
	{
		ArrayList<UserModel> userList = new ArrayList<UserModel>();
		
		String sql;
		sql="SELECT * FROM USER";
		try {
			java.sql.Statement query = connection.createStatement();
			 ResultSet r = query.executeQuery(sql);
			 while(r.next())
			 {
				 UserModel user= new UserModel(" ", " ", 0," "," "," ");
				 user.setLastname(r.getString("lastname"));
				 user.setFirstname(r.getString("firstname"));
				 user.setAge(r.getInt("age"));
				 user.setLogin(r.getString("login"));
				 user.setPwd(r.getString("pwd"));
				 userList.add(user);
			 }
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}
	
	public boolean checkLogin(String log)
	{
		String sql;
		int logintrouve =1;
		sql="select count(*) AS total from user where login like '"+log+"'";
		try {
			java.sql.Statement query = connection.createStatement();
			 ResultSet r = query.executeQuery(sql);
			 while(r.next())
			 {
				 logintrouve= r.getInt("total");
				 if(logintrouve==0)
				 {
					 break;
				 }
			 }
				 connection.close();
			 
			 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(logintrouve==0)
		 {
			 return true;
		 }else
		 {
			 return false;
		 }
	}
	
	public boolean addUser(UserModel user)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+dB_HOST+":"+dB_PORT+"/"+dB_NAME, dB_USER, dB_PWD);
			} catch (SQLException e) {
				System.out.println("Erreur apres connection insert");
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
			                     e.printStackTrace();
			}
		java.sql.Statement query;

		try {
			query = connection.createStatement();
			query.execute("INSERT INTO USER ( firstname, lastname,age,mail,login,pwd) VALUES ('"+user.getFirstname()+"','"+user.getLastname()+"','"+user.getAge()+"','"+user.getEmail()+"','"+user.getLogin()+"','"+user.getPwd()+"')");	
			connection.close();
		} catch (SQLException e) {
			System.out.println("Erreur après insert");
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
