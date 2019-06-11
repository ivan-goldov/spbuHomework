package group144.goldov;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionClassTest {
    @Test
    public void simpleEqualClassesDifferenceTest() throws IOException {
        ReflectionClass reflectionClass = new ReflectionClass();
        reflectionClass.printStructure(SimpleClass.class);
        reflectionClass.diffClasses(group144.goldov.builtClasses.SimpleClass.class, SimpleClass.class);
        assertEquals("The classes are equal", reflectionClass.getDiffClasses(SimpleClass.class,
                group144.goldov.builtClasses.SimpleClass.class));
    }

    @Test
    public void simpleDifferentClassesWithReflectionTest() throws IOException {
        ReflectionClass reflectionClass = new ReflectionClass();
        reflectionClass.printStructure(DifferentSimpleClass.class);
        reflectionClass.diffClasses(group144.goldov.builtClasses.SimpleClass.class,
                group144.goldov.builtClasses.DifferentSimpleClass.class);
        assertEquals("Different methods: 'public int sum' 'public boolean someMethod' " +
                        "\nDifferent fields: 'int a' 'int b' 'String a' 'boolean s' ",
                reflectionClass.getDiffClasses(group144.goldov.builtClasses.SimpleClass.class,
                group144.goldov.builtClasses.DifferentSimpleClass.class));
    }

    @Test
    public void simpleDifferentClassesTest() {
        ReflectionClass reflectionClass = new ReflectionClass();
        reflectionClass.diffClasses(SimpleClass.class, DifferentSimpleClass.class);
        assertEquals("Different methods: 'public int sum' 'public boolean someMethod' " +
                "\nDifferent fields: 'int a' 'int b' 'String a' 'boolean s' ",
                reflectionClass.getDiffClasses(SimpleClass.class, DifferentSimpleClass.class));
    }

    @Test
    public void equalClassesWithInnerClassTest() throws IOException {
        ReflectionClass reflectionClass = new ReflectionClass();
        reflectionClass.printStructure(ClassWithInnerClass.class);
        reflectionClass.diffClasses(ClassWithInnerClass.class, group144.goldov.builtClasses.ClassWithInnerClass.class);
        assertEquals("The classes are equal",
                reflectionClass.getDiffClasses(group144.goldov.builtClasses.ClassWithInnerClass.class
                        , ClassWithInnerClass.class));
    }

    @Test
    public void equalClassesWithExceptionTest() throws IOException {
        ReflectionClass reflectionClass = new ReflectionClass();
        reflectionClass.printStructure(ClassWithException.class);
        reflectionClass.diffClasses(ClassWithException.class, group144.goldov.builtClasses.ClassWithException.class);
        assertEquals("The classes are equal",
                reflectionClass.getDiffClasses(group144.goldov.builtClasses.ClassWithException.class,
                        ClassWithException.class));
    }

    @Test
    public void differentClassesWithExceptionTest() {
        ReflectionClass reflectionClass = new ReflectionClass();
        reflectionClass.diffClasses(ClassWithException.class, SimpleClass.class);
        assertEquals("Different methods: 'public int methodWithException' 'public int sum' \n" +
                "Different fields: 'int[] a' 'int a' 'int b' ",
                reflectionClass.getDiffClasses(ClassWithException.class, SimpleClass.class));
    }

    @Test
    public void equalClassesWithInterfacesTest() throws IOException {
        ReflectionClass reflectionClass = new ReflectionClass();
        reflectionClass.printStructure(ClassWithInterface.class);
        reflectionClass.diffClasses(ClassWithInterface.class, group144.goldov.builtClasses.ClassWithInterface.class);
        assertEquals("The classes are equal",
                reflectionClass.getDiffClasses(ClassWithInterface.class,
                        group144.goldov.builtClasses.ClassWithInterface.class));
    }
}