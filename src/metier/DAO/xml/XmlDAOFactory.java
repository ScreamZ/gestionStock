package metier.DAO.xml;


import metier.DAO.AbstractDAOFactory;
import metier.DAO.types.catalogue.CatalogueDAO;
import metier.DAO.types.produit.AdaptateurProduitDAO_XML;
import metier.DAO.types.produit.ProduitDAO;

/**
 * XmlDAOFactory
 */
public class XmlDAOFactory extends AbstractDAOFactory {


    @Override
    public ProduitDAO getProduitDAO() {
        return new AdaptateurProduitDAO_XML();
    }

    @Override
    public CatalogueDAO getCatalogueDAO() {
        // Not supported as XML
        return null;
    }
}
