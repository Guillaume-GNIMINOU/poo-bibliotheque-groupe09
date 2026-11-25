
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {

        System.out.println("INITIALISONS LE SYSTEME DE GESTION DE LA BIBLIOTHEQUE");

        // Création des auteurs
        Auteur auteur1 = new Auteur("Laye", "Camara");
        Auteur auteur2 = new Auteur("Kourouma", "Ahmadou");

        // Création des adhérents
        Adherent adherent1 = new Adherent(101, "KONE Eliezer", "eliezer@email.com");
        Adherent adherent2 = new Adherent(102, "KIENOU Franck", "franck@email.com");

        System.out.println("\nVOICI LA LISTE DES ADHERENTS");
        adherent1.afficher();
        adherent2.afficher();

        // Démonstration du polymorphisme
        Document doc1 = new Livre(1, "L'Enfant Noir", auteur1, 220);
        Document doc2 = new Periodique(2, "Jeune Afrique", 1540);
        Document doc3 = new Livre(3, "Les Soleils des Indépendances", auteur2, 200);

        System.out.println("\nVERIFICATION DU POLYMORPHISME");

        System.out.println("Durée de prêt du livre : "
                + doc1.dureePret() + " jours");

        System.out.println("Durée de prêt du périodique : "
                + doc2.dureePret() + " jours");

        System.out.println("\nL'EXECUTION DES TREIZE ESSAIS CUMULES");

        // Essai 1 : Affichage d'un livre via une référence Document
        System.out.println("\nEssai 1 : Affichage Document 1 (Livre)");
        doc1.afficher();

        // Essai 2 : Affichage d'un périodique via une référence Document
        System.out.println("\nEssai 2 : Affichage Document 2 (Périodique)");
        doc2.afficher();

        // Essai 3 : Appel de dureePret() sur un Livre via Document
        System.out.println("\nEssai 3 : Durée maximale de prêt (Livre via Document)");
        System.out.println("Durée maximale : " + doc1.dureePret() + " jours");

        // Essai 4 : Appel de dureePret() sur un Périodique via Document
        System.out.println("\nEssai 4 : Durée maximale de prêt (Périodique via Document)");
        System.out.println("Durée maximale : " + doc2.dureePret() + " jours");

        // Démonstration du catalogue de documents
        System.out.println("\nUTILISATION DU CATALOGUE DE DOCUMENTS (Jalon 3)");

        CatalogueDocuments catalogue = new CatalogueDocumentsMemoire();

        // Essai 5 : Ajout des trois documents au catalogue
        System.out.println("\nEssai 5 : Ajout des documents au catalogue");
        catalogue.ajouterDocument(doc1);
        catalogue.ajouterDocument(doc2);
        catalogue.ajouterDocument(doc3);

        // Essai 6 : Test d'ajout d'un doublon
        System.out.println("\nEssai 6 : Tentative d'ajout d'un document avec un numéro existant (N°1)");

        Document docDoublon = new Livre(1, "Autre titre", "Autre auteur", 150);
        catalogue.ajouterDocument(docDoublon);

        System.out.println("\nVERIFICATION DE LA RECHERCHE");

        // Essai 7 : Recherche d'un document existant
        System.out.println("\nEssai 7 : Recherche d'un document existant");

        Document resultat = catalogue.rechercherParNumero(2);

        if (resultat != null)
        {
            System.out.println("Document trouvé : " + resultat);
        }
        else
        {
            System.out.println("Document introuvable.");
        }

        // Essai 8 : Recherche d'un document inexistant
        System.out.println("\nEssai 8 : Recherche d'un document inexistant");

        Document resultatAbsent = catalogue.rechercherParNumero(99);

        if (resultatAbsent != null)
        {
            System.out.println("Document trouvé : " + resultatAbsent);
        }
        else
        {
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

        try
        {
            copieDocuments.add(docDoublon);
            System.out.println("ERREUR : la collection a été modifiée.");
        }
        catch (UnsupportedOperationException e)
        {
            System.out.println(
                    "Protection réussie : impossible de modifier la collection retournée."
            );
        }

        System.out.println("Nombre de documents dans le catalogue : "
                + catalogue.getDocuments().size());

        // Création du service de prêt
        ServicePret servicePret = new ServicePret(catalogue);

        // Récupération des instances concrètes
        Livre livre1 = (Livre) doc1;
        Livre livre3 = (Livre) doc3;

        // Essai 11 : Emprunt réussi par l'adhérent 1
        System.out.println("\nESSAI 11 : Emprunt ordinaire par " + adherent1.getNom());

        try
        {
            servicePret.emprunter(adherent1, 1);

            System.out.println("Emprunt enregistré avec succès.");

            System.out.println("Emprunteur enregistré : "
                    + servicePret.rechercherEmprunteur(1).getNom());
        }
        catch (BibliothequeException e)
        {
            System.out.println("Erreur : " + e.getMessage());
        }

        // Essai 12 : Refus d'un deuxième emprunt du même livre
        System.out.println("\nESSAI 12 : Tentative d'emprunt du même livre par "
                + adherent2.getNom());

        try
        {
            servicePret.emprunter(adherent2, 1);
        }
        catch (BibliothequeException e)
        {
            System.out.println("Emprunt refusé : " + e.getMessage());
        }

        // Retour ordinaire du livre par son véritable emprunteur
        System.out.println("\nRetour ordinaire du livre par " + adherent1.getNom());

        try
        {
            servicePret.rendre(adherent1, 1);
            System.out.println("Retour effectué avec succès.");
        }
        catch (BibliothequeException e)
        {
            System.out.println("Erreur : " + e.getMessage());
        }

        // Essai 13 : Refus de retour car le livre est déjà disponible
        System.out.println("\nESSAI 13 : Tentative de retour d'un livre déjà disponible");

        try
        {
            servicePret.rendre(adherent1, 1);
        }
        catch (BibliothequeException e)
        {
            System.out.println("Retour refusé : " + e.getMessage());
        }

        // Vérification de l'état des emprunts
        System.out.println("\nVERIFICATION DU SERVICE DE PRET");

        System.out.println("Nombre d'emprunts en cours : "
                + servicePret.nombreEmpruntsEnCours());

        // Emprunt d'un second livre par l'adhérent 2
        System.out.println("\nEmprunt du livre 'Les Soleils des Indépendances' par "
                + adherent2.getNom());

        try
        {
            servicePret.emprunter(adherent2, 3);

            System.out.println("Emprunteur enregistré : "
                    + servicePret.rechercherEmprunteur(3).getNom());
        }
        catch (BibliothequeException e)
        {
            System.out.println("Erreur : " + e.getMessage());
        }

        // Suppression du périodique doc2
        System.out.println("\nSuppression du périodique 'Jeune Afrique' du catalogue :");

        boolean supprime = catalogue.supprimerDocument(doc2);

        System.out.println("Statut de la suppression : "
                + (supprime ? "Réussi" : "Échoué"));

        // Affichage final du catalogue mis à jour
        catalogue.afficherCatalogue();

        System.out.println("\nFIN DE L'EXECUTION DE LA DEMONSTRATION, MERCI");

        System.out.println("GNIMINOU Guillaume Junior Sié Mahora");
        System.out.println("KIENOU Bèzo Franck Darel Salomon");
        System.out.println("KONE Larait Eliezer");

    }
}
