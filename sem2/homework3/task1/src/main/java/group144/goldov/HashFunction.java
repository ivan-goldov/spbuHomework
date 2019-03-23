package group144.goldov;

/** The interface that allows user to change the hash function */
public interface HashFunction {

    /** A method that gets hash */
    int Hash(String string);

    /** A method that returns mod of the hash function */
    int getMod();
}
