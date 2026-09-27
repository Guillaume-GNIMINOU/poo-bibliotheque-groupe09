// la classe Periodique représente ici une revue ou un magazine, elle herite de Document
public class Periodique extends Document
{
    // l'attribut spécifique de la classe Periodique
    private int numeroParution;

    // le constructeur de la classe Periodique
    public Periodique(int numero, String titre, int numeroParution)
    {
        // on apel le constructeur de la classe parente "Document" pour initialiser les attributs communs
        super(numero, titre);
        this.numeroParution = numeroParution; // j'initiale l'attribut propre de périodique
    }
    //on prendre en valeur le numéro de parution de périodique
    public int getNumeroParution()
    {
        return numeroParution;
    }
    //Redéfinissons la méthode abstraite de Document: cela nous renvoie la durée max de prêt soit 7 jours
    @Override
    public int dureeMaxPret() {
        return 7; // Spécifique de Périodique 7jours
    }
    //description propre de Périodique
    @Override
    public String description() {
        return "Périodique : " + getTitre() + " (N° " + numeroParution + ")";
    }
    //Redéfinissons la méthode afficher pour inclure les informations spécifiques de Périodique
    @Override
    public void afficher()
    {
        // jappel la méthode afficher() de la classe parente "Document"
        super.afficher();
        // Affichage des détails propres au périodique
        System.out.println("Type: Périodique/N de Parution:" + numeroParution + "Durée max prêt:" + dureeMaxPret() + "jours");
    }
}