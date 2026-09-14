public class Periodique extends Document {
    private int numeroParution;

    public Periodique(int numero, String titre, String auteur, int numeroParution) {
        super(numero, titre, auteur);
        this.numeroParution = numeroParution;
    }
    public int getNumeroParution() {
        return numeroParution;
    }
    @Override
    public int dureeMaxPret() {
        return 7;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nType : Périodique (N° Parution : " + numeroParution + ")" +
                "\nDurée max prêt : " + dureeMaxPret() + " jours";
    }
}