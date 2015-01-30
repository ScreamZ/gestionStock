package metier;

/**
 * ProduitFactory
 */
public abstract class ProduitFactory {
    public static I_Produit createProduit(String nom, double prixUnitaireHT, int qte) {
        return new Produit(nom, prixUnitaireHT, qte);
    }
}
