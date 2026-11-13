
import java.util.List;

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

        System.out.println("\nVERIFICATION DU POLYMORPHISME");

        System.out.println("Durée de prêt du livre : "
                + doc1.dureePret() + " jours");

        System.out.println("Durée de prêt du périodique : "
                + doc2.dureePret() + " jours");

        System.out.println("\n L'EXECUTION DES TREIZE ESSAIS CUMULES");

        // Essai 1 : Affichage d'un livre via une référence Document
        System.out.println("\nEssai 1: Affichage Document 1 (Livre)");
        doc1.afficher();

        // Essai 2 : Affichage d'un périodique via une référence Document
        System.out.println("\nEssai 2: Affichage Document 2 (Périodique)");
        doc2.afficher();

        // Essai 3 : Appel de la méthode dureePret() sur un Livre via Document
        System.out.println("\nEssai 3: Durée max de prêt (Livre via Document)");
        System.out.println("Durée max : " + doc1.dureePret() + " jours");

        // Essai 4 : Appel de la méthode dureePret() sur un Périodique via Document
        System.out.println("\nEssai 4: Durée max de prêt (Périodique via Document)");
        System.out.println("Durée max : " + doc2.dureePret() + " jours");

        // 3. Démonstration du CATALOGUE DE DOCUMENTS (Jalon 3)
        System.out.println("\n L'UTILISATION DU CATALOGUE DE DOCUMENTS (Jalon 3)");

        CatalogueDocuments catalogue = new CatalogueDocumentsMemoire();

        // Essai 5 : Ajout des trois documents au catalogue
        System.out.println("\nEssai 5 : Ajout des documents au catalogue");
        catalogue.ajouterDocument(doc1);
        catalogue.ajouterDocument(doc2);
        catalogue.ajouterDocument(doc3);

        // Essai 6 : Test d'ajout d'un doublon (doit être refusé grâce à equals)
        System.out.println("\nEssai 6 : Tentative d'ajout d'un document avec un numéro existant (N°1)");
        Document docDoublon = new Livre(1, "Autre titre", "Autre auteur", 150);
        catalogue.ajouterDocument(docDoublon);

        System.out.println("\nVERIFICATION DE LA RECHERCHE");

        // Essai 7 : Recherche d'un document existant
        System.out.println("\nEssai 7 : Recherche d'un document existant");
        Document resultat = catalogue.rechercherParNumero(2);

        if (resultat != null) {
            System.out.println("Document trouvé : " + resultat);
        } else {
            System.out.println("Document introuvable.");
        }

        // Essai 8 : Recherche d'un document inexistant
        System.out.println("\nEssai 8 : Recherche d'un document inexistant");
        Document resultatAbsent = catalogue.rechercherParNumero(99);

        if (resultatAbsent != null) {
            System.out.println("Document trouvé : " + resultatAbsent);
        } else {
            System.out.println("Aucun document avec le numéro 99.");
        }

        // Essai 9 : Affichage global du catalogue
        System.out.println("\nEssai 9 : Affichage global du catalogue");
        catalogue.afficherCatalogue();

        // Essai 10 : Vérification de l'encapsulation du catalogue
        System.out.println("\nESSAI 10 : VERIFICATION DE L'ENCAPSULATION");

        List<Document> copieDocuments = catalogue.getDocuments();

        System.out.println("Nombre de documents dans la copie : "
                + copieDocuments.size());

        try {
            copieDocuments.add(docDoublon);
            System.out.println("ERREUR : la collection a été modifiée.");
        } catch (UnsupportedOperationException e) {
            System.out.println(
                    "Protection réussie : impossible de modifier la collection retournée."
            );
        }

        System.out.println("Nombre de documents dans le catalogue : "
                + catalogue.getDocuments().size());

        // Récupérons l'instance concrète pour les tests d'emprunt
        Livre livre1 = (Livre) doc1;

        // Essai 11 : Cas ordinaire ; Emprunt réussi d'un livre disponible
        System.out.println("\n ESSAI 11 : Emprunt ordinaire par " + adherent1.getNom());
        livre1.emprunter();

        // Essai 12 : Cas limite ; Refus d'emprunt car le livre est déjà indisponible
        System.out.println("\nEssai 12 : Tentative d'emprunt du même livre par " + adherent2.getNom());
        livre1.emprunter();

        // Retour ordinaire du livre emprunté
        System.out.println("\nRetour ordinaire du livre");
        livre1.rendre();

        // Essai 13 : Cas limite ; Refus de retour car le livre est déjà disponible
        System.out.println("\nEssai 13 : Tentative de retour d'un livre déjà disponible");
        livre1.rendre();

        // Récupération de l'objet Livre 3
        Livre livre3 = (Livre) doc3;

        // Emprunt d'un second livre (doc3) par l'adhérent 2
        System.out.println("\nEmprunt du livre 'Les Soleils des Indépendances' par " + adherent2.getNom() + " :");
        livre3.emprunter();

        // Suppression d'un document du catalogue (le périodique doc2)
        System.out.println("\nSuppression du périodique 'Jeune Afrique' du catalogue :");
        boolean supprime = catalogue.supprimerDocument(doc2);
        System.out.println("Statut de la suppression : " + (supprime ? "Réussi" : "Échoué"));

        // Affichage final du catalogue mis à jour
        catalogue.afficherCatalogue();

        System.out.println("\nFIN DE L'EXECUTION DE LA DEMONSTRATION , MERCI  \n GNIMINOU Guillaume Junior Sié Mahora\n"
                + "KIENOU Bèzo Franck Darel Salomon \n , KONE Larait Eliezer");
    }
}
