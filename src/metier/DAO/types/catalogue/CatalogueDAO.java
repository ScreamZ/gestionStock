package metier.DAO.types.catalogue;

import metier.DAO.DAO;
import metier.beans.I_Catalogue;
import metier.beans.I_Produit;

import java.util.List;
import java.util.Map;

/**
 * CatalogueDAO
 */
public interface CatalogueDAO extends DAO<I_Catalogue> {

    /**
     * Récupère le nom de tous les catalogues existant en base de donnée
     *
     * @return Une liste contenant tous les noms
     */
    public List<String> findCataloguesName();

    /**
     * Récupère tous les produits qui sont contenus dans le catalogue donné
     *
     * @param nomCatalogue Le nom du catalogue
     *
     * @return La liste des I_Produit
     */
    public List<I_Produit> findProduitsForCatalogue(String nomCatalogue);

    /**
     * Récupère tous les noms de catalogues avec leur nombre de produits
     *
     * @return Une map avec le nom et le nombre pour chaque ligne
     */
    public List<String> findAllCataloguesWithAmountOfProducts();
}
