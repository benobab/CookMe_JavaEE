package instance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	
	public ArrayList<RecipeModel> getRecipes()
	{
		ArrayList<RecipeModel> recipeList = new ArrayList<RecipeModel>();
		
		String sql;
		sql="SELECT * FROM RECETTE";
		try {
			java.sql.Statement query = connection.createStatement();
			 ResultSet r = query.executeQuery(sql);
			 while(r.next())
			 {
				 RecipeModel recipe= new RecipeModel(null, 0,0, " ", " "," "," "," ");
				 recipe.setTitre(r.getString("titre"));
				 recipe.setImg(r.getString("img"));
				 recipe.setDifficulte(r.getInt("difficulte"));
				 recipe.setType(r.getString("type"));
				 recipe.setPersonnes(r.getInt("personnes"));
				 recipe.setPreparation(r.getTime("preparation"));
				 recipe.setResume(r.getString("resume"));
				 recipe.setProcedure(r.getString("procedure"));
				 recipeList.add(recipe);
			 }
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return recipeList;
	}
}
