public class Adherent {
    public int numero;
    public String nom;
    public String email;

    public Adherent(int numero, String nom, String email) {
        this.numero = numero;
        this.nom = nom;
        this.email = email;
    }

    public void afficher() {
        System.out.println("Adhérent " + numero + " : " + nom + " (" + email + ")");
    }
}
