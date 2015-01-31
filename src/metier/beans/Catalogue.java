package metier.beans;

import metier.DAO.AbstractDAOFactory;
import metier.DAO.types.produit.ProduitDAO;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Project : GestionStock
 * Package : metier
 * Created by ScreamZ
 */
public class Catalogue implements I_Catalogue {

    private final int SAVE_STRATEGY = AbstractDAOFactory.ORACLE; // Any constant from AbstractDAOFactory class
    private String nom;
    private List<I_Produit> productList;

    public Catalogue(String nom) {
        try {
            if (AbstractDAOFactory.getDAOFactory(SAVE_STRATEGY).getCatalogueDAO().find(nom) != null) {
                throw new Exception("Already Exist catalogue named : " + nom);
            }

            this.nom = nom;
            this.productList = new ArrayList<>();
            this.productList.addAll(AbstractDAOFactory.getDAOFactory(SAVE_STRATEGY).getCatalogueDAO().findProduitsForCatalogue(nom));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getNom() {
        return nom;
    }

    /**
     * Ajoute le produit donné au catalogue
     *
     * @param produit L'instance du produit donnée
     *
     * @return True si l'ajout c'est correctement effectué, False le cas échéant
     */
    @Override
    public boolean addProduit(I_Produit produit) {
        if (produit == null)
            return false;

        for (I_Produit i_produit : productList) {
            if (i_produit.getNom().equals(produit.getNom())) return false;
        }

        if (produit.getPrixUnitaireHT() <= 0) return false;
        if (produit.getQuantite() < 0) return false;
        try {
            this.productList.add(produit);
            getProduitDAO().create(produit);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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
        I_Produit p = ProduitFactory.createProduit(nom, prix, qte);

        for (I_Produit i_produit : productList) {
            if (i_produit.getNom().equals(p.getNom())) return false;
        }

        if (p.getPrixUnitaireHT() <= 0) return false;
        if (p.getQuantite() < 0) return false;
        try {
            this.addProduit(p);
            getProduitDAO().create(p);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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
            p = ProduitFactory.createProduit(p.getNom(), p.getPrixUnitaireHT(), p.getQuantite());
            if (p.getPrixUnitaireHT() > 0 && p.getQuantite() >= 0) {

                if (this.addProduit(p)) {
                    try {
                        getProduitDAO().create(p);
                        nb++;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return 0;
                    }
                }
            }
        }
        return nb;
    }

    @Override
    public List<I_Produit> getProduitsList() {
        return this.productList;
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
                try {
                    getProduitDAO().delete(i_produit);
                    this.productList.remove(i_produit);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
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
                    getProduitDAO().update(i_produit);
                } catch (Exception e) {
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
     */
    @Override
    public boolean vendreStock(String nomProduit, int qteVendue) {

        if (qteVendue <= 0) return false;
        for (I_Produit i_produit : productList) {
            if (i_produit.getNom().equals(nomProduit)) {
                try {
                    if (i_produit.getQuantite() < qteVendue) return false;
                    i_produit.enlever(qteVendue);
                    getProduitDAO().update(i_produit);
                } catch (Exception e) {
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
        if (productList.size() == 0) return "\nMontant total TTC du stock : 0,00 €";

        for (I_Produit i_produit : productList) {
            resp += i_produit.toString() + "\n";
        }
        DecimalFormat df = new DecimalFormat("0.00");
        resp += "\nMontant total TTC du stock : " + df.format(this.getMontantTotalTTC()) + " €";

        return resp;
    }

    /**
     * Return the factory instance
     *
     * @return Te factory instance
     */
    private ProduitDAO getProduitDAO() {
        return AbstractDAOFactory.getDAOFactory(SAVE_STRATEGY).getProduitDAO();
    }
}
