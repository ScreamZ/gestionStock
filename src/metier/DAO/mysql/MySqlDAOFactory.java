package metier.DAO.mysql;

import metier.DAO.AbstractDAOFactory;
import metier.DAO.types.catalogue.MySqlCatalogueDAO;
import metier.DAO.types.produit.MySqlProduitDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * MySqlDAOFactory
 */
public class MySqlDAOFactory extends AbstractDAOFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost/xp";
    private static final String DBUSER = "root";
    private static final String DBPWD = "";

    private Connection connection;

    public MySqlDAOFactory() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MySqlProduitDAO getProduitDAO() {
        return new MySqlProduitDAO(connection);
    }

    @Override
    public MySqlCatalogueDAO getCatalogueDAO() {
        return new MySqlCatalogueDAO(connection);
    }
}
