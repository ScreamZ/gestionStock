package metier.DAO;

import metier.DAO.oracle.OracleDAOFactory;
import metier.DAO.types.catalogue.CatalogueDAO;
import metier.DAO.types.produit.ProduitDAO;
import metier.DAO.xml.XmlDAOFactory;

// Abstract class DAO Factory
public abstract class AbstractDAOFactory {

    // List of DAO types supported by the factory
    public static final int ORACLE = 1;
    public static final int XML = 2;

    // To be redifined in children
    public abstract ProduitDAO getProduitDAO();
    public abstract CatalogueDAO getCatalogueDAO();

    public static AbstractDAOFactory getDAOFactory(int whichFactory) {

        switch (whichFactory) {
            case ORACLE:
                return new OracleDAOFactory();
            case XML:
                return new XmlDAOFactory();
            default:
                return null;
        }
    }
}