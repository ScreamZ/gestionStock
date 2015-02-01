package metier.DAO.mysql;

import metier.beans.I_Catalogue;

import java.sql.Connection;

/**
 * MySqlDAO
 */
public class MySqlDAO {

    protected Connection connection = null;

    public MySqlDAO(Connection connection) {
        this.connection = connection;
    }

    protected Integer findCatalogueID(I_Catalogue catalogue){
        return null;
    }
}
