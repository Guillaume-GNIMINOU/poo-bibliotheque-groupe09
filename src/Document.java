<<<<<<< HEAD
public class Document {
    public int numero;
    public String titre;
    public String auteur;
    public boolean disponible;
=======
public abstract class Document {
    private int numero;
    private String titre;
    private String auteur;
    private boolean disponible;


>>>>>>> master

    public Document(int numero, String titre, String auteur) {
        this.numero = numero;
        this.titre = titre;
        this.auteur = auteur;
<<<<<<< HEAD
        this.disponible = true; // Disponible au début
    }

=======
        this.disponible = true;
    }

    public abstract int dureeMaxPret();

>>>>>>> master
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

<<<<<<< HEAD
    public void afficher() {
        System.out.println("Document " + numero + " : " + titre + " - Disponible : " + disponible);
=======
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
>>>>>>> master
    }
}