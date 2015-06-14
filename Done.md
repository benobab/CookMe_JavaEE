#DONE

##Tristan

+ template MasterPage.xhtml sans gestion de connexion (seulement body + titre)
+ tentative gestion ajax lors de la connexion utilisateur
+ CSS tout le site


##Guillaume

+ activite.xhtml
+ selectAdmin.xhtml
+ Création cookie pour lastConnection avec séparation des fonctions dans cookieAdmin et utilisation dans l'interface d'administration

##Ben
+ Création squelette du programme
+ DAO
	+ user
		+ ajout / suppression
		+ checkConnection / checkAdmin
		+ setAdmin
		+ etc.
	+ recipe
		+ récupération (avec / sans paramétres de recherche)
		+ ajout  
		+ récupération des attributs pour la recherche (tous les types de recettes par exemple)
	+ DAOFabric
		+ singleton, création des DaoUser et DaoRecipe
+ Model
	+ recipe (bean sérialisable)
	+ user (bean sérialisable)
+ Vues sauf selectAdmin.xhtml et activite.xhtml
+ Controlers
	+ admin
	+ user
	+ recipe
+ Datatable de résultats de recherche de recette
+ Amélioration du Template :
	+ gestion des conditions si connecté via la session
	+ affichage utilisateur connecté + bouton de logout
	+ Tooltips de saisies sur le login
+ Affichage de recette (partiel, manque l'interface des commentaires)
+ Base de données
	+ création
	+ remplissage en données (recettes / utilisateur)
+ Fix bug sur les cookies.
