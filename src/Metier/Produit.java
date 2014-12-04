package Metier;

/**
 * Project : GestionStock
 * Package : Metier
 * Created by ScreamZ
 */
public class Produit implements I_Produit {
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
