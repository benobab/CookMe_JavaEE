Benjamin Lacroix
Tristan de Fournas
Guillaume Brasiles

Questions réalisées : 
+ template MasterPage.xhtml :
	+ gestion des conditions si connecté via la session 
	+ affichage utilisateur connecté + bouton de logout
	+ Tooltips de saisies sur le login	
+ template Admin spécifique 
+ DAO :	
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
+ Models :
	+ recipe (bean sérialisable)
	+ user (bean sérialisable)
+ Controlers :
	+ admin (pour la partie administration)
	+ user
	+ recipe
+ Datatable de résultats de recherche de recette
+ Affichage de recette (partiel, manque l'interface des commentaires)
+ Base de données
	+ création
	+ remplissage en données (recettes / utilisateur)

Questions manquantes : 
+ validation ajax lors de la connexion
+ affichage des recettes dans une datagrid et non une datatable
+ gestion des commentaires
+ administration des utilisateurs / recettes (présent dans la DAO et controler mais pas intégrée dans la vue)
