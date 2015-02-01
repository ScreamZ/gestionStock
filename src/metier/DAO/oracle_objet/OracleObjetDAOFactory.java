package metier.DAO.oracle_objet;

import metier.DAO.AbstractDAOFactory;
import metier.DAO.types.produit.OracleObjetProduitDAO;
import metier.DAO.types.catalogue.CatalogueDAO;
import metier.DAO.types.produit.ProduitDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * OracleObjetDAOFactory
 */
public class OracleObjetDAOFactory extends AbstractDAOFactory {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin:@//162.38.222.146:1521/iut";
    private static final String DBUSER = "hanssa";
    private static final String DBPWD = "";

    private Connection connection;

    public OracleObjetDAOFactory() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProduitDAO getProduitDAO() {
        return new OracleObjetProduitDAO(connection);
    }

    @Override
    public CatalogueDAO getCatalogueDAO() {
        return new OracleObjetCatalogueDAO(connection);
    }
}
