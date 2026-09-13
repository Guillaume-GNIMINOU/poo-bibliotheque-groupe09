public abstract class Document {
    private int numero;
    private String titre;
    private String auteur;
    private boolean disponible;



    public Document(int numero, String titre, String auteur) {
        this.numero = numero;
        this.titre = titre;
        this.auteur = auteur;
        this.disponible = true;
    }

    public abstract int dureeMaxPret();

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

    public int getNumero() {
        return numero;
    }
    public String getTitre() {
        return titre;
    }
    public String getAuteur() {
        return auteur;
    }
    public boolean isDisponible() {
        return disponible;
    }
    @Override
    public String toString() {
        return "Document n°" + numero + ": \"" + titre + "\" par " + auteur +
                "\nDisponible: " + disponible;
    }
}