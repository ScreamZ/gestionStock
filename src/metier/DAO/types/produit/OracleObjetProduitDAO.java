package metier.DAO.types.produit;

import metier.DAO.oracle_sql.OracleDAO;
import metier.DAO.types.produit.ProduitDAO;
import metier.beans.I_Produit;

import java.sql.Connection;
import java.util.List;

/**
 * OracleObjetProduitDAO
 */
public class OracleObjetProduitDAO extends OracleDAO implements ProduitDAO {
    public OracleObjetProduitDAO(Connection connection) {
        super(connection);
    }

    /**
     * Méthode de création
     *
     * @param obj L'objet à créer
     *
     * @return boolean
     */
    @Override
    public boolean create(I_Produit obj) {
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
    public boolean delete(I_Produit obj) {
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
    public boolean update(I_Produit obj) {
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
    public I_Produit find(String nom) {
        return null;
    }

    /**
     * Méthode pour récupérer tous les objets
     *
     * @return La liste de tous les objets
     */
    @Override
    public List<I_Produit> findAll() {
        return null;
    }
}
