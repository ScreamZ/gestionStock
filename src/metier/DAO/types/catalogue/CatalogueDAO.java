package metier.DAO.types.catalogue;

import metier.DAO.DAO;
import metier.beans.I_Catalogue;
import metier.beans.I_Produit;

import java.util.List;

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
}
