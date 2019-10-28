# README


## Description du site

### Depuis l'index

#### Connexion

* Ne fonctionne pas

#### Inscription

* Nous pouvons inscrire x nouveaux membres mais il n'y a pas encore de vérification élémentaires
	* format du nom ou de l'email(tant de caractères ou caractères interdits), champs vides, ...

#### Espace membre

* C'est le "Hub central" du site une fois qu'on est (hypothétiquement) connecté.
	* On y accède pour l'instant depuis n'importe où
* Nous pouvons voir l'ensemble des membres inscrits et des projets crées
* Les liens de la 1ère barre de headers
	* 'DeadLine' ramène à l'index
	* 'Mon compte' mène vers une page de profil en construction
	* 'Deconnexion' est inactif
* Les liens de la 2ème barre de headers
	* Chacun des liens mène vers sa page respective (encore en construction)
		* 'Messagerie' contiendra la liste des messages que se passeront les membres d'un même projet.
		* 'Calendrier' contiendra l'agenda des activités combiné au calendrier scolaire.
		* 'Repertoire' contiendra le repository.
		* 'Pile de Choses' contiendra la ToDoList
* Le liens de la barre du footer
	* 'Contact' est inactif
* L'onglet 'Nouveau Projet' sur le côté gauche
	* Redirige vers la page de création de projet

##### Creation de projet

* On y accède depuis l'espace membre 
* La liste des membres inscrits y est visible
* Le formulaire permer de créer un nouveau projet
	* Il n'y a pas de vérification des champs vides donc si on clique sur 'Valider', on crée un nouveau projet
* Il y a dans certains navigateurs (Firefox) une incompatibilité avec le datetime-local
	* Le Datepicker du choix de la date de fin ne marche apparement que sur Chrome
	* Sinon la date doit être rentrée manuellement au format (YYYY-MM-JJTHH:MM), ce qui devra être corrigé

##### Gestion de Projet

* On y accède depuis l'espace membre en cliquant sur l'un des projets répertoriés
* Sont visibles :
	* La liste des membres inscrits
	* Le responsable actuel du projet
	* Les taches du projets en cours
* Utilisation de la réecriture d'URL pour que chaque projet ait son propre chemin dans la barre d'adresse (Gérée depuis le controller)
* On peut mettre à jour les données d'un projet, mais l'on doit prendre garde si on change de responsable de projet que celui existe bel et bien.
* Problème du Datepicker déjà mentionné plus haut
* On peut ajouter une nouvelle tache affiliée au projet en cliquant sur le lien

###### Création d'une tache

* On y accède depuis l'espace de gestion d'un projet en cliquant sur l'un le lien pour créer une nouvelle tache




