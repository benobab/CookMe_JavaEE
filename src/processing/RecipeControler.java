package processing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import instance.RecipesDao;
import model.RecipeModel;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fabric.DaoFabric;

@ManagedBean(name = "recipeControlerBean")
@ApplicationScoped
public class RecipeControler {
	//actions relatives aux recettes
	
	public ArrayList<RecipeModel> getRecipes()
	{
		DaoFabric daofabric = DaoFabric.getInstance();
		RecipesDao recipedao =daofabric.createRecipesDao();
		
		return recipedao.getRecipes();
	}
	
	public ArrayList<RecipeModel> getCurrentRecipes()
	{
		// r�cup�re l'espace de m�moire de JSF
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		// place la liste de recette dans l'espace de m�moire de JSF
		ArrayList<RecipeModel> rt = new ArrayList();
		rt.addAll((Collection) sessionMap.get("recipeList"));
		for(RecipeModel r : rt)
		{
			System.out.println(r.getTitre());
		}
		return rt;
	}
	
	
	public String setCurrentRecipe(RecipeModel recipe)
	{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		// place la liste de recette dans l'espace de m�moire de JSF
		sessionMap.put("recipeList", this.getRecipes(recipe));
		System.out.println("ok");
		return("resultats.jsf");
	}
	
	public ArrayList<RecipeModel> getRecipes(RecipeModel recipe)
	{
		
		ArrayList<RecipeModel> returnArray = new ArrayList<RecipeModel>();
		returnArray.addAll(this.getRecipesByDifficulties(recipe.getDifficulte()));
		for(RecipeModel r: this.getRecipesByNbrOfPersonnes(recipe.getPersonnes()))
		{
			if(!returnArray.contains(r))
			{
				returnArray.add(r);
			}
		}
		for(RecipeModel r: this.getRecipesByType(recipe.getType()))
		{
			if(!returnArray.contains(r))
			{
				returnArray.add(r);
			}
		}
		for(RecipeModel r: this.getRecipesByPreparation(recipe.getPreparation()))
		{
			if(!returnArray.contains(r))
			{
				returnArray.add(r);
			}
		}
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
		{System.out.println(r.toString() + "diff : "+ r.getDifficulte()+ " vs : "+i);
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
	
	public ArrayList<RecipeModel> getRecipesByPreparation( int t)
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
