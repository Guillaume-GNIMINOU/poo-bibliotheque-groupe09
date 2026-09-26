public class Periodique extends Document//la classe Periodique qui représente une revue ou un magazine,qui herite de Document
{
    private int numeroParution; //l'attribut spécifique de la classe Periodique
    public Periodique(int numero, String titre, String auteur, int numeroParution)//le constructeur de la classe Periodique
    {
        super(numero, titre, auteur);//on apel le constructeur de la classe parente "Document" pour initialiser les attributs communs
        this.numeroParution = numeroParution;//j'initiale l'attribut propre de périodique
    }
    public int getNumeroParution()//on prendre en valeur le numéro de parution de périodique
    {
        return numeroParution;
    }
    @Override//Redéfinissons la méthode abstraite de Document: cela nous renvoie la durée max de prêt soit 7 jours
    public int dureeMaxPret()
    {
        return 7; //Spécifique de Périodique 7jours
    }
    @Override //Redéfinissons la méthode afficher pour inclure les informations spécifiques de Périodique
    public void afficher()
    {
        super.afficher();//jappel la méthode afficher() de la classe parente "Document"
        // Affichage des détails propres au périodique
        System.out.println("Type: Périodique/N de Parution:" + numeroParution + "Durée max prêt:" + dureeMaxPret() + "jours");
    }
}