package partition.exception;

public class InputException extends RuntimeException{
    public static final String NEGATIVE_LIST_SIZE = "La taille de la liste doit être supérieure à Zéro";
    public static final String LIST_SIZE_NOT_NUMERIC = "La taille de la liste saisie n'est pas un nombre";

    public static final String VALUE_NOT_NUMERIC = "La valeur saisie n'est pas un nombre";

    public static final String NEGATIVE_PARTITION_SIZE = "La taille de la sous liste doit être supérieure à Zéro";
    public static final String PARTITION_BIGGER_LIST = "La taille de la sous liste doit être inférieure à la taille de la liste";
    public static final String PARTITION_SIZE_NOT_NUMERIC = "La taille de la sous liste saisie n'est pas un nombre";


    public InputException() {
        super();
    }

    public InputException(String message) {
        super(message);
    }
}
