package processing;

import java.sql.Time;
import java.util.ArrayList;

import instance.RecipesDao;
import model.RecipeModel;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import fabric.DaoFabric;

@ManagedBean(name = "recipeControlerBean")
@ApplicationScoped
public class RecipeControler {
	//actions relatives aux recettes
	ArrayList<RecipeModel> recipeTmp = new ArrayList<RecipeModel>();
	
	public ArrayList<RecipeModel> getRecipes()
	{
		DaoFabric daofabric = DaoFabric.getInstance();
		RecipesDao recipedao =daofabric.createRecipesDao();
		
		return recipedao.getRecipes();
	}
	
	public ArrayList<String> getRecipesString(int pers,int diff, Time time, String type)
	{
		ArrayList<RecipeModel> recipesArray = this.getRecipes(pers,diff,time,type);
		ArrayList<String> recipesString = new ArrayList<String>();
		for(RecipeModel r : recipesArray)
		{
			recipesString.add(r.getTitre());
			System.out.println("<h3>"+r.getTitre()+"</h3><br />");
		}
		
		return recipesString;
	}
	
	public ArrayList<RecipeModel> getRecipes(int pers,int diff, Time time, String type)
	{
		
		ArrayList<RecipeModel> returnArray = new ArrayList<RecipeModel>();
		
		returnArray.addAll(this.getRecipesByDifficulties(diff));
		for(RecipeModel r: this.getRecipesByDifficulties(diff))
		{
			if(!returnArray.contains(r))
			{
				returnArray.add(r);
			}
		}
		for(RecipeModel r: this.getRecipesByNbrOfPersonnes(pers))
		{
			if(!returnArray.contains(r))
			{
				returnArray.add(r);
			}
		}
		for(RecipeModel r: this.getRecipesByType(type))
		{
			if(!returnArray.contains(r))
			{
				returnArray.add(r);
			}
		}
		for(RecipeModel r: this.getRecipesByPreparation(time))
		{
			if(!returnArray.contains(r))
			{
				returnArray.add(r);
			}
		}
		recipeTmp.addAll(returnArray);
		return returnArray;
	}
	
	
	
	public ArrayList<String> getRecipesTypes()
	{
		DaoFabric daofabric = DaoFabric.getInstance();
		RecipesDao recipedao =daofabric.createRecipesDao();
		ArrayList<String> returnArray = new ArrayList<String>();
		for(RecipeModel r : recipedao.getRecipes())
		{
			if(!returnArray.contains(r.getType()))
			{
				returnArray.add(r.getType());
			}
		}
		return returnArray;
	}
	
	public ArrayList<RecipeModel> getRecipesByDifficulties( int i)
	{
		DaoFabric daofabric = DaoFabric.getInstance();
		RecipesDao recipedao =daofabric.createRecipesDao();
		ArrayList<RecipeModel> returnArray = new ArrayList<RecipeModel>();
		for(RecipeModel r : recipedao.getRecipes())
		{
			if(r.getDifficulte()==i)
			{
				returnArray.add(r);
			}
		}
		return returnArray;
	}
	
	public ArrayList<RecipeModel> getRecipesByNbrOfPersonnes( int i)
	{
		DaoFabric daofabric = DaoFabric.getInstance();
		RecipesDao recipedao =daofabric.createRecipesDao();
		ArrayList<RecipeModel> returnArray = new ArrayList<RecipeModel>();
		for(RecipeModel r : recipedao.getRecipes())
		{
			if(r.getPersonnes()==i)
			{
				returnArray.add(r);
			}
		}
		return returnArray;
	}
	
	public ArrayList<RecipeModel> getRecipesByType( String type)
	{
		DaoFabric daofabric = DaoFabric.getInstance();
		RecipesDao recipedao =daofabric.createRecipesDao();
		ArrayList<RecipeModel> returnArray = new ArrayList<RecipeModel>();
		for(RecipeModel r : recipedao.getRecipes())
		{
			if(r.getType() == type)
			{
				returnArray.add(r);
			}
		}
		return returnArray;
	}
	
	public ArrayList<RecipeModel> getRecipesByPreparation( Time t)
	{
		DaoFabric daofabric = DaoFabric.getInstance();
		RecipesDao recipedao =daofabric.createRecipesDao();
		ArrayList<RecipeModel> returnArray = new ArrayList<RecipeModel>();
		for(RecipeModel r : recipedao.getRecipes())
		{
			if(r.getPreparation() == t)
			{
				returnArray.add(r);
			}
		}
		return returnArray;
	}
	
	
}
