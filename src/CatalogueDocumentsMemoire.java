
import java.util.ArrayList;
import java.util.List;

public class CatalogueDocumentsMemoire implements CatalogueDocuments {

    private final List<Document> documents;

    public CatalogueDocumentsMemoire() {
        this.documents = new ArrayList<>();
    }

    @Override
    public boolean ajouterDocument(Document document) {

        if (document == null) {
            throw new IllegalArgumentException(
                    "Le document ne peut pas être nul."
            );
        }

        if (documents.contains(document)) {
            System.out.println(
                    "Échec : ce document existe déjà dans le catalogue."
            );
            return false;
        }

        documents.add(document);

        System.out.println(
                "Document ajouté avec succès : " + document.getTitre()
        );

        return true;
    }

    @Override
    public boolean supprimerDocument(Document document) {

        if (document == null) {
            return false;
        }

        return documents.remove(document);
    }

    @Override
    public Document rechercherParNumero(int numero) {

        for (Document document : documents) {
            if (document.getNumero() == numero) {
                return document;
            }
        }

        return null;
    }

    @Override
    public List<Document> getDocuments() {
        return List.copyOf(documents);
    }

    @Override
    public void afficherCatalogue() {

        System.out.println(
                "\nCATALOGUE DES DOCUMENTS ("
                        + documents.size() + " documents)"
        );

        if (documents.isEmpty()) {
            System.out.println("Le catalogue est vide.");
            return;
        }

        for (Document document : documents) {
            System.out.println("- " + document);
        }
    }
}
