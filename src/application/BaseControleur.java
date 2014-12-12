package application;

import metier.Catalogue;
import metier.I_Catalogue;

abstract class BaseControleur {
    protected I_Catalogue catalogue = Catalogue.getInstance();
}
