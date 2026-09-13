# poo-bibliotheque-groupe Gestion de stock d'une bibliothèque 
Le groupe sont constitués de :
GNIMINOU Guillaume, 
KIENOU Franck et 
KONE Eliezer.
Problématique :
Une bibliothèque gère aujourd'hui ses prêts de façon manuelle ou dispersée, ce qui coûte du temps et crée des risques d'erreur parce qu’un document peut sembler disponible alors qu'il est déjà emprunté. Les questions centrales sont donc : Comment modéliser un programme qui permette de savoir à tout instant, rapidement et sans ambiguïté ? Quels documents sont disponibles et quels adhérents les ont empruntés ? afin de fluidifier l'interaction entre le personnel de la bibliothèque et les adhérents.
Reformulation :
Le programme doit permettre d'enregistrer les documents et les adhérents d'une bibliothèque, et de gérer en mémoire les opérations d'emprunt et de retour en mettant à jour automatiquement la disponibilité des documents. Il doit aussi pouvoir présenter clairement les informations d'un document ou d'un adhérent, sans gérer pour l'instant les dates, retards, pénalités ni historique.
Les classes proposées sont : document et adhérent. Les attributs sont respectivement numero(int), titre(String), auteur(String), disponible(boolean) et numero(int), nom(String), email(String). Les methodes de document sont emprunter(), rendre() et afficher et celle de adhérent est afficher(). Tous les attributs sont publiques et disponible(boolean) qui est initialisé à true pour présenter un document neuf ou non emprunté.
