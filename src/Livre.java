public class Livre extends Document implements Empruntable //la classe Livre représente un document de type livre, et qui herite de Document
 {
    private String auteur;
    private int nombrePages; // l'attribut de Livre

    //je declare le constructeur de Livre
    public Livre(int numero, String titre, String auteur, int nombrePages)
    {
        super(numero, titre); //jappel le constructeur de "Document" pour initialiser les attributs communs
        this.auteur = auteur;
        this.nombrePages = nombrePages; //on initialise l'attribut qui est propre au livre
    }

    public String getAuteur()
    {
        return auteur;
    }
     //on prendre en valeur le nombre de pages du livre
    public int getNombrePages()
    {
        return nombrePages;
    }

    @Override
    public void emprunter()
    {
        changerDisponibilite(false);
        System.out.println("Vous avez emprunté le livre : \"" + getTitre() + "\".");
    }

    @Override
    public void rendre()
    {
        changerDisponibilite(true);
        System.out.println("Vous avez retourné le livre : \"" + getTitre() + "\".");
    }
     //on redefini la méthode abstraite de Document: et on renvoie la durée max du prêt (21 jours)
    @Override
    public int dureeMaxPret()
    {
        return 21; //c'est spécifique au Livre pour 21 jours
    }

    @Override //la description propre a Livre
    public String description()
    {
        return "Livre:" + getTitre() + "(Auteur: " + auteur +")";
    }
     //on redefini la méthode afficher pour inclure les informations spécifiques du Livre
    @Override
    public void afficher()
    {
        //jappel de la méthode "afficher" de la classe "Document" (parent)
        super.afficher();
        //affichons les détails propres du livre
        System.out.println("Type:Livre/Pages:" + nombrePages + "Durée max prêt:" + dureeMaxPret() + "jours");
    }
}