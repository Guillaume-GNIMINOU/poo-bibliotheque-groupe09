public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. CRÉATION DES ADHÉRENTS ET DES DOCUMENTS ===");
        Adherent adh1 = new Adherent(101, "Alice", "alice@mail.com");
        Adherent adh2 = new Adherent(102, "Bob", "bob@mail.com");

        System.out.println(adh1);
        System.out.println(adh2);

        // Instanciation via le type parent/abstrait Document
        Document doc1 = new Livre(1, "Le Petit Prince", "Antoine de Saint-Exupéry", 96);
        Document doc2 = new Periodique(2, "Science & Vie", "Collectif", 1050);

        System.out.println("\n--- Affichage des documents ---");
        System.out.println(doc1);
        System.out.println(doc2);

        System.out.println("\n=== 2. PARCOURS POLYMORPHE DU CATALOGUE ===");
        // Noms pleinement qualifiés (java.util.List et java.util.ArrayList)
        java.util.List<Document> catalogue = new java.util.ArrayList<>();
        catalogue.add(doc1);
        catalogue.add(doc2);

        for (Document doc : catalogue) {
            System.out.println("Titre : " + doc.getTitre());
            System.out.println("Durée max prêt : " + doc.dureeMaxPret() + " jours");
        }

        System.out.println("\n=== 3. TESTS EMPRUNT, REFUS ET RETOUR ===");

        // Test 1 : Emprunt initial (Succès)
        System.out.println("\n--- Test Emprunt ---");
        doc1.emprunter();
        System.out.println(doc1);

        // Test 2 : Tentative de ré-emprunt (Refus / Impossibilité)
        System.out.println("\n--- Test Emprunt Impossible (Refus) ---");
        doc1.emprunter(); // Doit afficher un message d'erreur/refus
        System.out.println(doc1);

        // Test 3 : Retour du document (Succès)
        System.out.println("\n--- Test Retour ---");
        doc1.rendre();
        System.out.println(doc1);
    }
}