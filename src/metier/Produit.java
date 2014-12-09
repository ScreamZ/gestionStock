package metier;

import metier.exceptions.ValeurNegativeException;

/**
 * <strong>Produit</strong>
 * <p/>
 * <p>Cette classe représente un objet que l'on peut vendre ou acheter.</p>
 */
public class Produit implements I_Produit {

    /**
     * Taux de TVA communs à tous les objets
     */
    private final static double tauxTVA = 0.2;
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
    private double prixUnitaireHT;

    public Produit(String nom, double prixUnitaireHT, int qte) {
        this.quantiteStock = qte;
        this.nom = nom;
        this.prixUnitaireHT = prixUnitaireHT;
    }

    /**
     * Ajoute une quantité définie au stock d'un produit. Cette valeur doit valoir au minimum 1.
     *
     * @param qteAchetee La quantité à ajouter
     *
     * @return true si l'opération s'est bien déroulée
     *
     * @throws ValeurNegativeException
     */
    @Override
    public boolean ajouter(int qteAchetee) throws ValeurNegativeException {
        if (qteAchetee < 1) {
            // Gère le cas où l'ajout est égal à 0 ou négatif;
            throw new ValeurNegativeException();
        } else {
            this.quantiteStock += qteAchetee;
            return true;
        }
    }

    /**
     * Retire une quantité définie au stock d'un produit. Cette valeur doit valoir au minimum 1.
     *
     * @param qteVendue La quantité à retirer
     *
     * @return true si l'opération s'est correctement déroulé
     *
     * @throws ValeurNegativeException
     */
    @Override
    public boolean enlever(int qteVendue) throws ValeurNegativeException {
        if (qteVendue < 1) {
            // Gère le cas où l'ajout est égal à 0 ou négatif;
            throw new ValeurNegativeException();
        } else {
            this.quantiteStock -= qteVendue;
            return true;
        }
    }

    /**
     * Retourne le nom du produit
     *
     * @return le nombre du produit
     */
    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public int getQuantite() {
        return this.quantiteStock;
    }

    @Override
    public double getPrixUnitaireHT() {
        return this.prixUnitaireHT;
    }

    /**
     * Calcule le prix TTC pour le produit (hors taxe multiplié par la TVA).
     *
     * @return le prix TTC
     */
    @Override
    public double getPrixUnitaireTTC() {
        return this.prixUnitaireHT * tauxTVA;
    }

    /**
     * Calcule la valeur TTC du stock
     *
     * @return La valeur TTC de l'intégralité du stock
     */
    @Override
    public double getPrixStockTTC() {
        return getPrixUnitaireTTC() * quantiteStock;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "quantiteStock=" + quantiteStock +
                ", nom='" + nom + '\'' +
                ", prixUnitaireHT=" + prixUnitaireHT +
                '}';
    }
}
