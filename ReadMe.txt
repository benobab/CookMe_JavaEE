Benjamin Lacroix
Tristan de Fournas
Guillaume Brasiles


							Rendu du projet Java EE : CookMe 
									le 14 Juin 2015


Questions réalisées (rassemblées par package): 

- DAO :	
	+ user
		+ ajout / suppression
		+ checkConnection / checkAdmin
		+ setAdmin
		+ etc.
	+ recipe
		+ récupération (avec / sans paramétres de recherche)
		+ ajout  
		+ récupération des attributs pour la recherche (récupérer tous les types de recettes par exemple)
	+ DAOFabric
		+ singleton, création des DaoUser et DaoRecipe
- Models :
	+ recipe (bean sérialisable)
	+ user (bean sérialisable)
- Controlers :
	+ admin (pour la partie administration)
		+ gestion de connexion admin
		+ affichage de la dernière connexion 
	+ user
		+ gestion de la connexion / deconnexion (via les sessions + DAO)
		+ appels des différentes fonctions de la DAOuser pour les relations BDD
		+ inscription possibles
	+ recipe
		+ appels des différentes fonctions de la DAOrecipe pour les relations BDD
- Validators :
	+ un validator pour chaque champs d'inscription
-vues :
	+ Datatable de résultats de recherche de recette
		+ Tableau de toutes les recettes correspondants à la recherche
	+ Affichage de recette (manque l'interface de commentaires)
		+ Titre / préparation / nombre de personnes etc
	+ template MasterPage.xhtml :
		+ gestion des conditions (si connecté via la session par exemple)
		+ affichage utilisateur connecté + bouton de logout
		+ Tooltips de saisies sur le login	
		+ lien d'accueil dans le footer (cliquer sur le logo)
	+ template Admin spécifique pour les 3 pages d'administration
- Base de données (login : root / pwd : "" sinon, changer ces paramètres dans DAOFabric.java)
	+ création
	+ remplissage en données (recettes / utilisateur)



Questions manquantes : 

-> validation ajax lors de la connexion
-> affichage des recettes trouvées dans une datagrid et non une datatable (datagrid initialisée, mais ensuite manque de temps, mais elle est présente dans le code livré)
-> gestion des commentaires 
-> administration des utilisateurs / recettes (fonctions présentes pour la plupart dans la DAO et controler mais pas intégrée dans la vue par manque de temps)
--> Image lors de l'affichage de la recette (implémenté en base de données, il reste juste à rajouter la restitution dans la vue, très simple car l'attribut img de la recette est une string.. donc balise image avec pour source src="#{recipeControlerBean.getCurrentRecipe().img}" et à ajouter des images dans le projet)


Commentaires : 
1_Un petit manque de temps sur la fin  (voir la section ci dessus "Questions manquantes"). 

2_Le Java EE est un petit peu difficile à prendre en main aux premiers abords, mais 75 % du code a été réalisé dans les 20 derniers % de temps de réalisation, il est donc à noter une forte progression du groupe sur cette technologie.

3_Une grosse difficulté a été de debuger sous eclipse (IDE jamais utilisé pour 2 personnes sur 3 du projet).
