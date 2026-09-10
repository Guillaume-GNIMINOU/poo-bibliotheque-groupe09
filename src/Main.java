public class Main {
    public static void main(String[] args) {
        // 1. Création des objets
        Document doc1 = new Document(1, "Le Petit Prince", "Saint-Exupéry");
        Document doc2 = new Document(2, "L'Étranger", "Camus");

        Adherent adh1 = new Adherent(101, "Alice", "alice@mail.com");
        Adherent adh2 = new Adherent(102, "Bob", "bob@mail.com");

        // 2. Affichage initial
        adh1.afficher();
        doc1.afficher();

        // 3. on Test Emprunt et Retour
        System.out.println("\n--- Test Emprunt ---");
        doc1.emprunter();
        doc1.afficher();

        System.out.println("\n--- Test Emprunt Impossibe ---");
        doc1.emprunter(); // Doit afficher l'erreur

        System.out.println("\n--- Test Retour ---");
        doc1.rendre();
        doc1.afficher();
    }
}