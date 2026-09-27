public abstract class Document {
    private int numero;
    private String titre;
    private boolean disponible;

    public Document(int numero, String titre) {
        this.numero = numero;
        this.titre = titre;
        this.disponible = true;
    }

    public int getNumero() { return numero; }
    public String getTitre() { return titre; }
    public boolean estDisponible() { return disponible; }

    protected void changerDisponibilite(boolean disponible) {
        this.disponible = disponible;
    }

    public void afficher() {
        System.out.println("Document n°" + numero + " : " + titre);
    }

    public abstract int dureeMaxPret();
    public abstract String description();

    @Override
    public String toString() {
        return description() + " - " + (disponible ? "disponible" : "indisponible");
    }
}