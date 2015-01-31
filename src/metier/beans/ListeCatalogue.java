package metier.beans;

import metier.DAO.AbstractDAOFactory;

import java.util.HashMap;
import java.util.List;

/**
 * ListeCatalogue
 */
public class ListeCatalogue {
    public static final int WHICHFACTORY = AbstractDAOFactory.ORACLE;

    private static ListeCatalogue instance = new ListeCatalogue();
    private HashMap<String, I_Catalogue> lesCatalogues = new HashMap<>();

    public static ListeCatalogue getInstance() {
        return instance;
    }

    /**
     * Récupère un catalogue depuis la liste
     *
     * @param nom Le nom du catalogue
     *
     * @return Le catalogue en question ou null
     */
    public I_Catalogue getCatalogue(String nom) {
        return AbstractDAOFactory.getDAOFactory(WHICHFACTORY).getCatalogueDAO().find(nom);
    }

    /**
     * Récupère la liste de tous les catalogues (leurs noms)
     *
     * @return La liste des noms de catalogue
     */
    public HashMap<String, I_Catalogue> getAllCataloguesName() {
        List<I_Catalogue> catalogueList = AbstractDAOFactory.getDAOFactory(WHICHFACTORY).getCatalogueDAO().findAll();

        for (I_Catalogue catalogue : catalogueList) {
            this.lesCatalogues.put(catalogue.getNom(), null);
        }

        return this.lesCatalogues;
    }

    /**
     * Créer un nouveau catalogue de produits
     *
     * @param nomCatalogue Le nom du nouveau catalogue
     *
     * @return True si le catalogue à été créé, false si il existe déjà.
     */
    public boolean createCatalogue(String nomCatalogue) {
        I_Catalogue catalogue = CatalogueFactory.createCatalogue(nomCatalogue);
        if (this.lesCatalogues.containsKey(nomCatalogue)) return false;

        this.lesCatalogues.put(nomCatalogue, new Catalogue(nomCatalogue));
        return true;
    }

    /**
     * Supprime le catalogue et ses produits
     *
     * @param nomCatalogue Le nom du catalogue
     *
     * @return True si le catalogue à été supprimé, false sinon.
     */
    public boolean deleteCatalogue(String nomCatalogue) {
        return this.lesCatalogues.remove(nomCatalogue) != null;
    }
}