# poo-bibliotheque-groupe Gestion de stock d'une bibliothèque 

**L'equipe du groupe 09 est  constituée de :**  
*GNIMINOU Guillaume Junior Sié Mahora,  
*KIENOU   Bézo Franck Darel Salomon, 
*KONE Eliezer.


**Problématique:** 


Une bibliothèque gère aujourd'hui ses prêts de façon manuelle ou dispersée, ce qui coûte du temps et crée des risques d'erreur parce qu’un document peut sembler disponible alors qu'il est déjà emprunté.  
Les questions centrales sont donc :  
Comment modéliser un programme qui permette de savoir à tout instant, rapidement et sans ambiguïté ?  
Quels sont les documents disponibles et quels adhérents les ont empruntés ?  Afin de fluidifier l'interaction entre le personnel de la bibliothèque et les adhérents.


**Reformulation:**

Le programme doit permettre d'enregistrer les documents et les adhérents d'une bibliothèque, et de gérer en mémoire les opérations d'emprunt et de retour en mettant à jour automatiquement la disponibilité des documents. Il doit aussi pouvoir présenter clairement les informations d'un document ou d'un adhérent, sans gérer pour l'instant les dates, retards, pénalités ni historique.  
Les classes proposées sont : document et adhérent. Les attributs sont respectivement numero(int), titre(String), auteur(String), disponible(boolean) et numero(int), nom(String), email(String). Les methodes de document sont emprunter(), rendre() et afficher et celle de adhérent est afficher(). L'attribut disponible(boolean) qui est initialisé à true pour présenter un document neuf ou non emprunté.  


Héritage et Polymorphisme

**Structure du Code et Encapsulation**  
*Visibilité: Tous les attributs des classes (`Document`, `Livre`, `Periodique`, `Adherent`) sont déclarés en **`private`** pour garantir la bonne encapsulation des données.
- **Classe Abstraite :** La classe `Document` a été rendue **`abstract`** et comporte la méthode abstraite `dureeMaxPret()`.


**Justification de la hiérarchie retenue**  
*Pertinence de l'héritage: La hiérarchie est pertinente car un "Livre" est un "Document" et un "Périodique" est un "Document". Ils partagent tous les caractéristiques de base d'un document.


**Pourquoi "Document" est une classe abstraite ?** 

"Document" regroupe les attributs et comportements communs ("numero", "titre", "auteur", "isponible", "emprunter()", "rendre()"), mais ne représente pas un objet physique concret que l'on instancie directement.


**Ce qui varie entre les sous-types :**  


*Attributs spécifiques: Le nombre de pages ("nombrePages") pour un livre, le numéro de parution ("numeroParution") pour un périodique.  
*Comportement polymorphe: La méthode `dureeMaxPret()` renvoie **21 jours** pour un livre et **7 jours** pour un périodique.
