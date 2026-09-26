public class Livre extends Document //la classe Livre représente un document de type livre, et qui herite de Document
{
    private int nombrePages;//l'attribut Livre
    public Livre(int numero, String titre, String auteur, int nombrePages)//le constructeur de Livre
    {
        super(numero, titre, auteur);//j'appel le constructeur de "Document" pour initialiser les attributs communs
        this.nombrePages = nombrePages;//Initialisation de l'attribut qui est propre au livre
    }


    public int getNombrePages()//on prendre en valeur le nombre de pages du livre
    {
        return nombrePages;
    }
    @Override//on redefini la méthode abstraite de Document: et on renvoie la durée max du prêt (21 jours)
    public int dureeMaxPret()
    {
        return 21; //c'est spécifique au Livre (21 jours)
    }
    @Override//on redefini la méthode afficher pour inclure les informations spécifiques du Livre
    public void afficher()
    {
        super.afficher(); //jappel de la méthode "afficher" de la classe "Document" (parent)
        System.out.println("Type: Livre/Pages:" + nombrePages + "Durée max prêt:" + dureeMaxPret() + "jours");//affichons les détails propres du livre
    }
}