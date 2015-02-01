package metier.DAO;

import config.SaveStrategy;
import metier.DAO.mysql.MySqlDAOFactory;
import metier.DAO.oracle_objet.OracleObjetDAOFactory;
import metier.DAO.oracle_sql.OracleSqlDAOFactory;
import metier.DAO.types.catalogue.CatalogueDAO;
import metier.DAO.types.produit.ProduitDAO;
import metier.DAO.xml.XmlDAOFactory;

/**
 * Cette classe permet de récupérer des DAO de type XML ou Oracle pour les objets produits ou catalogue.
 * Supported strategy can be fond in the Enum {@link config.SaveStrategy}
 */
public abstract class AbstractDAOFactory {

    // DAO Strategy - En ajouter une nouvelle à chaque création de nouveau type de DAO
    public final static SaveStrategy CATALOGUE_DAO_STRATEGY = SaveStrategy.MYSQL;

    // Getter pour un type de DAO, pareil en ajouter un a chaque fois
    public abstract ProduitDAO getProduitDAO();
    public abstract CatalogueDAO getCatalogueDAO();

    public static AbstractDAOFactory getDAOFactory(SaveStrategy whichFactory) {

        switch (whichFactory) {
            case ORACLE_SQL:
                return new OracleSqlDAOFactory();
            case ORACLE_OBJET:
                return new OracleObjetDAOFactory();
            case MYSQL:
                return new MySqlDAOFactory();
            case XML:
                return new XmlDAOFactory();
            default:
                return null;
        }
    }
}