package metier;

/**
 * <strong>metier</strong>
 *
 * <p>Cette classe représente un objet que l'on peut vendre ou acheter.</p>
 */
public class Produit implements I_Produit {

    /**
     * Représente la quantité de stocks disponible pour le produit
     */
    private int quantiteStock;

    /**
     * Représente le nom du produit (sa dénomination)
     */
    private String nom;

    /**
     * Représente le prix unitaire du produit (hors taxes)
     */
    private float prixUnitaireHT;

    /**
     * Taux de TVA communs à tous les objets
     */
    private static float tauxTVA = (float) 0.2;

    public Produit(String nom, float prixUnitaireHT, int qte) {
        this.quantiteStock = qte;
        this.nom = nom;
        this.prixUnitaireHT = prixUnitaireHT;
    }

    @Override
    public boolean ajouter(int qteAchetee) {
        return false;
    }

    @Override
    public boolean enlever(int qteVendue) {
        return false;
    }

    @Override
    public String getNom() {
        return null;
    }

    @Override
    public int getQuantite() {
        return 0;
    }

    @Override
    public double getPrixUnitaireHT() {
        return 0;
    }

    @Override
    public double getPrixUnitaireTTC() {
        return 0;
    }

    @Override
    public double getPrixStockTTC() {
        return 0;
    }
}
