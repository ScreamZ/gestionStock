package application;

import metier.Catalogue;
import metier.I_Catalogue;

/**
 * <strong>AchatVenteControleur</strong>
 *
 * <p>Permet le controle des ventes et des achats</p>
 */
public class AchatVenteControleur {
    private static AchatVenteControleur instance = null;
    private I_Catalogue catalogue;

    private AchatVenteControleur() {
        this.catalogue = Catalogue.getInstance();
    }

    public static AchatVenteControleur getControleur() {
        if (instance == null) instance = new AchatVenteControleur();

        return instance;
    }
}
