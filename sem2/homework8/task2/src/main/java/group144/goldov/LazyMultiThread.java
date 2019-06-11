package group144.goldov;

import java.util.function.Supplier;

/** Class implements synchronized lazy object */
public class LazyMultiThread<T> implements Lazy<T> {
    private ModifiedSupplier<T> supplier;
    private T value;

    public LazyMultiThread(Supplier<T> supplier) {
        this.supplier = new ModifiedSupplier<T>(supplier);
    }

    /**
     * Calculates value one time
     * @return calculated value
     */
    @Override
    public T get() {
        if (supplier.isCalculated()) {
            return value;
        } else {
            synchronized (this) {
                value = supplier.getFunctionFirstTime().get();
            }
            return value;
        }
    }
}
