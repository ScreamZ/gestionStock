package application;

import metier.Catalogue;
import metier.I_Catalogue;

/**
 * <strong>EtatStockControleur</strong>
 *
 * <p>Permet de gérer les stocks de produits.</p>
 */
public class EtatStockControleur {

    private static EtatStockControleur instance = null;
    private I_Catalogue catalogue;

    private EtatStockControleur() {
        this.catalogue = Catalogue.getInstance();
    }

    public static EtatStockControleur getControleur() {
        if (instance == null) instance = new EtatStockControleur();

        return instance;
    }

    /**
     * Renvoie une chaine formatée permettant de montrer l'état des stocks et le stock total en valeur.
     *
     * @return String La chaine formatée
     */
    public String getEtatStocks() {
        return this.catalogue.toString();
    }
}
