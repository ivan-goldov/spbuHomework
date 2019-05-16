package group144.goldov;

import java.util.function.Supplier;

/** Class realizes constructor of the lazy objects */
public class LazyFactory {

    /**
     * Creates non-synchronized lazy object
     * @param supplier to get value
     * @param <T> type of the calculated value
     * @return calculated value or calculates value and returns it if it isn't calculated yet
     */
    public static <T> Lazy<T> createOneThreadLazy(Supplier<T> supplier) {
        return new Lazy<T>() {
            private Supplier function = null;
            private T value = null;

            @Override
            public T get() {
                if (function != null) {
                    return value;
                } else {
                    value = supplier.get();
                    function = supplier;
                    return value;
                }
            }
        };
    }

    /**
     * Multi-thread realization
     * @param supplier to get value
     * @param <T> type of the calculated value
     * @return calculated value or calculates value and returns it if it isn't calculated yet
     */
    public static <T> Lazy<T> createMultiThreadLazy(Supplier<T> supplier) {
        return new Lazy<T>() {
            private Supplier function = null;
            private T value = null;

            @Override
            public T get() {
                if (function != null) {
                    return value;
                } else {
                    synchronized (this) {
                        if (function == null) {
                            value = supplier.get();
                            function = supplier;
                        }
                    }
                    return value;
                }
            }
        };
    }

}
