
import java.util.Objects;

public class Adherent {

    private final int numero;
    private final String nom;
    private final String email;

    public Adherent(int numero, String nom, String email) {

        if (numero <= 0) {
            throw new IllegalArgumentException(
                    "Le numéro de l'adhérent doit être positif."
            );
        }

        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException(
                    "Le nom de l'adhérent ne peut pas être vide."
            );
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException(
                    "L'adresse email ne peut pas être vide."
            );
        }

        this.numero = numero;
        this.nom = nom.trim();
        this.email = email.trim();
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

    public void afficher() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Adhérent{" +
                "numéro=" + numero +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Adherent adherent)) {
            return false;
        }

        return numero == adherent.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
