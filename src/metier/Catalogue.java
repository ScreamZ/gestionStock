package metier;

import metier.exceptions.ValeurNegativeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    /**
     * Ajoute le produit donné au catalogue
     *
     * @param produit L'instance du produit donnée
     *
     * @return True si l'ajout c'est correctement effectué, False le cas échéant
     */
    @Override
    public boolean addProduit(I_Produit produit) { // TODO Ajouter la gestion d'une exception si le produit existe
        if (produit == null)
            return false;

        for (I_Produit i_produit : productList) {
            if (i_produit.getNom().equals(produit.getNom())) return false;
        }

        if (produit.getPrixUnitaireHT() < 0) return false;
        this.productList.add(produit);
        return true;
    }

    /**
     * Créer un produit grâces aux valeurs passées en parametres et l'ajoute au catalogue
     *
     * @param nom  Le nom du produit
     * @param prix Le prix unitaire HT du produit
     * @param qte  La quantité du produit dans le catalogue
     *
     * @return True si l'ajout s'est correctement déroulé, False le cas échéant
     */
    @Override
    public boolean addProduit(String nom, double prix, int qte) {
        Produit p = new Produit(nom, prix, qte);

        for (I_Produit i_produit : productList) {
            if (i_produit.getNom().equals(p.getNom())) return false;
        }
        this.addProduit(p);
        return true;
    }

    /**
     * Ajoute une liste de produit au catalogue
     *
     * @param listeProduits La liste des produits que l'on souhaite ajouter
     *
     * @return Le nombre de produits ajoutés
     */
    @Override
    public int addProduits(List<I_Produit> listeProduits) {
        if (listeProduits == null) return 0;
        Iterator i = listeProduits.iterator();
        int nb = 0;
        while (i.hasNext()) {
            I_Produit p = (I_Produit) i.next();
            if (p.getPrixUnitaireHT() > 0 && p.getQuantite() >= 0) {
                if (this.addProduit(p)) nb++;
            }
        }
        return nb;
    }

    /**
     * Cherche si le nom d'un produit figure dans le catalogue et le retire si c'est le cas.
     *
     * @param nom Le nom du produit à retirer
     *
     * @return True si le produit a été retirer, False dans le cas échéant.
     */
    @Override
    public boolean removeProduit(String nom) {
        for (I_Produit i_produit : productList) {
            if (i_produit.getNom().equals(nom)) {
                this.productList.remove(i_produit);
                return true;
            }
        }
        return false;
    }

    /**
     * Essaye d'ajouter une quantité de produits au stock d'un type produit de nom donné.
     *
     * @param nomProduit Le nom du produit auquel on veut ajouter du stock
     * @param qteAchetee La quantitée à ajouter
     *
     * @return True si l'action s'est correctement effectuée, False le cas échéant
     */
    @Override
    public boolean acheterStock(String nomProduit, int qteAchetee) {
        if (qteAchetee <= 0) return false;

        for (I_Produit i_produit : productList) {
            if (i_produit.getNom().equals(nomProduit)) {
                try {
                    i_produit.ajouter(qteAchetee);
                } catch (ValeurNegativeException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Essaye d'enlever une quantité de produits au stock d'un type produit de nom donné.
     *
     * @param nomProduit Le nom du produit auquel on veut enlever du stock
     * @param qteVendue  La quantitée à enlever
     *
     * @return True si l'action s'est correctement effectuée, False le cas échéant
     *
     * @throws ValeurNegativeException
     */
    @Override
    public boolean vendreStock(String nomProduit, int qteVendue) {
        for (I_Produit i_produit : productList) {
            if (i_produit.getNom().equals(nomProduit)) {
                try {
                    if (i_produit.getQuantite() < qteVendue) return false;
                    i_produit.enlever(qteVendue);
                } catch (ValeurNegativeException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Récupère le nom de tous les produits du catalogue
     *
     * @return Un tableau contenant le nom des produits
     */
    @Override
    public String[] getNomProduits() {
        String[] lesProduits = new String[productList.size()];
        int compteur = 0;
        
        Collections.sort(productList, new Comparator<I_Produit>() {
            public int compare(I_Produit p1, I_Produit p2) {
                return p1.getNom().compareTo(p2.getNom());
            }
        });

        for (I_Produit i_produit : productList) {
            lesProduits[compteur] = i_produit.getNom();
            compteur++;
        }
        return lesProduits;
    }

    /**
     * Retourne le montant TTC du catalogue (Somme des stocks des produits TTC)
     *
     * @return Le montant Total du catalogue TTC
     */
    @Override
    public double getMontantTotalTTC() {
        double total = 0.0;

        for (I_Produit i_produit : productList) {
            total += i_produit.getPrixStockTTC();
        }

        return Math.round(total * 100.0) / 100.0;
    }

    /**
     * Réinitialise le catalogue en retirant tous les produits qui le constitue.
     */
    @Override
    public void clear() {
        this.productList.clear();
    }

    /**
     * Formatte l'affichage d'un catalogue et affiche donc les produits contenus dans ce dernier si il y en a.
     *
     * @return La chaîne formatée OU "Aucun produit dans le catalogue"
     */
    @Override
    public String toString() {
        String resp = "";
        if (productList.size() == 0) return "Aucun produit dans le catalogue\r\n";

        for (I_Produit i_produit : productList) {
            resp += i_produit.toString() + "\r\n";
        }
        return resp;
    }
}
