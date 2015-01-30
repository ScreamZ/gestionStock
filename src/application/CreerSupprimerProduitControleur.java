package application;

import metier.I_Produit;
import metier.ProduitFactory;

/**
 * <strong>CreerSupprimerProduitControleur</strong>
 *
 * <p>Permet de gérer l'ajout, la suppression et la modification des produits.</p>
 */
public class CreerSupprimerProduitControleur extends BaseControleur {

    /**
     * Créer un produit et l'ajoute au catalogue
     *
     * @param nom    Le nom du produit
     * @param prixHT Le prix unitaire hors taxe du produit
     * @param qte    La quantité par défaut du produit
     *
     * @return Produit Le produit créer
     */
    public I_Produit ajouterProduit(String nom, double prixHT, int qte) {
        I_Produit produit = ProduitFactory.createProduit(nom, prixHT, qte);
        this.catalogue.addProduit(produit);
        return produit;
    }

    /**
     * Supprimer un produit en le retirant du catalogue grâce à son nom.
     *
     * @param nom Le nom du produit à retirer
     *
     * @return True si l'action s'est correctement effectuée, false le cas échéant
     */
    public boolean supprimerProduit(String nom) {
        return this.catalogue.removeProduit(nom);
    }

}
