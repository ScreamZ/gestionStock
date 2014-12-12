package application;

/**
 * <strong>EtatStockControleur</strong>
 *
 * <p>Permet de gérer les stocks de produits.</p>
 */
public class EtatStockControleur extends BaseControleur {

    /**
     * Renvoie une chaine formatée permettant de montrer l'état des stocks et le stock total en valeur.
     *
     * @return String La chaine formatée
     */
    public String getEtatStocks() {
        return this.catalogue.toString();
    }
}
