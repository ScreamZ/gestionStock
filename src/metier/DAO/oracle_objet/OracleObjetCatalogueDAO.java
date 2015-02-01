package metier.DAO.oracle_objet;

import metier.DAO.oracle_sql.OracleDAO;
import metier.DAO.types.catalogue.CatalogueDAO;
import metier.beans.I_Catalogue;
import metier.beans.I_Produit;

import java.sql.Connection;
import java.util.List;

/**
 * OracleObjetCatalogueDAO
 */
public class OracleObjetCatalogueDAO extends OracleDAO implements CatalogueDAO {
    public OracleObjetCatalogueDAO(Connection connection) {
        super(connection);
    }

    /**
     * Récupère le nom de tous les catalogues existant en base de donnée
     *
     * @return Une liste contenant tous les noms
     */
    @Override
    public List<String> findCataloguesName() {
        return null;
    }

    /**
     * Récupère tous les produits qui sont contenus dans le catalogue donné
     *
     * @param nomCatalogue Le nom du catalogue
     *
     * @return La liste des I_Produit
     */
    @Override
    public List<I_Produit> findProduitsForCatalogue(String nomCatalogue) {
        return null;
    }

    /**
     * Récupère tous les noms de catalogues avec leur nombre de produits
     *
     * @return Une map avec le nom et le nombre pour chaque ligne
     */
    @Override
    public List<String> findAllCataloguesWithAmountOfProducts() {
        return null;
    }

    /**
     * Méthode de création
     *
     * @param obj L'objet à créer
     *
     * @return boolean
     */
    @Override
    public boolean create(I_Catalogue obj) {
        return false;
    }

    /**
     * Méthode pour effacer
     *
     * @param obj L'objet à modifier
     *
     * @return boolean
     */
    @Override
    public boolean delete(I_Catalogue obj) {
        return false;
    }

    /**
     * Méthode de mise à jour
     *
     * @param obj L'objet à mettre à jour
     *
     * @return boolean
     */
    @Override
    public boolean update(I_Catalogue obj) {
        return false;
    }

    /**
     * Méthode de recherche des objets
     *
     * @param nom L'objet à trouver
     *
     * @return L'objet correspondant au nom
     */
    @Override
    public I_Catalogue find(String nom) {
        return null;
    }

    /**
     * Méthode pour récupérer tous les objets
     *
     * @return La liste de tous les objets
     */
    @Override
    public List<I_Catalogue> findAll() {
        return null;
    }
}
