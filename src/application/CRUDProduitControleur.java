package application;

import metier.Catalogue;
import metier.I_Catalogue;
import metier.I_Produit;
import metier.Produit;

/**
 * <strong>CRUDProduitControleur</strong>
 *
 * <p>Permet de gérer l'ajout, la suppression et la modification des produits.</p>
 */
public class CRUDProduitControleur {

    private static CRUDProduitControleur instance = null;
    private I_Catalogue catalogue;

    private CRUDProduitControleur() {
        this.catalogue = Catalogue.getInstance();
    }

    public static CRUDProduitControleur getControleur() {
        if (instance == null) instance = new CRUDProduitControleur();

        return instance;
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
