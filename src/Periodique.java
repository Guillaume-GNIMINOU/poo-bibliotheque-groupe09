
public class Periodique extends Document {

    private final int numeroParution;

    public Periodique(int numero, String titre, int numeroParution) {
        super(numero, titre);

        if (numeroParution <= 0) {
            throw new IllegalArgumentException(
                    "Le numéro de parution doit être positif."
            );
        }

        this.numeroParution = numeroParution;
    }

    public int getNumeroParution() {
        return numeroParution;
    }

    @Override
    public int dureePret() {
        return 7;
    }

    @Override
    public String description() {
        return "Périodique : " + getTitre()
                + " (N° " + numeroParution + ")";
    }
}
