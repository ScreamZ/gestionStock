package metier;

import metier.exceptions.ValeurNegativeException;

/**
 * <strong>metier</strong>
 * <p/>
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
