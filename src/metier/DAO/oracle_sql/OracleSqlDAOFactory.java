package metier.DAO.oracle_sql;


import metier.DAO.AbstractDAOFactory;
import metier.DAO.types.catalogue.CatalogueDAO;
import metier.DAO.types.catalogue.OracleSqlCatalogueDAO;
import metier.DAO.types.produit.OracleSqlProduitDAO;
import metier.DAO.types.produit.ProduitDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * OracleDbDAOFactory
 */

public class OracleSqlDAOFactory extends AbstractDAOFactory {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin:@//162.38.222.146:1521/iut";
    private static final String DBUSER = "";
    private static final String DBPWD = "";

    private Connection connection;

    public OracleSqlDAOFactory() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProduitDAO getProduitDAO() {
        return new OracleSqlProduitDAO(connection);
    }

    @Override
    public CatalogueDAO getCatalogueDAO() {
        return new OracleSqlCatalogueDAO(connection);
    }
}