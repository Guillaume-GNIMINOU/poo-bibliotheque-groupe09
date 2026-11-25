
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServicePretTest
{

    private CatalogueDocumentsMemoire catalogue;
    private ServicePret servicePret;
    private Adherent adherent1;
    private Adherent adherent2;
    private Livre livre;

    @BeforeEach
    public void initialiser()
    {
        catalogue = new CatalogueDocumentsMemoire();
        servicePret = new ServicePret(catalogue);

        adherent1 = new Adherent(
                101, "KONE Eliezer", "eliezer@gmail.com"
        );

        adherent2 = new Adherent(
                102, "KIENOU Franck", "franck@gmail.com"
        );

        livre = new Livre(
                1, "Une si longue lettre", "Mariama Bâ", 180
        );

        catalogue.ajouterDocument(livre);
    }

    @Test
    public void testEmpruntReussi()
    {
        servicePret.emprunter(adherent1, 1);

        assertFalse(livre.estDisponible());
        assertEquals(adherent1, servicePret.rechercherEmprunteur(1));
        assertEquals(1, servicePret.nombreEmpruntsEnCours());
    }

    @Test
    public void testEmpruntDocumentIntrouvable()
    {
        assertThrows(
                DocumentIntrouvableException.class,
                () -> servicePret.emprunter(adherent1, 999)
        );

        assertTrue(livre.estDisponible());
        assertEquals(0, servicePret.nombreEmpruntsEnCours());
    }

    @Test
    public void testEmpruntDocumentDejaEmprunte()
    {
        servicePret.emprunter(adherent1, 1);

        assertThrows(
                DocumentDejaEmprunteException.class,
                () -> servicePret.emprunter(adherent2, 1)
        );

        assertFalse(livre.estDisponible());
        assertEquals(adherent1, servicePret.rechercherEmprunteur(1));
        assertEquals(1, servicePret.nombreEmpruntsEnCours());
    }

    @Test
    public void testEmpruntDocumentNonEmpruntable()
    {
        Periodique periodique = new Periodique(
                2, "Revue scientifique", 5
        );

        catalogue.ajouterDocument(periodique);

        assertThrows(
                DocumentNonEmpruntableException.class,
                () -> servicePret.emprunter(adherent1, 2)
        );

        assertTrue(periodique.estDisponible());
        assertEquals(0, servicePret.nombreEmpruntsEnCours());
    }

    @Test
    public void testEmpruntAvecAdherentNul()
    {
        assertThrows(
                IllegalArgumentException.class,
                () -> servicePret.emprunter(null, 1)
        );

        assertTrue(livre.estDisponible());
        assertEquals(0, servicePret.nombreEmpruntsEnCours());
    }

    @Test
    public void testRetourReussi()
    {
        servicePret.emprunter(adherent1, 1);

        servicePret.rendre(adherent1, 1);

        assertTrue(livre.estDisponible());
        assertNull(servicePret.rechercherEmprunteur(1));
        assertEquals(0, servicePret.nombreEmpruntsEnCours());
    }

    @Test
    public void testRetourParUnAutreAdherent()
    {
        servicePret.emprunter(adherent1, 1);

        assertThrows(
                RetourNonAutoriseException.class,
                () -> servicePret.rendre(adherent2, 1)
        );

        assertFalse(livre.estDisponible());
        assertEquals(adherent1, servicePret.rechercherEmprunteur(1));
        assertEquals(1, servicePret.nombreEmpruntsEnCours());
    }

    @Test
    public void testRetourSansEmprunt()
    {
        assertThrows(
                RetourNonAutoriseException.class,
                () -> servicePret.rendre(adherent1, 1)
        );

        assertTrue(livre.estDisponible());
        assertNull(servicePret.rechercherEmprunteur(1));
        assertEquals(0, servicePret.nombreEmpruntsEnCours());
    }

    @Test
    public void testRetourAvecAdherentNul()
    {
        servicePret.emprunter(adherent1, 1);

        assertThrows(
                IllegalArgumentException.class,
                () -> servicePret.rendre(null, 1)
        );

        assertFalse(livre.estDisponible());
        assertEquals(adherent1, servicePret.rechercherEmprunteur(1));
        assertEquals(1, servicePret.nombreEmpruntsEnCours());
    }

    @Test
    public void testLivreAvecNombrePagesInvalide()
    {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Livre(10, "Livre invalide", "Auteur", 0)
        );
    }

    @Test
    public void testLivreSansAuteur()
    {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Livre(10, "Livre invalide", (String) null, 100)
        );
    }

    @Test
    public void testPeriodeAvecNumeroParutionInvalide()
    {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Periodique(10, "Revue", 0)
        );
    }

    @Test
    public void testAdherentAvecNomVide()
    {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Adherent(103, " ", "test@gmail.com")
        );
    }

    @Test
    public void testRefusDocumentEnDouble()
    {
        Livre autreLivre = new Livre(
                1, "Autre titre", "Autre auteur", 200
        );

        int nombreAvant = catalogue.getDocuments().size();

        assertFalse(catalogue.ajouterDocument(autreLivre));

        assertEquals(nombreAvant, catalogue.getDocuments().size());
        assertSame(livre, catalogue.rechercherParNumero(1));
    }

    @Test
    public void testRetourDocumentIntrouvable()
    {
        assertThrows(
                DocumentIntrouvableException.class,
                () -> servicePret.rendre(adherent1, 999)
        );

        assertTrue(livre.estDisponible());
        assertEquals(0, servicePret.nombreEmpruntsEnCours());
    }

    @Test
    public void testListeCatalogueNonModifiable()
    {
        assertThrows(
                UnsupportedOperationException.class,
                () -> catalogue.getDocuments().clear()
        );

        assertEquals(1, catalogue.getDocuments().size());
    }
    @Test
    public void testRetourDocumentNonEmpruntable()
    {
        Periodique periodique = new Periodique(
                2, "Revue scientifique", 5
        );

        catalogue.ajouterDocument(periodique);

        assertThrows(
                DocumentNonEmpruntableException.class,
                () -> servicePret.rendre(adherent1, 2)
        );

        assertTrue(periodique.estDisponible());
        assertEquals(0, servicePret.nombreEmpruntsEnCours());
    }

}
