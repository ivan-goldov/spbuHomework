package group144.goldov;

/**
 * Class realizing lazy calculation
 * @param <T> of the return value
 */
public interface Lazy<T> {
    /**
     * Returns the result of the lazy calculation
     * @return the value of the result
     */
    T get();

}
