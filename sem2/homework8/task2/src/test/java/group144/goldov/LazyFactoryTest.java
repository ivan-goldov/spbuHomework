package group144.goldov;

import org.junit.jupiter.api.Test;
import java.util.function.Supplier;
import static org.junit.jupiter.api.Assertions.*;

class LazyFactoryTest {
    @Test
    public void NonSynchronizedTest() {
        Supplier<String> stringSupplier = () -> "abc";
        Lazy<String> lazy = LazyFactory.createOneThreadLazy(stringSupplier);
        assertEquals("abc", lazy.get());
    }

    @Test
    public void NullNonSynchronizedTest() {
        Supplier<Integer> integerSupplier = () -> null;
        Lazy<Integer> lazy = LazyFactory.createOneThreadLazy(integerSupplier);
        assertNull(lazy.get());
    }

    @Test
    public void MultiThreadTest() {
        Supplier<String> stringSupplier = () -> "abcd";
        Lazy<String> lazy = LazyFactory.createMultiThreadLazy(stringSupplier);
        assertEquals("abcd", lazy.get());
    }

    @Test
    public void NullMultiThreadTest() {
        Supplier<Boolean> booleanSupplier = () -> null;
        Lazy<Boolean> lazy = LazyFactory.createMultiThreadLazy(booleanSupplier);
        assertNull(lazy.get());
    }
}