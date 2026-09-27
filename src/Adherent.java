public class Adherent {
    //Attributs
    private int numero;
    private String nom;
    private String email;
    //Constructeurs
    public Adherent(int numero, String nom, String email) {
        this.numero = numero;
        this.nom = nom;
        this.email = email;
    }
    //Affichage
    public void afficher() {
        System.out.println("Adhérent " + numero + " : " + nom + " (" + email + ")");
    }
    //Accesseurs
    public int getNumero() {
        return numero;
    }
    public String getNom() {
        return nom;
    }
    public String getEmail() {
        return email;
    }
    // La description
    @Override
    public String toString() {
        return "Adhérent n°" + numero + "Nom : " + nom + "Email : " + email;
    }
}