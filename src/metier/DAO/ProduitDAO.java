package metier.DAO;

import metier.I_Produit;

import java.util.List;

/**
 * ProduitDAO
 */
public interface ProduitDAO {
    /**
     * Méthode de création
     *
     * @param obj L'le produit à créer
     *
     * @return boolean
     */
    public boolean create(I_Produit obj);

    /**
     * Méthode pour effacer
     *
     * @param obj Le produit à modifier
     *
     * @return boolean
     */
    public boolean delete(I_Produit obj);

    /**
     * Méthode de mise à jour
     *
     * @param obj Le produit à mettre à jour
     *
     * @return boolean
     */
    public boolean update(I_Produit obj);

    /**
     * Méthode de recherche des produits
     *
     * @param nom L'objet à trouver
     *
     * @return Le produit correspondant au nom
     */
    public I_Produit find(String nom);

    /**
     * Méthode pour récupérer tous les produits
     *
     * @return La liste de tous les produits
     */
    public List<I_Produit> findAll();
}
