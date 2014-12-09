package metier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Project : GestionStock
 * Package : metier
 * Created by ScreamZ
 */
public class Catalogue implements I_Catalogue {

    private static Catalogue c = null;
    private ArrayList<I_Produit> productList;

    private Catalogue() {
        this.productList = new ArrayList<I_Produit>();
    }

    public static Catalogue getInstance() {

        if (Catalogue.c == null) Catalogue.c = new Catalogue();

        return Catalogue.c;
    }

    @Override
    public boolean addProduit(I_Produit produit) {
        if (this.productList.indexOf(produit) >= 0)
            return false;
        this.productList.add(produit);
        return true;
    }

    @Override
    public boolean addProduit(String nom, double prix, int qte) {
        Produit p = new Produit(nom, (float) prix, qte);
        this.addProduit(p);
        return true;
    }

    @Override
    public int addProduits(List<I_Produit> l) {
        Iterator i = l.iterator();
        int nb = 0;
        while (i.hasNext()) {
            if (this.addProduit((I_Produit) i.next())) nb++;
        }
        return nb;
    }

    @Override
    public boolean removeProduit(String nom) {
        return false;
    }

    @Override
    public boolean acheterStock(String nomProduit, int qteAchetee) {
        return false;
    }

    @Override
    public boolean vendreStock(String nomProduit, int qteVendue) {
        return false;
    }

    @Override
    public String[] getNomProduits() {
        return new String[0];
    }

    @Override
    public double getMontantTotalTTC() {
        return 0;
    }

    @Override
    public void clear() {

    }
}
