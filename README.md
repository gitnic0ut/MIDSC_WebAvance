# README
# MASTER 1 DSC - PROJET WEB - SEMESTRE 7
# SOUS-BRANCHE NICOLAS DE LA BRANCHE MASTER
# VERSION NICOLAS

Le développement de cette version débute le 2019/10/28 vers 15h, peu de temps après le 1er rendu du Projet Web du lundi 28 octobre à 14h00.


## 1 - DOCUMENT README.md

### STRUCURE DU DOCUMENT

1. Document README.md
2. A propos de la branche
3. Contenu de la branche
4. Temps de travail personnel
5. Version de départ de l'application
6. Historique

### OBJET DU DOCUMENT

Ce fichier tiendra le compte de l'avancée, des apports et du temps consacré au projet par le membre lui-même, propriétaire exclusif de la branche.

Chaque membre tiendra le compte **scrupuleux et détaillé** de son travail personnel.

**Lui seul sera autorisé** à rédiger ce document.


----------------------------------

## 2 - A PROPOS DE LA BRANCHE

**Seul le propriétaire de la branche nominative** sera autorisé à faire un quelconque ajout, suppression ou modification au contenu de cette branche


----------------------------------

## 3 - CONTENU DE LA BRANCHE

* README.md
* Dossier ' webProjet '
	* Contient l'application du projet


----------------------------------

## 4 - TEMPS DE TRAVAIL PERSONNEL

### Total

* 18h

### Historique du temps de travail

* [2019-11-04] : 6h
* [2019-10-31] : 8h
* [2019-10-29] : 1h
* [2019-10-28] : 3h


----------------------------------

## 5 - VERSION DE DEPART DE L'APPLICATION

L'application se base se compose d'une version précédent d'une journée le 1er rendu:
* Version du dimanche 27 Octobre 2019 intitulée:
	* [2019-10-27] - Projet - 18h00
		* Il s'agit d'une version **antérieure** à toute fusion
			* Aucun ajout extérieur depuis le début du projet en dehors
				* Du cours
				* Des divers sources internet
			* Aucun apport des autres membres du groupe


----------------------------------

### [2019-11-04]

#### Temps de travail estimé

* 2h de 06h30 à 08h30 - Thymeleaf (Architecture Layout) 
* 4h de 18h à 22h - Thymeleaf && Bootstrap (Intégration du Framework CSS)

#### Thymeleaf

* Mise en place de l'architecture propre à l'usage de Thymeleaf dans Spring Boot
	* **Thymeleaf Layout Dialect**
	* Permet de générer des ' templates ' avec un découpage des éléments
		* Header
		* Main content
		* Footer
	* Le fichier de layout pilote le tout.
	* La structure est :
		* ressources
			* templates
				* fragments
					* header.html
					* footer.html
				* layouts
					* layout.html
	* Modification du pom.xml
		 * Intégration des dépendances nécessaires
		 	* Thymeleaf
		 	* Bug apparue concernant la dépendance de ' Groovy '
		 		* illegal reflective access
		 		* usage d'une **exclusion**
		 * Balises **properties**
		 	* Pour préciser la version de Thymeleaf

* Recours à de nombreuses sources sur internet :
	* [baeldung.com](https://www.baeldung.com/thymeleaf-spring-layouts)
	* [www.thymeleaf.org](https://www.thymeleaf.org/doc/articles/layouts.html)
	* [igorski.co](https://igorski.co/java/spring-boot/layout-dialect-spring-boot-2/)
	* [medium.com](https://medium.com/@omeryazir/layout-with-thymeleaf-on-spring-boot-b604a46e7265)

#### Bootstrap

* Intégration du Framework CSS au projet pour des raisons évidentes de gain de temps
* Elimination définitive du Framework **picnic CSS** utilisé jusque-là
* Tous les fichiers nécessaires (minifiés) ont été placés dans le projet
	* CSS
		* bootstrap.min.css
		* custom.css (fichier destiné à introduire des règles supplémentaires)
	* JS
		* bootstrap.min.js
		* jquery-3.4.1.min.js
* Thymeleaf layout impose une gymnastique supplémentaire
	* Certaines règles de priorité sont apparues
		* layout > tout le reste

* Encore une fois, consultation des documenations et recherches d'exemples :
	* [getbootstrap.com](https://getbootstrap.com/)
	* [mdbootstrap.com](https://mdbootstrap.com/)
	* [startbootstrap.com](https://startbootstrap.com/)
	* [medium.com](https://medium.com/@omeryazir/how-to-integrate-spring-boot-with-bootstrap-and-thymeleaf-5744fc8475d)

#### Visuel

* Thymeleaf Layout et Bootstrap sont intégrés aux 1ères pages:
	* Accueil
	* Connexion
	* Inscription
* Le découpage en module aide énormément à faciliter le travail

#### Sécurité

* Intervention dans le Controller
	* Dans la méthode de redirection vers la page de connection
		* Rajout d'un test supplémentaire 
* Dèsormais, si on clique sur connexion:
	* Non connecté -> on est dirigé vers la page de connexion et son formulaire
	* Connecté     -> on est dirigé vers l'espace membre


_____________________________________________________________ 


## 6 - HISTORIQUE

### [2019-11-15]

#### Temps de travail estimé

* 2h de 06h30 à 08h30 - Sécurité 

#### Sécurité

* Implémentation du logout
* Encodage du mot de passe à l'inscription au format BCrypt 

#### Liste exigée

* Rédaction d'une liste des chose à faire demandée par le groupe 
	* Rédigée la semaine précédente (Temps non compté)

_____________________________________________________________ 

### [2019-10-31]

#### Temps de travail estimé

* 4h de 08h à 12h - Sécutité (restriction des pages) 
* 4h de 14h à 18h - Sécurité (la connexion fonctionne)

#### Sécurité

* Utilisation comme base du fichier distribué en cours:
	* [Code séance 10/04](https://learn.heeere.com/2019-pwa-9s42/raw/cours-10-04.zip)
* Matinée
	* Le code du cours a été implanté et adapté au projet web
	* Les 1ères restrictions de page ont été mise en place:
		* Index, Connexion et Inscription sont laissés visibles par tous
		* L'espace membre, la création et la gestion de projet sont réservés aux ' ADMIN '
	* Un fichier ' data.sql ' a été ajouté dans les ressources
		* Insertion d'utilisateurs et de projets
		* Cela facilite le debuggage 
* Après-midi
	* Le formulaire de connexion est désormais fonctionnel
		* Dans un 1er temps, je teste depuis le formulaire avec la méthode 'param.error' pour voir si les données sont cohérentes.
		* Dans un 2ème temps, les tests sont effectués dans la avec la classe Authentification.
	* Un rôle d'USER est attribué à l'utilisateur qui valide le formulaire avec un login et un mot de passe qui figure dans la BDD
	* **La 1ère phase de la sécurité est mise en place**

_____________________________________________________________

### [2019-10-29]

#### Temps de travail estimé

* 1h de 15h à 16h - README.md

#### README.md

* Rédaction du squelette du document pour chaque membre du groupe
* Dépot du document sur chaque Repository nominatif
* Renommage du README en ' README-[nom du membre].md '
	* Pour éviter le conflit avec le fichier README.md déjà présent
		* Celui-ci décrivait l'application pour le 1er rendu

_____________________________________________________________

### [2019-10-28]

#### Temps de travail estimé

* 1h de 15h à 16h - Github (Sur le site Github.com)
* 2h de 16h à 18h - Sécurité (Recherches internet et cours)

#### Github
* Compréhension du fonctionnement de Git
	* Divers essai-erreurs
		* Création et destruction de divers branches de tests
* Création des Branches pour chaque membre du groupe 
	* Khadidja
	* Chloe
	* Hani
	* Nicolas

#### Sécurité
* Recherche sur le fonctionnement de la sécurité dans Spring Boot
* Besoin pour le projet de créer des sessions
	* lors de la connexion ou de la suppression d'un membre
* Reprise du cours de Web avancé et des documents présents sur le site:
	 * [Programmation Web Avancée − 2019 − M1 DSC](https://learn.heeere.com/2019-pwa-9s42/)
	 * Prticulièrement sur:
	 	* [Slides 6 Some Security](https://learn.heeere.com/2019-pwa-9s42/cours-06.html)
	 	* [Code séance 10/04](https://learn.heeere.com/2019-pwa-9s42/raw/cours-10-04.zip)	 	
	 	* [Morceaux Users/Sécurité](https://learn.heeere.com/2019-pwa-9s42/raw/https-secu-utilisateurs.zip)
* Début des essais sur l'intégration de WebSecurity 

