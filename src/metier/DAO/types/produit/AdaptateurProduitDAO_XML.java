package metier.DAO.types.produit;

import metier.DAO.xml.XmlDAO;
import metier.beans.I_Produit;
import metier.beans.ProduitFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * AdapatateurProduitDAO_XML
 */
public class AdaptateurProduitDAO_XML extends XmlDAO implements ProduitDAO {

    private XmlProduitDAO produitDAOXml = new XmlProduitDAO();

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
        I_Produit produit = this.produitDAOXml.lire(nom);
        return ProduitFactory.createProduit(produit.getNom(), produit.getPrixUnitaireHT(), produit.getQuantite());
    }

    /**
     * Méthode pour récupérer tous les produits
     *
     * @return La liste de tous les produits
     */
    @Override
    public List<I_Produit> findAll() {
        List<I_Produit> produits = this.produitDAOXml.lireTous();
        List<I_Produit> resultat = new ArrayList<>();
        for (I_Produit produit : produits) {
            resultat.add(ProduitFactory.createProduit(produit.getNom(), produit.getPrixUnitaireHT(), produit.getQuantite()));
        }
        return resultat;
    }
}
