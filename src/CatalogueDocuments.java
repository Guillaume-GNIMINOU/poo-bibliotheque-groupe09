
import java.util.List;

public interface CatalogueDocuments {

    boolean ajouterDocument(Document document);

    boolean supprimerDocument(Document document);

    Document rechercherParNumero(int numero);

    List<Document> getDocuments();

    void afficherCatalogue();
}
