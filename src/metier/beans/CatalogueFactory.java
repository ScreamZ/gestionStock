package metier.beans;

/**
 * CatalogueFactory
 */
public abstract class CatalogueFactory {
    public static I_Catalogue createCatalogue(String nom) {
        return new Catalogue(nom);
    }
}
