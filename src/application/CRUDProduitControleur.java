package application;

import metier.I_Produit;
import metier.Produit;

/**
 * <strong>CRUDProduitControleur</strong>
 *
 * <p>Permet de gérer l'ajout, la suppression et la modification des produits.</p>
 */
public class CRUDProduitControleur extends BaseControleur {

    public CRUDProduitControleur() {
    }

    /**
     * Créer un produit et l'ajout au catalogue
     *
     * @param nom    Le nom du produit
     * @param prixHT Le prix unitaire hors taxe du produit
     * @param qte    La quantité par défaut du produit
     *
     * @return Produit Le produit créer
     */
    public I_Produit ajouterProduit(String nom, double prixHT, int qte) {
        Produit produit = new Produit(nom, prixHT, qte);
        this.catalogue.addProduit(produit);
        return produit;
    }
}
