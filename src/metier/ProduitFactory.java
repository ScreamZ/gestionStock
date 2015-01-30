package metier;

/**
 * ProduitFactory
 */
public class ProduitFactory {
    public static I_Produit createProduit(String nom, double prixUnitaireHT, int qte) {
        return new Produit(nom, prixUnitaireHT, qte);
    }
}
