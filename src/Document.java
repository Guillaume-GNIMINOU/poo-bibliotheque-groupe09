public abstract class Document {
    //Attributs
    private int numero;
    private String titre;
    private boolean disponible;
    //Constructeurs
    public Document(int numero, String titre) {
        this.numero = numero;
        this.titre = titre;
        this.disponible = true; // Disponible au début
    }
    //Accesseurs
    public int getNumero(){
        return numero
    }
    public String getTitre(){
        return titre
    }
    public boolean estDisponible(){
        return disponible;
    }
    protected void changerDisponibilite(boolean disponible){
        this.disponible=disponible
    }
    // Chaque type a sa durée maximale de prêt
    public abstract int dureeMaxPret();
    // Chaque type doit fournir sa propre description
    public abstract String description();
    @Override
    public String toString() {
        return description()+"-"+(disponible?"disponible":"indisponible");
    }
}

