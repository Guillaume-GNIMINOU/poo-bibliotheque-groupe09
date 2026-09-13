public class Adherent {
    private int numero;
    private String nom;
    private String email;

    public Adherent(int numero, String nom, String email) {
        this.numero = numero;
        this.nom = nom;
        this.email = email;
    }


    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }



    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Adhérent n°" + numero +
                "\nNom : " + nom +
                "\nEmail : " + email;
    }
}