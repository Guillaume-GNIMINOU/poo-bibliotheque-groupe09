public class Main {
    public static void main(String[] args) {
        System.out.println("INITIALISONS   LE SYSTEME  DE GESTION DE LA BIBLIOTHEQUE");

        // 1. Création des adhérents
        Adherent adherent1 = new Adherent(101, "KONE Eliezer", "eliezer@email.com");
        Adherent adherent2 = new Adherent(102, "KIENOU Franck", "franck@email.com");

        System.out.println("\n VOICI LA LISTE DES ADHERENTS");
        adherent1.afficher();
        adherent2.afficher();

        // 2. Démonstration du POLYMORPHISME (Catalogue sans boucle)
        Document doc1 = new Livre(1, "L'Enfant Noir", "Camara Laye", 220);
        Document doc2 = new Periodique(2, "Jeune Afrique", 1540);
        Document doc3 = new Livre(3, "Les Soleils des Indépendances", "Ahmadou Kourouma", 200);

        System.out.println("\n L'AFFICHAGE DES DOCUMENTS ");
        doc1.afficher();
        System.out.println("Statut: " + (doc1.estDisponible() ? "Disponible" : "Indisponible"));

        doc2.afficher();
        System.out.println("Statut: " + (doc2.estDisponible() ? "Disponible" : "Indisponible"));

        doc3.afficher();
        System.out.println("Statut: " + (doc3.estDisponible() ? "Disponible" : "Indisponible"));

        System.out.println("\n L'EXECUTION DES SCENARIOS DE TEST (Emprunt / Refus / Retour)");

        // Récupération de l'objet Livre
        Livre livre1 = (Livre) doc1;

        // SCÉNARIO 1 : Cas ordinaire (Emprunt réussi)
        System.out.println("\nTest 1: Emprunt ordinaire par " + adherent1.getNom() );
        livre1.emprunter();

        // SCÉNARIO 2 : Cas limite (Refus d'emprunt - Livre déjà indisponible)
        System.out.println("\nTest 2: Tentative d'emprunt du même livre par " + adherent2.getNom() );
        livre1.emprunter();

        // SCÉNARIO 3 : Cas ordinaire (Retour réussi)
        System.out.println("\nTest 3 : Retour ordinaire du livre");
        livre1.rendre();

        // SCÉNARIO 4 : Cas limite (Refus de retour - Livre déjà disponible)
        System.out.println("\nTest 4: Tentative de retour d'un livre déjà disponible");
        livre1.rendre();

        System.out.println("\nFIN DE L'EXECUTION DE LA DEMONSTRATION , MERCI  \n GNIMINOU Guillaume Junior Sié Mahora\n" +
                "KIENOU Bézo Franck Darel Salomon \n , KONE Eliezer");
    }
}