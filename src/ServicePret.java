
import java.util.HashMap;
import java.util.Map;

public class ServicePret
{

    private final CatalogueDocuments catalogue;
    private final Map<Integer, Adherent> emprunts;

    public ServicePret(CatalogueDocuments catalogue)
    {
        if (catalogue == null)
        {
            throw new IllegalArgumentException(
                    "Le catalogue ne peut pas être nul."
            );
        }

        this.catalogue = catalogue;
        this.emprunts = new HashMap<>();
    }

    public void emprunter(Adherent adherent, int numeroDocument)
    {
        if (adherent == null)
        {
            throw new IllegalArgumentException(
                    "L'adhérent ne peut pas être nul."
            );
        }

        Document document = catalogue.rechercherParNumero(numeroDocument);

        if (document == null)
        {
            throw new DocumentIntrouvableException(
                    "Le document demandé n'existe pas."
            );
        }

        if (!(document instanceof Empruntable))
        {
            throw new DocumentNonEmpruntableException(
                    "Ce document ne peut pas être emprunté."
            );
        }

        if (emprunts.containsKey(numeroDocument)
                || !document.estDisponible())
        {
            throw new DocumentDejaEmprunteException(
                    "Ce document est déjà emprunté."
            );
        }

        Empruntable documentEmpruntable = (Empruntable) document;

        documentEmpruntable.emprunter();

        emprunts.put(numeroDocument, adherent);
    }

    public void rendre(Adherent adherent, int numeroDocument)
    {
        if (adherent == null)
        {
            throw new IllegalArgumentException(
                    "L'adhérent ne peut pas être nul."
            );
        }

        Document document = catalogue.rechercherParNumero(numeroDocument);

        if (document == null)
        {
            throw new DocumentIntrouvableException(
                    "Le document demandé n'existe pas."
            );
        }

        if (!(document instanceof Empruntable))
        {
            throw new DocumentNonEmpruntableException(
                    "Ce document ne peut pas être emprunté."
            );
        }

        Adherent emprunteur = emprunts.get(numeroDocument);

        if (emprunteur == null || !emprunteur.equals(adherent))
        {
            throw new RetourNonAutoriseException(
                    "Cet adhérent n'est pas autorisé à retourner ce document."
            );
        }

        Empruntable documentEmpruntable = (Empruntable) document;

        documentEmpruntable.rendre();

        emprunts.remove(numeroDocument);
    }

    public Adherent rechercherEmprunteur(int numeroDocument)
    {
        return emprunts.get(numeroDocument);
    }

    public int nombreEmpruntsEnCours()
    {
        return emprunts.size();
    }
}
