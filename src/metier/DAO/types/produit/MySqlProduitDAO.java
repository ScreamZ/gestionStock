package metier.DAO.types.produit;

import metier.DAO.mysql.MySqlDAO;
import metier.DAO.mysql.MySqlDAOFactory;
import metier.beans.I_Produit;
import metier.beans.ProduitFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MySqlProduitDAO
 */
public class MySqlProduitDAO extends MySqlDAO implements ProduitDAO {
    public MySqlProduitDAO(Connection connection) {
        super(connection);
    }

    /**
     * Méthode de création
     *
     * @param obj L'le produit à créer
     *
     * @return boolean
     */
    @Override
    public boolean create(I_Produit obj) {
        try {
            Integer currentCatalogueID = new MySqlDAOFactory().getCatalogueDAO().findCatalogueID(obj.getCatalogue());
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO Produit(NOM,QUANTITE,PRIX_UNITAIRE_HT,CATALOGUE_ID) VALUES (?, ?, ?,?);");
            statement.setString(1, obj.getNom());
            statement.setInt(2, obj.getQuantite());
            statement.setDouble(3, obj.getPrixUnitaireHT());
            statement.setInt(4, currentCatalogueID);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Méthode pour effacer
     *
     * @param obj Le produit à modifier
     *
     * @return boolean
     */
    @Override
    public boolean delete(I_Produit obj) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM Produit WHERE nom = ?");
            statement.setString(1, obj.getNom());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Méthode de mise à jour
     *
     * @param obj Le produit à mettre à jour
     *
     * @return boolean
     */
    @Override
    public boolean update(I_Produit obj) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("UPDATE Produit SET quantite = ? WHERE nom = ?");
            statement.setInt(1, obj.getQuantite());
            statement.setString(2, obj.getNom());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Méthode de recherche des produits
     *
     * @param nom L'objet à trouver
     *
     * @return Le produit correspondant au nom
     */
    @Override
    public I_Produit find(String nom) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM Produit WHERE nom = ?");
            statement.setString(1, nom);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                rs.close();
                return null;
            } else {
                I_Produit p = ProduitFactory.createProduit(rs.getString("nom"), rs.getDouble("prix_unitaire_ht"), rs.getInt("quantite"));
                rs.close();
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Méthode pour récupérer tous les produits
     *
     * @return La liste de tous les produits
     */
    @Override
    public List<I_Produit> findAll() {
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM Produit");
            ResultSet rs = statement.executeQuery();
            List<I_Produit> list = null;
            if (rs.next()) { // Checks for any results and moves cursor to first row,
                list = new ArrayList<>();
                do {
                    list.add(ProduitFactory.createProduit(rs.getString("nom"), rs.getDouble("prix_unitaire_ht"), rs.getInt("quantite")));
                } while (rs.next());
            }
            rs.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
