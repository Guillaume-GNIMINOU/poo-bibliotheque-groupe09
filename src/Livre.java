public class Livre extends Document implements Empruntable {

    // Composition : le livre est associé à un objet de type Auteur
    private Auteur auteur;
    private int nombrePages;

    // Constructeur
    public Livre(int numero, String titre, Auteur auteur, int nombrePages) {
        super(numero, titre); // Initialisons des attributs de la classe parent (Document)
        this.auteur = auteur;
        this.nombrePages = nombrePages;
    }

    // Retourne l'objet Auteur du livre
    public Auteur getAuteur() {
        return auteur;
    }

    // Retourne le nombre de pages du livre
    public int getNombrePages() {
        return nombrePages;
    }

    // Implémentation de l'interface Empruntable : action d'emprunter
    @Override
    public void emprunter() {
        changerDisponibilite(false);
        System.out.println("Vous avez emprunté le livre : \"" + getTitre() + "\".");
    }

    // Implémentaton de l'interface Empruntable :
    @Override
    public void rendre() {
        changerDisponibilite(true);
        System.out.println("Vous avez retourné le livre : \"" + getTitre() + "\".");
    }

    // Redéfinition de la méthode abstraite : durée de prêt  (21 jours)
    @Override
    public int dureeMaxPret() {
        return 21;
    }

    // Redéfinissons la description textuelle du livre
    @Override
    public String description() {
        return "Livre:" + getTitre() + "(Auteur: " + auteur + ")";
    }

    // Redéfinissons l'affichag pour inclure les détails particulier du livre
    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Type:Livre/Pages:" + nombrePages + "Durée max prêt:" + dureeMaxPret() + "jours");
    }
}