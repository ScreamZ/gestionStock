package metier.DAO.types.catalogue;

import metier.DAO.oracle.OracleDAO;
import metier.beans.*;

import java.sql.*;
import java.util.*;

/**
 * OracleCatalogueDAO
 */
public class OracleCatalogueDAO extends OracleDAO implements CatalogueDAO {

    public OracleCatalogueDAO(Connection connection) {
        super(connection);
    }

    /**
     * Méthode de création
     *
     * @param obj Le catalogue à créer
     *
     * @return boolean
     */
    @Override
    public boolean create(I_Catalogue obj) {
        try {
            CallableStatement statement = this.connection.prepareCall("{CALL NOUVEAUCATALOGUE(?)}");
            statement.setString(1, obj.getNom());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Méthode pour effacer
     *
     * @param obj Le Catalogue à supprimer
     *
     * @return boolean
     */
    @Override
    public boolean delete(I_Catalogue obj) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM Catalogue WHERE nom = ?");
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
    public boolean update(I_Catalogue obj) {
        System.out.println("Sans utilité ? " + this.getClass().getName());
        return false;
    }

    /**
     * Méthode de recherche des catalogues
     *
     * @param nom L'objet à trouver
     *
     * @return Le catalogue correspondant au nom
     */
    @Override
    public I_Catalogue find(String nom) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM Catalogue WHERE nom = ?");
            statement.setString(1, nom);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                rs.close();
                return null;
            } else {
                I_Catalogue p = new Catalogue(rs.getString("nom"));
                rs.close();
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Méthode pour récupérer tous les catalogues ainsi que leurs I_Produits (par le fait que l'on crée l'instance de catalogue)
     *
     * @return La liste de tous les catalogues (nom)
     */
    @Override
    public List<I_Catalogue> findAll() {
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM Catalogue");
            ResultSet rs = statement.executeQuery();
            List<I_Catalogue> list = null;
            if (rs.next()) { // Checks for any results and moves cursor to first row,
                list = new ArrayList<>();
                do {
                    list.add(CatalogueFactory.createCatalogue(rs.getString("nom")));
                } while (rs.next());
            }
            rs.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Récupère le nom de tous les catalogues existant en base de donnée
     *
     * @return Une liste contenant tous les noms
     */
    @Override
    public List<String> findCataloguesName() {
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT nom FROM Catalogue");
            ResultSet rs = statement.executeQuery();
            List<String> list = null;
            if (rs.next()) { // Checks for any results and moves cursor to first row,
                list = new ArrayList<>();
                do {
                    list.add(rs.getString("nom"));
                } while (rs.next());
            }
            rs.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Récupère tous les produits qui sont contenus dans le catalogue donné
     *
     * @param nomCatalogue Le nom du catalogue
     *
     * @return La liste des I_Produit
     */
    @Override
    public List<I_Produit> findProduitsForCatalogue(String nomCatalogue) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM PRODUIT p INNER JOIN CATALOGUE c ON p.CATALOGUE_ID = c.ID WHERE c.NOM = ?");
            statement.setString(1, nomCatalogue);
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

    /**
     * Récupère tous les noms de catalogues avec leur nombre de produits
     *
     * @return Une map avec le nom et le nombre pour chaque ligne
     */
    @Override
    public List<String> findAllCataloguesWithAmountOfProducts() {
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT c.NOM AS nom,COUNT(p.ID) AS count FROM PRODUIT p INNER JOIN CATALOGUE c ON p.CATALOGUE_ID = c.ID GROUP BY c.NOM");
            ResultSet rs = statement.executeQuery();
            List<String> list = null;
            if (rs.next()) { // Checks for any results and moves cursor to first row,
                list = new ArrayList<>();
                do {
                    list.add(rs.getString("nom") + " : " + rs.getInt("count") + " produits");
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
