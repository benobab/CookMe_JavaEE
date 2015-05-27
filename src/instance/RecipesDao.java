package instance;

import java.sql.Connection;
import java.sql.SQLException;

import model.RecipeModel;
import model.UserModel;

public class RecipesDao {
	
	private Connection connection;
	
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;
	
	public RecipesDao(String db_HOST, String db_PORT, String db_NAME,
			String db_USER, String db_PWD) {
		
		this.dB_HOST = db_HOST;
		this.dB_PORT = db_PORT;
		this.dB_NAME = db_NAME;
		this.dB_PWD = db_PWD;
		this.dB_USER = db_USER;
	}

	
	
	public void addRecipe(RecipeModel recipe)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+dB_HOST+":"+dB_PORT+"/"+dB_NAME, dB_USER, dB_PWD);
			} catch (SQLException e) {
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
			                     e.printStackTrace();
			}
		
		java.sql.Statement query;

		try {
			query = connection.createStatement();
			query.execute("INSERT INTO USER VALUES ('"+recipe.getPreparation().toString()+"','"+recipe.getDifficulte()+"','"+recipe.getPersonnes()+"','"+recipe.getType()+"','"+recipe.getResume()+"','"+recipe.getProcedure()+"','"+recipe.getTitre()+"','"+recipe.getImg()+"')");	
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
