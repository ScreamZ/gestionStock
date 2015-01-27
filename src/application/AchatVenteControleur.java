package application;


/**
 * <strong>AchatVenteControleur</strong>
 *
 * <p>Permet le controle des ventes et des achats</p>
 */
public class AchatVenteControleur extends BaseControleur {

    /**
     * Augmente la quantité en stock pour un produit
     *
     * @param nom Le nom du produit auquel regarnir le stock
     * @param qte La quantité à ajouter
     *
     * @return True si l'opération s'est bien passé, false le cas échéant
     */
    public boolean acheterProduit(String nom, int qte) {
        return this.catalogue.acheterStock(nom, qte);
    }

    /**
     * Réduit la quantité en stock pour un produit
     *
     * @param nom Le nom du produit auquel on retire du stock
     * @param qte La quantité à retirer
     *
     * @return True si l'opération s'est bien passée, false le cas échéant
     */
    public boolean vendreProduit(String nom, int qte) {
        return this.catalogue.vendreStock(nom, qte);
    }

}
