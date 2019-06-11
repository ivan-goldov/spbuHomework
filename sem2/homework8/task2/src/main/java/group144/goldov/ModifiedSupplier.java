package group144.goldov;

import java.util.function.Supplier;

public class ModifiedSupplier<T> {
    private Supplier<T> function;
    private boolean isCalculated;

    public ModifiedSupplier(Supplier<T> supplier) {
        function = supplier;
    }

    /** Returns true if value was calculated */
    public boolean isCalculated() {
        return isCalculated;
    }

    /** Returns supplier function */
    public Supplier<T> getFunctionFirstTime() {
        isCalculated = true;
        return function;
    }
}
