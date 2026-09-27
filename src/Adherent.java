public class Adherent {
    //Attributs
    public int numero;
    public String nom;
    public String email;
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
    //Description
    @Override
    public String toString() {
        return "Adhérent n°" + numero + "Nom : " + nom + "Email : " + email;
    }
}