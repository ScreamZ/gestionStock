package application;

import metier.beans.Catalogue;
import metier.beans.I_Catalogue;
import metier.beans.ProduitFactory;

/**
 * <strong>EtatStockControleur</strong>
 *
 * <p>Permet de gérer les stocks de produits.</p>
 */
public class EtatStockControleur {

    private I_Catalogue catalogue;
    private static EtatStockControleur instance = new EtatStockControleur();

    public static EtatStockControleur getInstance(){
        return instance;
    }

    private EtatStockControleur(){
        this.catalogue = ProduitFactory.CURRENT_CATALOGUE;
    }

    /**
     * Renvoie une chaine formatée permettant de montrer l'état des stocks et le stock total en valeur.
     *
     * @return String La chaine formatée
     */
    public String getEtatStocks() {
        return this.catalogue.toString();
    }

    /**
     * Renvoie la liste des produits actuellement créés
     *
     * @return La liste des produits
     */
    public String[] getProduitListe() {
        return this.catalogue.getNomProduits();
    }
}
