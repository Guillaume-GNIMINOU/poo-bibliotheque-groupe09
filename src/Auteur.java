
public class Auteur {

    private final String nomComplet;
    private final String nom;
    private final String prenom;

    // Constructeur pour un auteur dont on connaît le nom complet
    public Auteur(String nomComplet) {
        if (nomComplet == null || nomComplet.isBlank()) {
            throw new IllegalArgumentException(
                    "Le nom de l'auteur ne peut pas etre vide."
            );
        }

        this.nomComplet = nomComplet.trim();
        this.nom = null;
        this.prenom = null;
    }

    // Constructeur compatible avec la version precedente
    public Auteur(String nom, String prenom) {
        if (nom == null || nom.isBlank()
                || prenom == null || prenom.isBlank()) {
            throw new IllegalArgumentException(
                    "Le nom et le prenom sont obligatoires."
            );
        }

        this.nom = nom.trim();
        this.prenom = prenom.trim();
        this.nomComplet = this.prenom + " " + this.nom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    @Override
    public String toString() {
        return nomComplet;
    }
}
