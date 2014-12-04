package metier.exceptions;

/**
 * Défini une exception en cas d'ajout d'une valeur negative
 */
public class ValeurNegativeException extends Exception {

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public ValeurNegativeException() {
        System.err.println("Vous ne pouvez pas ajouter une valeur égale à 0 ou négative");
    }
}
