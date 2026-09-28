&#x20;POO \_ Gestion de stock d'une bibliothèque (Groupe 09)



&#x20;\*\*Équipe du Groupe 09\*\*

\* \*\*GNIMINOU Guillaume Junior Sié Mahora\*\*

\* \*\*KIENOU Bèzo Franck Darel Salomon\*\*  

\* \*\*KONE Larait Eliézer\*\*







&#x20;\*\*1.Problématique\*\*

De nos jours, une bibliothèque regorge d'énorme quantité de document de plusieurs types (abstrait); elle gère aujourd'hui ses prêts de façon manuelle ou dispersée, ce qui coûte du temps et crée des risques d'erreur parce qu’un document peut sembler disponible alors qu'il est déjà emprunté.



\*\*Questions centrales :\*\*

\* Comment modéliser un programme qui permet de savoir à tout instant et sans ambiguïté quels sont les documents disponibles et quels sont les adhérents qui les ont empruntés ?

\* Comment faciliter l'interaction entre le personnel de la bibliothèque et les adhérents ?







&#x20;\*\*2.Reformulation\*\*

Le programme permet d'enregistrer les documents, les adhérents d'une bibliothèque, et de gérer en mémoire les opérations d'emprunt et de retour en mettant à jour automatiquement la disponibilité des documents. Il présente clairement les informations d'un document ou d'un adhérent, en gérant les dates de retours et d'emprunt avec une durée maximale de 21 jours pour les livres et 7 jours pour les périodiques.







&#x20;\*\*3.Architecture du Code, Abstraction \& Interface\*\*



&#x20;\*\*Structure \& Encapsulation\*\*

\* \*\*Visibilité:\*\* Tous les attributs des classes ("Document", "Livre", "Periodique", "Adherent") sont déclarés en "private" pour garantir une stricte encapsulation des données.

\* \*\*Classe Abstraite ("Document") :\*\* La classe "Document" rassemble les attributs ("numero", "titre", "disponible") ainsi que les méthodes "dureeMaxPret()" et "description()" déclarées en "abstract". Un document ne représente pas un objet physique concret et ne peut donc pas être instancié directement.

\* \*\*Interface ("Empruntable") :\*\* L'interface "Empruntable" exprime la capacité spécifique d'un document à être prêté et rendu via les méthodes "emprunter()" et "rendre()".



&#x20;\*\*Justification de la hiérarchie retenue\*\*

\* \*\*Pertinence de l'héritage :\*\* La hiérarchie est pertinente car un "Livre" est un "Document" et un "Periodique" est un "Document".

\* \*\*Ce qui varie entre les sous types :\*\*

&#x20; \* \*\*Attributs spécifiques :\*\* Le nombre de pages ("nombrePages") et l'auteur ("auteur") pour un livre ; le numéro de parution ("numeroParution") pour un périodique.

&#x20; \* \*\*Comportement polymorphe:\*\* La méthode "dureeMaxPret()" renvoie 21 jours pour un livre et 7 jours pour un périodique.

&#x20; \* \*\*Capacité d'emprunt:\*\* Conformément à l'énoncé, seuls les livres implémentent "Empruntable". Les périodiques ne sont pas empruntables.



&#x20;\*\*Choix écarté\*\*

Nous avons écarté l'idée d'utiliser un simple attribut booléen ou de mettre les méthodes d'emprunt directement dans la classe mere "Document", car certains types de documents (comme les périodiques) ne doivent pas avoir la capacité d'être empruntés.





&#x20;**\*\*4.Bilan des Tests \& Scénarios (Main.java)\*\***



**Dans la classe "Main.java", le scénario de test valide les 4 cas exigés:**

**1. \*\*Cas ordinaire (Emprunt: Emprunt du "Enfant Noir" par KONE Eliezer) :\*\* Succès de l'emprunt d'un livre disponible.**

**2. \*\*Cas limite (Refus d'emprunt: Tentative d'emprunt du même livre par KIENOU Franck) :\*\* Tentative d'emprunt d'un livre déjà indisponible (affichage d'un message de refus explicite).**

**3. \*\*Cas ordinaire (Retour: Retour du livre par l'adhérent) :\*\* Succès du retour du livre emprunté.**
**4. \*\*Cas limite (Refus de retour: Nouvelle tentative de retour du même livre) :\*\* Tentative de retour d'un livre déjà disponible dans la bibliothèque.**







&#x20;\*\*5.Processus de Travail, Conflits Git \& Usage de l'IA\*\*



&#x20;\*\*Résolution des conflits\*\* 

Pour résoudre ces conflits :

\* Nous avons conservé une \*\*définition unique et finale\*\* pour chaque classe.

\* Nous avons aligné la classe parente "Document" avec les constructeurs des classes filles "Livre" et "Periodique".

\* Nous avons vérifié localement le clonage et la compilation complète du projet avant le push final.



&#x20;\*\*Déclaration de l'usage de l'IA\*\*

Au cours de ce travail, nous avons utilisé un assistant IA pour identifier et corriger les erreurs de compilation liées à la désynchronisation des dépot github sur le projet entre les membres de l'équipe.





&#x20;\*\*6.Répartition du Travail\*\*



\* \*\*GNIMINOU Guillaume Junior Sié Mahora :\*\* Conception et implémentation de la classe abstraite "Document" et Implémentation de la classe "Adherent".

\* \*\*KIENOU Bèzo Franck Darel Salomon :\*\* Implémentation de la classe concrète "Livre" et de la classe concrète "Periodique". 

\* \*\*KONÉ Larait Eliezer :\*\* De la classe exécutable "Main" (démonstration du polymorphisme et exécution des 4 scénarios de test),de l'interface "Empruntable", et gestion de la logique d'emprunt/retour avec validation. et mise à jour du diagramme UML.

