# POO – Gestion de stock d'une bibliothèque (Groupe 09)

## Équipe du Groupe 09

- **GNIMINOU Guillaume Junior Sié Mahora**
- **KIENOU Bèzo Franck Darel Salomon**
- **KONE Larait Eliézer**

---

## 1. Problématique

De nos jours, une bibliothèque regorge d'une grande quantité de documents de plusieurs types. Elle gère parfois ses prêts de façon manuelle ou dispersée, ce qui coûte du temps et crée des risques d'erreur : un document peut sembler disponible alors qu'il est déjà emprunté.

**Questions centrales :**

- Comment modéliser un programme qui permet de connaître à tout instant et sans ambiguïté les documents disponibles et les adhérents ?
- Comment faciliter l'interaction entre le personnel de la bibliothèque et les adhérents ?
- Comment organiser les documents afin de faciliter leur ajout, leur recherche et leur suppression ?

## 2. Reformulation

Le programme permet d'enregistrer les documents et les adhérents d'une bibliothèque, et de gérer en mémoire les opérations d'emprunt et de retour en mettant à jour automatiquement la disponibilité des documents.

Il présente clairement les informations d'un document ou d'un adhérent. Il distingue également les types de documents et leurs durées maximales de prêt : 21 jours pour les livres et 7 jours pour les périodiques.

Le catalogue permet d'ajouter, de supprimer, de rechercher et d'afficher les documents enregistrés. Les numéros des documents servent à identifier les doublons.

## 3. Architecture du Code, Abstraction, Interfaces et Collections

### Structure et encapsulation

- **Visibilité :** Les attributs des classes `Document`, `Livre`, `Periodique`, `Adherent` et `Auteur` sont déclarés en `private` afin de garantir l'encapsulation des données.
- **Classe abstraite `Document` :** Elle rassemble les attributs communs (`numero`, `titre`, `disponible`) et les méthodes abstraites `dureePret()` et `description()`. Un document est une notion générale et ne peut donc pas être instancié directement.
- **Interface `Empruntable` :** Elle exprime la capacité spécifique d'un objet à être emprunté et rendu grâce aux méthodes `emprunter()` et `rendre()`.
- **Interface `CatalogueDocuments` :** Elle définit les opérations disponibles sur le catalogue : ajout, suppression, recherche par numéro, récupération de la liste des documents et affichage.
- **Classe `CatalogueDocumentsMemoire` :** Elle implémente l'interface `CatalogueDocuments` et assure la gestion des documents en mémoire.

### Justification de la hiérarchie retenue

- **Pertinence de l'héritage :** La hiérarchie est pertinente car un `Livre` est un `Document` et un `Periodique` est également un `Document`.
- **Attributs spécifiques :** Le nombre de pages et les auteurs pour un livre ; le numéro de parution pour un périodique.
- **Comportement polymorphe :** La méthode `dureePret()` renvoie 21 jours pour un livre et 7 jours pour un périodique.
- **Capacité d'emprunt :** Seuls les livres implémentent `Empruntable`. Les périodiques ne possèdent donc pas les méthodes d'emprunt et de retour.

### Choix des collections et justification

Pour gérer les documents du catalogue, nous avons utilisé les collections Java suivantes :

- **`List<Document>` :** Cette interface permet de manipuler une liste de documents sans dépendre directement de son implémentation.
- **`ArrayList<Document>` :** Cette implémentation permet de stocker dynamiquement les documents et de les parcourir facilement. Elle conserve également leur ordre d'insertion.
- **`List.copyOf()` :** Cette méthode permet de retourner une copie non modifiable de la liste du catalogue. Elle protège ainsi la collection interne contre les modifications externes.
- **`contains()` :** Cette méthode permet de vérifier si un document existe déjà dans le catalogue. Elle s'appuie sur la méthode `equals()` redéfinie dans `Document`, qui compare les numéros des documents.

Nous avons retenu `ArrayList` parce que notre catalogue nécessite principalement l'ajout, la suppression, le parcours et la recherche de documents. Une structure de type `Map` aurait également pu être envisagée pour accélérer les recherches par numéro, mais elle n'était pas indispensable pour cette version du projet.

### Choix écartés

Nous avons écarté l'idée d'utiliser un simple attribut booléen ou de mettre les méthodes d'emprunt directement dans la classe mère `Document`, car certains types de documents, comme les périodiques, ne doivent pas avoir la capacité d'être empruntés.

## 4. Bilan des Tests et Scénarios (`Main.java`)

Les essais sont exécutés dans la classe `Main.java`. Ils permettent de vérifier le fonctionnement des classes, du polymorphisme, du catalogue et des opérations d'emprunt.

**Les 13 essais cumulés sont les suivants :**

1. Affichage d'un livre à travers une référence de type `Document`.
2. Affichage d'un périodique à travers une référence de type `Document`.
3. Vérification de la durée de prêt d'un livre à travers une référence `Document` : 21 jours.
4. Vérification de la durée de prêt d'un périodique à travers une référence `Document` : 7 jours.
5. Ajout de trois documents dans le catalogue.
6. Tentative d'ajout d'un document portant un numéro déjà utilisé : l'ajout est refusé.
7. Recherche d'un document existant par son numéro.
8. Recherche d'un document inexistant : aucun document n'est retourné.
9. Affichage global du catalogue.
10. Vérification de la protection de la liste retournée : une tentative de modification est refusée et le catalogue reste inchangé.
11. Emprunt ordinaire d'un livre disponible : l'opération réussit.
12. Tentative d'emprunt du même livre alors qu'il est déjà indisponible : l'opération est refusée.
13. Tentative de retour d'un livre déjà disponible : l'opération est refusée.

Des opérations complémentaires sont également exécutées dans la démonstration : le retour ordinaire d'un livre emprunté, l'emprunt d'un second livre, la suppression d'un périodique et l'affichage final du catalogue mis à jour.

## 5. Processus de Travail, Conflits Git et Usage de l'IA

### Résolution des conflits

Pour résoudre ces conflits :

- Nous avons conservé une **définition unique et finale** pour chaque classe.
- Nous avons aligné la classe parente "Document" avec les constructeurs des classes filles "Livre" et "Periodique".
- Nous avons vérifié localement le clonage et la compilation complète du projet avant le push final.

### Déclaration de l'usage de l'IA

Au cours de ce travail, nous avons utilisé un assistant IA pour identifier et corriger les erreurs de compilation liées à la désynchronisation des dépôts GitHub sur le projet entre les membres de l'équipe.
