
import java.util.List;

public class Livre extends Document implements Empruntable {

    private final List<Auteur> auteurs;
    private final int nombrePages;

    // Constructeur compatible avec l'ancienne version : un seul objet Auteur
    public Livre(int numero, String titre, Auteur auteur, int nombrePages) {
        this(numero, titre, List.of(auteur), nombrePages);
    }

    // Constructeur compatible avec la version utilisant une chaine de caracteres
    public Livre(int numero, String titre, String auteur, int nombrePages) {
        this(numero, titre, List.of(new Auteur(auteur)), nombrePages);
    }

    // Constructeur permettant d'associer plusieurs auteurs
    public Livre(int numero, String titre, List<Auteur> auteurs, int nombrePages) {
        super(numero, titre);

        if (nombrePages <= 0) {
            throw new IllegalArgumentException(
                    "Le nombre de pages doit etre positif."
            );
        }

        if (auteurs == null || auteurs.isEmpty()) {
            throw new IllegalArgumentException(
                    "Un livre doit avoir au moins un auteur."
            );
        }

        if (auteurs.stream().anyMatch(auteur -> auteur == null)) {
            throw new IllegalArgumentException(
                    "La liste des auteurs ne peut pas contenir de valeur nulle."
            );
        }

        this.auteurs = List.copyOf(auteurs);
        this.nombrePages = nombrePages;
    }

    //Retourne la liste non modifiable des auteurs
    public List<Auteur> getAuteurs() {
        return auteurs;
    }

    //Compatibilite avec l'ancienne methode getAuteur()
    public Auteur getAuteur() {
        return auteurs.get(0);
    }

    public int getNombrePages() {
        return nombrePages;
    }


    @Override
    public void emprunter()
    {
        if (!estDisponible())
        {
            throw new DocumentDejaEmprunteException(
                    "Ce livre est déjà emprunté."
            );
        }

        changerDisponibilite(false);
    }

    @Override
    public void rendre()
    {
        if (estDisponible())
        {
            throw new RetourNonAutoriseException(
                    "Ce livre est déjà disponible."
            );
        }

        changerDisponibilite(true);
    }


    @Override
    public int dureePret() {
        return 21;
    }

    @Override
    public String description() {
        String nomsAuteurs = String.join(
                ", ",
                auteurs.stream()
                        .map(Auteur::getNomComplet)
                        .toList()
        );

        return "Livre : " + getTitre()
                + " (Auteurs : " + nomsAuteurs
                + ", Pages : " + nombrePages + ")";
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println(
                "Type : Livre | Pages : " + nombrePages
                        + " | Duree maximale de pret : " + dureePret() + " jours"
        );
    }
}
