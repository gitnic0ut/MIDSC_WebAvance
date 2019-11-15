#PROJET WEB - LISTE EXIGÉE POST 1ER RENDU
#NICOLAS TROTTA - 09/11/2019

##Plan

1. Instructions
2. Rappel du sujet
3. Applications référentes
4. Dates importantes
5. Taches à accomplir
6. Partage des taches


--------------------

##1. INSTRUCTIONS

* Ce fichier est lisible naturellement car les balises sont très claires, mais pour profiter d'une apparence plus avantageuse, il est possible de :
	* Se rendre sur [markdownlivepreview](https://markdownlivepreview.com/)
		* Copier-coller son contenu sur la fenêtre de gauche
		* Observer le résultat sur la page de droite
	* Uploader le fichier sur [GitHub](https://github.com/) dans une de ses branches
		* La preview des fichiers Markdown est prise en charge sur le site  


--------------------

##2. RAPPEL DU SUJET

Tout est déjà dans le rapport prélimainaire et toutes les fonctionnalités figurent déjà dans nombre d'applications référentes, mais au besoin, nous rappelons que :

* Il s'agit d'une application de gestion projets étudiants, qui offre la possibilité à ses utilisateurs une fois connectés de créer des projets et de créer pour chaque projet des taches.
* Il sera possible de déposer des messages aux membres avec lesquels un utilisateur partage un ou plusieurs projets communs.
* Pour chaque projet, un utilisateur pourra déposer les fichiers qui le composent et l'accompagnent.
* L'organisation des projets pourra avoir lieu depuis une page prenant soit l'apparence :
	* d'une ToDoList
	* d'un tableau Kanban

--------------------

##3. APPLICATIONS RÉFÉRENTES

###Portail étudiant

*  [ENT MyUJM](https://cas.univ-st-etienne.fr/esup-cas/login?service=https://ent.univ-st-etienne.fr/uPortal/Login)

###Gestion de projet

* [TeamGantt](https://www.teamgantt.com/)
* [Trello](https://trello.com/)
* [Kanboard](https://kanboard.org/)


--------------------

##4. DATES IMPORTANTES


###Rendu projet et document

**Tout est repris des consignes du sujet**

* 9 décembre 2019 23h59
	* Via GitHub
	* Contient :
		* le projet
		* les 3 fichiers '.md' 
			* README.md
			* retrospective.md
			* auto-evaluation.md (**cette fois non vide**)


=============================

###Soutenance du projet 

**Tout est repris des consignes du sujet**

* 10 décembre 2019 de 13h30 à 17h30
	* 1ère partie en présentant le projet comme un produit à vendre
		* pas trop de détails techniques
	* 2ème partie rétrospective
		* évaluation honnête du travail


--------------------

##5. TACHES À ACCOMPLIR 


###Organisation et règles

* Rattraper le retard abyssal sur l'ensemble du projet
* Travailler chaque semaine sur le projet entre chaque séance du cours de Web Avancé
* Partager équitablement du travail entre chaque membre
* Chaque membre doit tenir le ' journal ' de son propre travail
	* via le fichier README de sa branche sur GitHub 

=============================

###GitHub

L'organisation du travail fera partie intégrante de la note, pour bien faire il faudrait également se servir d'une application en ligne gratuite du type de [Kanboard](https://kanboard.org/) ou [Trello](https://trello.com/), [GitHub](https://github.com/) dispose de façon native de ce type de fonctionnalité.


####Dans l'idéal

Il faudrait se servir du terminal GitBash pour faire des 'push' mais à défaut dans un 1er temps, tout est pilotable depuis le site de GitHub. 


####Usage 

* Chaque membre dispose d'une branche GitHub nominative
* Déposer son travail au moins à la fin de chaque journée de travail
* Chaque membre doit tenir le compte scrupuleux de son propre travail	
	* Remplir le fichier 'README[prénom].md'
		* Détail des heures consacrées au projet
		* Détail du travail effectué en précisant la tache 


####Syntaxe du langage Markdown

* Vous lisez actuellement un fichier Markdown
	* la syntaxe est facile à comprendre
	* les balises faciles à écrire.
* Ce type de fichier permet la rédaction : 
	* de README ou 
	* de documentations techniques.
* Comme les fichiers à rendre avec le projet et les rapports de travail quotidient vont être écrits dans ce format, autant se familiariser avec le plus tôt possible.


=============================

###Gestion des données entrantes et sortantes

TP2 du prof avec les fruits


####Gestion général depuis Spring Boot

* Gestion depuis H2-console
* Choix des options dans 'application.properties'


####Pilotage de l'application depuis le/les controller(s) de Spring Boot

* Écriture des méthodes pour intérragir avec chaque Bean du site
* Modification des données depuis le controller
	* Pour appliquer un contrôle ou un rajout avant de sauvegarder le contenu de chaque modèle en BDD
	* Pour vérifier des données déjà présentes dans la BDD avant une insertion, une modification ou une suppression dans cette même base de données
	* Effectuer une série de tests pour afficher des données dans la vue dépendantes de certaines conditions :
		* si un utilisateur est d'un certain rang (USER, ADMIN)
		* si des données respectent certains critères avant d'être affichées:
			* choix des utilisateurs dans leur espace personnel
			* choix des admins
		* si des champs donnés contiennent des valeurs:
			* inférieures, suppérieures ou égales à une certaine valeur
			* sont null ou pas
			* sont des chaînes de caractères égales ou différentes à celles testées


####Création de tout le schéma de la base de données

* Faire un schéma cohérent et fonctionnel
	* Respect de toutes les règles afin que des soucis de conception de rendent pas impossible l'insertion, la modification ou la suppression de données


####Création de la base de données par l'intermédiaire des classes

* Usage de toutes les annotaions JPA et paramétrages nécessaires
	* @id
	* @Inject
	* @Entity
* Tables de liaison
	* Usage des annotations JPA
		* @ManyToOne
		* @OneToMany
		* @ManyToMany
		* @JoinColumn
		* ...


#####Gestion de toutes les interractions entre les différentes tables

* Respecter l'intégrité référentielle entre les tables
	* UPDATE && DELETE en cascade :
		* Comment faire quand plusieurs tables contiennent des données communes
			* ex: Suppression d'un utilisateur qui est inscrit sur plusieurs projets qui sont eux-même rattachés à plusieurs membres inscrits et contiennent plusieurs taches, qui sont elles-mêmes associées à plusieurs utilisateurs.
			* ex: Réattribution d'un projet à un autre membre responsable, qui contient plusieurs taches, etc
			* ...
	* INSERT problématiques :
		* chaque projet doit avoir un membre responsable, comment le créer s'il n'y en a pas (base de données vide ou totalité des membres effacés) ?
		* comment s'assurer que chaque tache lors de sa création : 
			* soit bien la tache d'un projet
			* que le projet soit bien celui d'un membre
			* que le membre soit bien rattaché à ce projet puis à la tache créee
			* ... 
 

####Création des pages HTML et assurance que celles-ci sont bien intégrées au projet par le controller

* Aucune page ne doit conduire à une erreur 403, 404 ou 500
* Chaque page doit avoir accès au contenu de la base de données


####Création de tous les formulaires permettant la gestion des données

* Liaison entre le Controller et chaque formulaire
* Contrôle des données rentrées par l'utilisateur
	* Champs vides
	* 2 champs passwords pour la confirmation lors de l'insertion
	* Format spéciaux
		* email
		* dates
	* ...
* Assurance que les donnnées sont bien :
	* rentrées dans la base de données si les conditions sont respectées
	* non insérées sinon


=============================

###Sécurité

La partie sécurité est plus globale que la permission pour un USER ou un ADMIN d'accéder à l'espace membre. Il 

####Gestion plus fine des profils

* Il n'y a pour l'instant que ROLE_USER ou ROLE_ADMIN mais pas les 2
	* Chaque type de membre ne doit pas avoir les même restrictions
* Récupération et affichage :
	* des informations du profil d'un membre sur son espace perso pour que celui-ci puisse :
		* les consulter
		* les modifier


####Affichage du contenu selon le status de l'utilisateur

* La partie affichage du site sera impactée par le fait que :
	* l'utilisateur sera connecté ou pas
	* si le membre est connecté, le contenu du visuel pourra en être impacté
* L'exemple le plus parlant est bien entendu l'affichage des barres de navigation :
	* Selon la page sur laquelle navigue l'utilisateur, le contenu changera
		* il ne faudra pas modifier chaque page mais :
			* prévoir des cas dans le module thymeleaf dévolu à cette tache
				* header, barre_nav_top, barre_nav_side, ... 
* Selon les différentes vairiables de session, il faut :
	* Si l'utilisateur n'est pas connu :
		* limité les informations auxquelles il a accès
	* Si le membre est identifié et connecté
		* affiché les informations auxquelles sont status lui donne accès
* Dans tous les cas :
	* Se charger de piloter le tout depuis le Controller de l'application 
	* Modifier les classes et donc la BDD si besoin
		* tables à rajouter pour stocker des informations supplémentaires
		* determiner avec le responsable de l'équipe de la ' **Gestion des données entrantes et sortantes** '
			* comment ne pas créer des problèmes : 
				* de tables orphelines
				* d'intégrité référentielle 


=============================

###Visuel

* Cette partie concerne tout ce que l'utilisateur verra à l'écran.
	* Design
	* Interractions utilisateur / application
* Le javascript pour tout l'aspect dynamique des pages
* Maquettes des pages du sites
	* (si celle-ci sont respéctées autrement pas d'utilité)
* Cohérence graphique de l'ensemble du site
	* les différentes pages n'ont pas l'air d'appartenir à un site différent
		* polices d'écriture
		* Barres de navigation
		* Couleurs
		* ...


=============================

###Intégration Framework CSS 

Sous-partie de visuel.

 * Ce n'est qu'une sous-partie du visuel
 * L'usage de Bootstrap ou d'un autre Framework CSS est faîte à la base :
 	* pour gagner du temps sur une partie qui n'est pas bloquante pour l'application
 	* ne pas réinventer la roue en repartant de zéro
 	* 
 * Les choix faits dans la partie ' Visuel ' doivent être rspectés
 	* La maquette des pages doivent être transposés


=============================

###Javascript

Sous-partie de visuel.

En cas de non utilisation d'un Framework CSS

* **Si le choix a été fait de s'asseoir sur les avantages qu'offrent** :
	* Bootstrap
	* JQuery
* Toutes les intérractions que l'on attend naturellement d'un site dynamique doivent :
	* être **gérées en manuellement Javascript natif** (façon pûre et dure)
		 * abandon des modules proposés dans les frameworks
		 * écriture en javascript de **chacun** d'entre-eux
* Types d'interractions :
	* Gestion plus fine de tous les formualaires
		* Cas d'erreurs dans les champs
	* Gestion des barres de navigation :
		* menus déroulants
* Création à la main de (trop de choses à lister) :
	* la ToDoLIst
		* déplacement des cases
		* cas d'erreurs et de conflits
	* toute la récupération des informations de la page
		* avec la méthode 'document()'
		* récupération du contenu des champs
	* Repository
		* ajout d'un carroussel d'image ou d'un galerie
	* Planning
		* tableau des créneaux
		* clic sur les cases
			* gestions des cas et des erreurs
	* Repository ou ToDoList ou Planning
		* Drag&Drop
	* gestion du temps
	* + tout le reste
		* ...


=============================

###Vue.JS

Ce framework Javascriptest censé accompagner/compléter/remplacer l'usage de Thymeleaf. 

* Comprendre son fonctionnement
* L'employer à bon escient en fonction :
	* de ce qui a été montéé en cours
	* des usages éclairés vues sur le ressources :
		* des tutoriaux
		* des vidéos youtubes
		* de la documentation de Vue.JS


=============================

###API REST

 * Comprendre son fonctionnement et son utilité
 * (se référer à ce qui a été dit plus haut sur Vue.JS)
 * Compréhension des méthodes :
 	* GET
 	* POST
 	* PUT
 	* PATCH
 	* DELETE
 	* ...
 * HateoAS 


=============================

###Gestion du planning des membres

* Création des créneaux dans la BDD
	* Créneaux scolaires
		* heures de cours
		* salles
		* activité
		* enseignant responsable
		* ...
	* Créneaux du projet
		* projet en général
		* détail des taches
* Recherche dans la base de données pour l'affichage du planning
	* des créneaux scolaires
	* des créneaux 
	* de la combinaison des 2 


=============================

###Messagerie

* Création d'une interface de type forum
	* affichage des membres présents
* Si la connexion de plusieurs utilisateurs est gérée
	* messagerie en direct entre les membres 
		* d'un même projet
		* de toute l'application
	* sauvegarde des messages et affichage à un membre qui viendrait de se connecter
* Sinon
	* dépôt simple de messages


=============================

###Repository

* Dépot de fichiers
	* Entre plusieurs membres d'un même projet
	* Associés à une tache particulière


=============================

###Gestion des sessions

* A distinguer de la sécurité
* Connexion simultanées de plusieurs utilisateurs
* Ne fait pas partie à proprement parler de la sécurité
* Opération simultanée de plusieurs membres
	* que se passe-t-il quand 2 membres :
		* tentent de modifier une tache ou un projet en même temps ?


=============================

###Hebergement

* Pour la démonstration, il faudrait que l'application soit stockée sur un serveur


=============================

###Rédaction de la Javadoc

* Annotation précise de toutes :
	* les classes
	* les methodes
	* les attributs

* Génération de la Javadoc


=============================

###Vérification de la conformité de la norme W3C

* Scan de tous les fichiers HTML et CSS sur [W3C Unicorn](https://validator.w3.org/unicorn/?ucn_lang=fr)


=============================

###Rendu du projet

* Rédaction des 3 fichiers demandées
	* README.md
	* retrospective.md
	* auto-evaluation.md 
* Récupération du détail des heures et des taches effectuées par chaque membre du groupe
	* Remise en forme pour le fichier 'auto-evaluation.md'
* Dépot du projet sur GitHub par GitBash


=============================

###Préparation à la soutenance

* Planning pour les 2 parties de la soutenance
	* Simulacre d'une présenation de type commerciale
	* Retrospective
* Production du PowerPoint pour vendre et présenter le projet au 'client'
* Attribution du contenu des interventions de chaque membre
* Répétitions des membres en vue du passage 


--------------------

##6. PARTAGE DES TACHES

Mon avis n'a pas changé d'un iota depuis le départ du projet.

* Chacun des membres doit s'occuper d'une large partie qui ne se cantonne pas
	* à une page précise
	* à un module unique
* Chaque partie est l'affaire **d'un membre**, **il en a la charge** :
	* Il doit de lui-même éplucher toutes les ressources disponibles de tout ce qui a attrait
		* Aux technologies requises pour construire sa partie 
		* A l'architecture des modules produits
			* ex: Découpage logique des pages thymeleaf en :
				* layout, header, footer, ...
				* Organisation des fichiers de Spring Boot
				* Schéma de la BDD
				* ...
		* Aux bonnes pratiques de programmation
			* Bonne lisibilité du code
			* Commentaires
			* ...

=============================

###Découpage en 4 dans l'immédiat

####a) Visuel

	*Pas besoin de 2 membres sur cette partie, 
		* les templates (sans les copier bien-entendu) :
			* aident à ne pas partir de rien
			* font gagner un temps considérable.
	* Thymeleaf
		* le découpage logique est déjà mis en place
			* Plus besoin de travailler sur toutes les pages individuellement
				* ex: une modification dans le header :
					* sera effective dans toutes les pages l'incluant
					* pourra même dépendre de conditions
	* Intégration Bootstrap ou Javascript pur

####b) Spring Boot

	* Gestion des données entrantes et sortantes
		* BDD
		* formulaires de :
			* connexion 
			* d'inscription
			* de gestion, d'ajouts, de suppression
				* d'utilisateurs
				* de projets
				* de taches
				* de créneaux de planning
				* ...

####c) Vue.JS & REST

	* Comprendre comment et quoi intégrer au projet
	* Travailler sur la transition thymeleaf/Vue.JS
	* Produire les modules nécessaires à l'implémenation dse 2 technologies
 
####d) Ce qui reste

	* Sécurité
	* Repository
	* Messagerie
	* Planning