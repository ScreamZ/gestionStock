package metier.DAO.oracle_sql;

import java.sql.Connection;

/**
 * OracleDAO give common connection field for all persistance Oracle
 */
public abstract class OracleDAO{

    protected Connection connection = null;

    public OracleDAO(Connection connection) {
        this.connection = connection;
    }
}
