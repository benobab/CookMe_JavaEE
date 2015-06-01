package model;

import java.sql.Time;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "recipeModelBean")
@SessionScoped
public class RecipeModel {
	
	


	
	//une recette
	private Time preparation;
	private int difficulte;
	private int personnes;
	private String type;
	private String resume;
	private String procedure;
	private String titre;
	private String img;
	
	public RecipeModel()
	{}
	public RecipeModel(Time prepa,int diff, int pers, String type, String resume, String procedure, String titre, String img)
	{
		this.preparation = prepa;
		this.difficulte = diff;
		this.personnes = pers;
		this.type = type;
		this.resume = resume;
		this.procedure = procedure;
		this.titre = titre;
		this.img = img;
		
	}


	public Time getPreparation() {
		return preparation;
	}


	public void setPreparation(Time preparation) {
		this.preparation = preparation;
	}


	public int getDifficulte() {
		return difficulte;
	}


	public void setDifficulte(int difficulte) {
		this.difficulte = difficulte;
	}


	public int getPersonnes() {
		return personnes;
	}


	public void setPersonnes(int personnes) {
		this.personnes = personnes;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getResume() {
		return resume;
	}


	public void setResume(String resume) {
		this.resume = resume;
	}


	public String getProcedure() {
		return procedure;
	}


	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}

}
