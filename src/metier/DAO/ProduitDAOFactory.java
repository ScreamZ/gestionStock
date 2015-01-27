package metier.DAO;

/**
 * ProduitDAOFactory
 */
public class ProduitDAOFactory {
    public static ProduitDAO create(String type) throws Exception {
        type = type.toLowerCase();
        switch (type) {
            case "oracle":
                return new ProduitDAO_Oracle();
            case "xml":
                return new AdapatateurProduitDAO_XML();
            default:
                throw new Exception("On ne peut pas créer de ProduitDAO de type :" + type);
        }
    }
}
