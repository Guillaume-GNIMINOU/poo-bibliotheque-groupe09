public class Main {
    public static void main(String[] args) {
        System.out.println("INITIALISONS   LE SYSTEME  DE GESTION DE LA BIBLIOTHEQUE");

        // Création d'Auteurs
        Auteur auteur1 = new Auteur("Laye", "Camara");
        Auteur auteur2 = new Auteur("Kourouma", "Ahmadou");

        // Création  adhérents
        Adherent adherent1 = new Adherent(101, "KONE Eliezer", "eliezer@email.com");
        Adherent adherent2 = new Adherent(102, "KIENOU Franck", "franck@email.com");

        System.out.println("\n VOICI LA LISTE DES ADHERENTS");
        adherent1.afficher();
        adherent2.afficher();

        // Démonstratons le polymorphisme
        Document doc1 = new Livre(1, "L'Enfant Noir", auteur1, 220);
        Document doc2 = new Periodique(2, "Jeune Afrique", 1540);
        Document doc3 = new Livre(3, "Les Soleils des Indépendances", auteur2, 200);

        System.out.println("\n L'EXECUTION DES HUIT ESSAIS CUMULES");

        // Essai 1 : Affichage d'un livre via une référence Document
        System.out.println("\nEssai 1: Affichage Document 1 (Livre)");
        doc1.afficher();

        // Essai 2 : Affichage d'un périodique via une référence Document
        System.out.println("\nEssai 2: Affichage Document 2 (Périodique)");
        doc2.afficher();

        // Essai 3 : Appel de la mésdthode dureeMaxPret() sur un Livre via Document
        System.out.println("\nEsszai 3: Durée max de prêt (Livre via Document)");
        System.out.println("Durée max : " + doc1.dureeMaxPret() + " jours");

        // Essai 4 : Appel de la méthode  dureeMaxPret() sur un Périodique via Document
        System.out.println("\nEssai 4: Durée max de prêt (Périodique via Document)");
        System.out.println("Durée max : " + doc2.dureeMaxPret() + " jours");

        // Récupérons l'instance concrète pour les tests d'emprunt
        Livre livre1 = (Livre) doc1;

        // Essai 5 : Cas ordinaire; Emprunt réussi d'un livre disponible
        System.out.println("\n ESSAI 5 : Emprunt ordinaire par " + adherent1.getNom());
        livre1.emprunter();

        // Essai 6 : Cas limite;  Refus d'emprunt car le livre est déjà indisponible
        System.out.println("\nEssai 6 : Tentative d'emprunt du même livre par" + adherent2.getNom());
        livre1.emprunter();

        // Essai 7 : Cas ordinaire ; Retour réussi d'un livre emprunté
        System.out.println("\n Essai 7: Retour ordinaire du livre");
        livre1.rendre();

        // Essai 8 : Cas limite ; Refus de retour car le livre est déjà disponible
        System.out.println("\nEssai 8: Tentative de retour d'un livre déjà disponible");
        livre1.rendre();

        System.out.println("\nFIN DE L'EXECUTION DE LA DEMONSTRATION , MERCI  \n GNIMINOU Guillaume Junior Sié Mahora\n" +
                "KIENOU Bézo Franck Darel Salomon \n , KONE Eliezer");
    }
}