package metier.DAO;

import java.util.List;

/**
 * DAO
 */
public interface DAO<E> {
    /**
     * Méthode de création
     *
     * @param obj L'objet à créer
     *
     * @return boolean
     */
    public abstract boolean create(E obj);

    /**
     * Méthode pour effacer
     *
     * @param obj L'objet à modifier
     *
     * @return boolean
     */
    public abstract boolean delete(E obj);

    /**
     * Méthode de mise à jour
     *
     * @param obj L'objet à mettre à jour
     *
     * @return boolean
     */
    public abstract boolean update(E obj);

    /**
     * Méthode de recherche des objets
     *
     * @param nom L'objet à trouver
     *
     * @return L'objet correspondant au nom
     */
    public abstract E find(String nom);

    /**
     * Méthode pour récupérer tous les objets
     *
     * @return La liste de tous les objets
     */
    public abstract List<E> findAll();
}
