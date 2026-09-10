public class Document {
    public int numero;
    public String titre;
    public String auteur;
    public boolean disponible;

    public Document(int numero, String titre, String auteur) {
        this.numero = numero;
        this.titre = titre;
        this.auteur = auteur;
        this.disponible = true; // Disponible au début
    }

    public void emprunter() {
        if (disponible) {
            disponible = false;
            System.out.println("Emprunt réussi !");
        } else {
            System.out.println("Impossible : document déjà emprunté.");
        }
    }

    public void rendre() {
        disponible = true;
        System.out.println("Document rendu !");
    }

    public void afficher() {
        System.out.println("Document " + numero + " : " + titre + " - Disponible : " + disponible);
    }
}