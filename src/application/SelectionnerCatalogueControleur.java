package application;

import metier.DAO.AbstractDAOFactory;

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
        List<String> lesCatalogues = AbstractDAOFactory.getDAOFactory(AbstractDAOFactory.ORACLE).getCatalogueDAO().findCataloguesName();
        Collections.sort(lesCatalogues);
        return lesCatalogues;
    }

    public List<String> getAllCataloguesWithAmountOfProducts(){
        List<String> lesCatalogues = AbstractDAOFactory.getDAOFactory(AbstractDAOFactory.ORACLE).getCatalogueDAO().findAllCataloguesWithAmountOfProducts();
        Collections.sort(lesCatalogues);
        return lesCatalogues;
    }
}
