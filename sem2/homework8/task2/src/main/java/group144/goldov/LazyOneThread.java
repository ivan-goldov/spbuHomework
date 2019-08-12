package group144.goldov;

import java.util.function.Supplier;

/** Class implements non-synchronized lazy object */
public class LazyOneThread<T> implements Lazy<T> {
    private ModifiedSupplier <T> supplier;
    private T value = null;

    public LazyOneThread(Supplier<T> supplier) {
        this.supplier = new ModifiedSupplier(supplier);
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
            value = supplier.getFunctionFirstTime().get();
            return value;
        }
    }
}
