package application;

import metier.DAO.AbstractDAOFactory;
import metier.beans.Catalogue;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * SelectionnerCatalogueControleur
 */
public class SelectionnerCatalogueControleur {

    private static SelectionnerCatalogueControleur instance = new SelectionnerCatalogueControleur();

    private SelectionnerCatalogueControleur() {
    }

    public static SelectionnerCatalogueControleur getInstance() {
        return instance;
    }

    public List<String> getAllCataloquesNames() {
        List<String> lesCatalogues = AbstractDAOFactory.getDAOFactory(AbstractDAOFactory.CATALOGUE_DAO_STRATEGY).getCatalogueDAO().findCataloguesName();
        if (lesCatalogues != null) {
            Collections.sort(lesCatalogues);
        }

        return lesCatalogues;
    }

    public List<String> getAllCataloguesWithAmountOfProducts() {
        List<String> lesCatalogues = AbstractDAOFactory.getDAOFactory(AbstractDAOFactory.CATALOGUE_DAO_STRATEGY).getCatalogueDAO().findAllCataloguesWithAmountOfProducts();
        if (lesCatalogues != null) {
            Collections.sort(lesCatalogues);
        }
        return lesCatalogues;
    }

    public boolean createCatalogue(String nomCatalogue) {
        if (AbstractDAOFactory.getDAOFactory(AbstractDAOFactory.CATALOGUE_DAO_STRATEGY).getCatalogueDAO().find(nomCatalogue) == null) {
            return AbstractDAOFactory.getDAOFactory(AbstractDAOFactory.CATALOGUE_DAO_STRATEGY).getCatalogueDAO().create(new Catalogue(nomCatalogue));
        } else {
            return false;
        }
    }
}
