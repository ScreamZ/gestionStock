package metier.beans;

import metier.exceptions.ValeurNegativeException;

public interface I_Produit {

	public abstract boolean ajouter(int qteAchetee) throws ValeurNegativeException;
	public abstract boolean enlever(int qteVendue) throws ValeurNegativeException;
	public abstract String getNom();
	public abstract int getQuantite();
	public abstract double getPrixUnitaireHT();
	public abstract double getPrixUnitaireTTC();
	public abstract double getPrixStockTTC();
	public abstract String toString();
    public I_Catalogue getCatalogue();
}