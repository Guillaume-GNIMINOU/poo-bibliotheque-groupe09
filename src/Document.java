
import java.util.Objects;

public abstract class Document {

    private final int numero;
    private final String titre;
    private boolean disponible;

    public Document(int numero, String titre) {

        if (numero <= 0) {
            throw new IllegalArgumentException(
                    "Le numéro du document doit être positif."
            );
        }

        if (titre == null || titre.isBlank()) {
            throw new IllegalArgumentException(
                    "Le titre du document ne peut pas être vide."
            );
        }

        this.numero = numero;
        this.titre = titre.trim();
        this.disponible = true;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitre() {
        return titre;
    }

    public boolean estDisponible() {
        return disponible;
    }

    protected void changerDisponibilite(boolean disponible) {
        this.disponible = disponible;
    }

    public void afficher() {
        System.out.println(this);
    }

    public abstract int dureePret();

    public abstract String description();

    @Override
    public String toString() {
        return description() + " - "
                + (disponible ? "Disponible" : "Indisponible");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Document document)) {
            return false;
        }

        return numero == document.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
