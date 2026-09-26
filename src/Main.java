import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. CRÉATION ET AFFICHAGE DES ADHÉRENTS ===");
        Adherent adh1 = new Adherent(101, "Alice", "alice@mail.com");
        Adherent adh2 = new Adherent(102, "Bob", "bob@mail.com");

        adh1.afficher();
        adh2.afficher();
        System.out.println(adh1);
        System.out.println(adh2);

        System.out.println("\n=== 2. CRÉATION ET MANIPULATION DU CATALOGUE (POLYMORPHISME) ===");
        Document doc1 = new Livre(1, "Le Petit Prince", "Antoine de Saint-Exupéry", 96);
        Document doc2 = new Periodique(2, "Science & Vie", "Collectif", 1050);

        System.out.println("\nEssai Livre :");
        doc1.afficher();
        System.out.println(doc1);

        System.out.println("\nEssai Périodique :");
        doc2.afficher();
        System.out.println(doc2);

        System.out.println("\n--- Parcours Polymorphe du Catalogue ---");
        List<Document> catalogue = new ArrayList<>();
        catalogue.add(doc1);
        catalogue.add(doc2);

        for (Document doc : catalogue) {
            System.out.println("Titre : " + doc.getTitre());
            System.out.println("Durée max prêt : " + doc.dureeMaxPret() + " jours");
        }

        System.out.println("\n=== 3. VÉRIFICATION DES RÈGLES D'EMPRUNT / RETOUR ===");
        System.out.println("Emprunt initial :");
        doc1.emprunter();
        doc1.afficher();

        System.out.println("\nTentative de ré-emprunt (Doit afficher une erreur) :");
        doc1.emprunter();

        System.out.println("\nRetour du document :");
        doc1.rendre();
        doc1.afficher();
    }
}