package processing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.RecipeModel;

@ManagedBean (name = "dataGridViewBean")
@ViewScoped
public class DataGridView implements Serializable {

	private ArrayList<RecipeModel> recipes;

	private RecipeModel selectedRecipe;

	@PostConstruct
	public void init() {
		// r�cup�re l'espace de m�moire de JSF
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		// place la liste de recette dans l'espace de m�moire de JSF
		recipes.addAll((Collection) sessionMap.get("recipeList"));
	}

	public List<RecipeModel> getRecipes() {
		return recipes;
	}

	public RecipeModel getSelectedCar() {
		return selectedRecipe;
	}

	public void setSelectedRecipe(RecipeModel recipe) {
		this.selectedRecipe = recipe;
	}
}