
# Retrospective

## Comparé à l'objectif

Le résultat est bien en deça des attentes, nous profiterons de cette 1ère étape pour nous réorganiser.

### Visuel

L'apparence est plaisante mais trop vide pour l'instant.
Il nous faut reprendre de zéro le visuel car 2 frameworks CSS (Picnic et Bootstrap) ont été mélangé, ce qui engendre des conflits.
Nous devons repartir d'un visuel vierge ou bien ne prendre qu'un seul framework.
Nous devons veiller à une véritable cohérence graphique et pas un patchwork disparate (style, polices et formulaires)  

### Sécurité

Il n'y en a pas. 
La page de membre est accessible depuis n'importe quelle page.
La connexion ne crée aucune session.

### Spring Boot

Seule la strucure du site est posée.
Il manque des fonctionnalités essentielles, ce n'est pas acceptable en l'état.
Il n'y a pas de vérification des insertions dans la base, ce qui conduit à nombre d'erreur '404' ou '500' en cas de champs laissés vides ou invalides (en cas d'identifiant absent de la base)


### BDD

* Elle s'est construite de manière incrémentale avec les fonctionnalités:
	* Ajout ou modification des utilisateurs, projets et taches
* Elle a été plus subie que maîtrisée
	* Il faudra faire un schéma plus global et le suivre    


### Organisation du travail

#### La répartition des taches entre les membres du groupes

Perfectible
Le travail doit être réparti plus équitablement entre les membres du groupe

#### Implication des membres sur le projet 

Diverse
Le travail de chacun doit être régulier chaque semaine.

#### Communication entre les membres du groupe 

Irrégulière
Très active à l'approche du rendu mais trop légère en temps normal
