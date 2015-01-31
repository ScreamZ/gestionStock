package metier.beans;

import metier.exceptions.ValeurNegativeException;

import java.text.DecimalFormat;

/**
 * <strong>Produit</strong>
 * <p/>
 * <p>Cette classe représente un objet que l'on peut vendre ou acheter.</p>
 */
public class Produit implements I_Produit {

    /**
     * Taux de TVA communs à tous les objets
     */
    private final static double tauxTVA = 1.2;
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

    private I_Catalogue catalogue = null;

    /**
     * Adpatateur pour l'instanciation temporaire de produits
     *
     * @param nom            le nom
     * @param prixUnitaireHT le prix UHT
     * @param qte            la quantité en stock
     *
     * @deprecated A n'utiliser seulement que pour la compatibilité, l'objet instancié doit automatiquement être re-conçu via la factory afin de disposer d'un catalogue non null
     */
    public Produit(String nom, double prixUnitaireHT, int qte) {
        this.nom = nom;
        this.prixUnitaireHT = prixUnitaireHT;
        this.quantiteStock = qte;

    }

    public Produit(String nom, double prixUnitaireHT, int qte, I_Catalogue catalogue) {
        this.quantiteStock = qte;
        this.nom = nom;
        this.prixUnitaireHT = prixUnitaireHT;
        this.catalogue = catalogue;
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
        return Math.round(prixUnitaireHT * 100.0) / 100.0;

    }

    /**
     * Calcule le prix TTC pour le produit (montant hors taxe multiplié par la TVA).
     *
     * @return le prix TTC
     */
    @Override
    public double getPrixUnitaireTTC() {
        return this.prixUnitaireHT * tauxTVA;
    }

    /**
     * Calcule la valeur TTC du stock (quantité du stock multiplié par le prixUnitaireTTC)
     *
     * @return La valeur TTC de l'intégralité du stock
     */
    @Override
    public double getPrixStockTTC() {
        return getPrixUnitaireTTC() * this.quantiteStock;
    }

    /**
     * Formatte l'affichage d'un produit
     *
     * @return String la chaine formatée
     */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return nom + " - prix HT : " + df.format(prixUnitaireHT) + " € - prix TTC : " + df.format(getPrixUnitaireTTC()) + " € - quantité en stock : " + quantiteStock;
    }

    @Override
    public I_Catalogue getCatalogue() {
        return this.catalogue;
    }
}
