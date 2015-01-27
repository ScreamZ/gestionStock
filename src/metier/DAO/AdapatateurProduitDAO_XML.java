package metier.DAO;

import metier.I_Produit;

import java.util.List;

/**
 * AdapatateurProduitDAO_XML
 */
public class AdapatateurProduitDAO_XML implements ProduitDAO {

    private ProduitDAO_XML produitDAOXml = new ProduitDAO_XML();

    /**
     * Méthode de création
     *
     * @param obj L'le produit à créer
     *
     * @return boolean
     */
    @Override
    public boolean create(I_Produit obj) {
        return this.produitDAOXml.creer(obj);
    }

    /**
     * Méthode pour effacer
     *
     * @param obj Le produit à modifier
     *
     * @return boolean
     */
    @Override
    public boolean delete(I_Produit obj) {
        return this.produitDAOXml.supprimer(obj);
    }

    /**
     * Méthode de mise à jour
     *
     * @param obj Le produit à mettre à jour
     *
     * @return boolean
     */
    @Override
    public boolean update(I_Produit obj) {
        return this.produitDAOXml.maj(obj);
    }

    /**
     * Méthode de recherche des produits
     *
     * @param nom L'objet à trouver
     *
     * @return Le produit correspondant au nom
     */
    @Override
    public I_Produit find(String nom) {
        return this.produitDAOXml.lire(nom);
    }

    /**
     * Méthode pour récupérer tous les produits
     *
     * @return La liste de tous les produits
     */
    @Override
    public List<I_Produit> findAll() {
        return this.produitDAOXml.lireTous();
    }
}
