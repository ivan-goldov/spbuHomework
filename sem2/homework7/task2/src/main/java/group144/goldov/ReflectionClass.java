package group144.goldov;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

/** Class that prints and compares classes with reflection */
public class ReflectionClass {

    private StringBuilder classBuilder = new StringBuilder();
    private StringBuilder difference = new StringBuilder();

    /**
     * Prints class' structure
     * @param someClass is printed
     */
    public void printStructure(Class<?> someClass) throws IOException {
        classBuilder.append("package group144.goldov.builtClasses;\n\n");
        FileWriter fileWriter = new FileWriter("src/main/java/group144/goldov/builtClasses/"
                + someClass.getSimpleName() + ".java");
        fileWriter.write(setStructure(someClass));
        fileWriter.close();
        classBuilder = new StringBuilder();
    }

    /**
     * Parsing class and read class' attributes
     * @param someClass is read
     * @return class' architecture
     */
    private String setStructure(Class<?> someClass) {
        setClassName(someClass);
        setSuperClass(someClass);
        setInterfaces(someClass);
        setClassFields(someClass);
        setClassConstructors(someClass);
        setClassMethods(someClass);
        setInnerClasses(someClass);
        classBuilder.append("\n}");
        return classBuilder.toString();
    }

    /**
     * Reads class' name, modifiers and parameters
     * @param someClass is read
     */
    private void setClassName(Class<?> someClass) {
        if (someClass.getModifiers() != 0) {
            classBuilder.append(Modifier.toString(someClass.getModifiers())).append(" class ");
        } else {
            classBuilder.append("public class ");
        }
        if (someClass.getTypeParameters().length != 0) {
            TypeVariable[] parameters = someClass.getTypeParameters();
            classBuilder.append("<");
            for (int i = 0; i < parameters.length - 1; i++) {
                classBuilder.append(parameters[i].getName()).append(", ");
            }
            classBuilder.append(parameters[parameters.length - 1].getName());
            classBuilder.append("> ");
        }
        classBuilder.append(someClass.getSimpleName()).append(" ");
    }

    /**
     * Reads what interfaces class implements
     * @param someClass is read
     */
    private void setInterfaces(Class<?> someClass) {
        if (someClass.getGenericInterfaces().length != 0) {
            Type[] interfaces = someClass.getGenericInterfaces();
            classBuilder.append("implements ");
            for (int i = 0; i < interfaces.length - 1; i++) {
                classBuilder.append(interfaces[i].getTypeName()).append(", ");
            }
            classBuilder.append(interfaces[interfaces.length - 1].getTypeName()).append(" ");
        }
        classBuilder.append("{\n");
    }

    /**
     * Reads what class does it inherit from
     * @param someClass is read
     */
    private void setSuperClass(Class<?> someClass) {
        if (!someClass.getGenericSuperclass().getTypeName().equals("java.lang.Object")) {
            classBuilder.append("extends ").append(someClass.getGenericSuperclass().getTypeName()).append(" ");
        }
    }

    /**
     * Reads class' fields
     * @param someClass is read
     */
    private void setClassFields(Class<?> someClass) {
        Field[] fields = someClass.getDeclaredFields();
        for (Field field : fields) {
            if (!field.getName().equals("this$0")) {
                classBuilder.append("\t").append(Modifier.toString(field.getModifiers())).append(" ");
                if (Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                }
                classBuilder.append(field.getGenericType().getTypeName()).append(" ")
                        .append(field.getName()).append(";\n");
                classBuilder.append("\n");
            }
        }
    }

    /**
     * Reads class' constructors
     * @param someClass is read
     */
    private void setClassConstructors(Class<?> someClass) {
        Constructor[] constructors = someClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            if (Modifier.isPrivate(constructor.getModifiers())) {
                constructor.setAccessible(true);
            }
            classBuilder.append("\t").append(Modifier.toString(constructor.getModifiers())).append(" ")
                        .append(someClass.getSimpleName()).append("(");
            setParameters(constructor);
            classBuilder.append("{ }\n\n");
        }
    }

    /**
     * Reads class' methods
     * @param someClass is read
     */
    private void setClassMethods(Class<?> someClass) {
        Method[] methods = someClass.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isPrivate(method.getModifiers())) {
                method.setAccessible(true);
            }
            classBuilder.append("\t").append(Modifier.toString(method.getModifiers())).append(" ")
                    .append(method.getGenericReturnType()).append(" ")
                    .append(method.getName()).append("(");
            setParameters(method);
            if (method.getExceptionTypes().length != 0) {
                Class<?>[] exceptions = method.getExceptionTypes();
                classBuilder.append("throws ");
                for (int i = 0; i < exceptions.length - 1; i++) {
                    classBuilder.append(exceptions[i].getName()).append(", ");
                }
                classBuilder.append(exceptions[exceptions.length - 1].getName()).append(" ");
            }
            classBuilder.append("{\n\t\tthrow new UnsupportedOperationException();\n\t}\n\n");
        }
    }

    /**
     * Reads method's or constructor's parameters
     * @param method which parameters are read
     */
    private void setParameters(Executable method) {
        Parameter[] parameters = method.getParameters();
        if (parameters.length != 0) {
            for (int i = 0; i < parameters.length - 1; i++) {
                classBuilder.append(parameters[i].getParameterizedType().getTypeName()).append(" ")
                        .append(parameters[i].getName()).append(", ");
            }
            classBuilder.append(parameters[parameters.length - 1].getParameterizedType().getTypeName()).append(" ")
                    .append(parameters[parameters.length - 1].getName());
        }
        classBuilder.append(") ");
    }

    /**
     * Reads class' inner classes
     * @param someClass is read
     */
    private void setInnerClasses(Class<?> someClass) {
        if (someClass.getDeclaredClasses().length != 0) {
            classBuilder.append("\t");
            Class<?>[] classes = someClass.getDeclaredClasses();
            ReflectionClass reflectionClass = new ReflectionClass();
            for (Class<?> aClass : classes) {
                classBuilder.append("\n").append(reflectionClass.setStructure(aClass));
            }
        }
    }

    /**
     * Prints different methods and fields of two classes
     * @param firstClass to compare
     * @param secondClass to compare
     */
    public void diffClasses(Class<?> firstClass, Class<?> secondClass) {
        setDifferentClasses(firstClass, secondClass);
        System.out.println(difference);
    }

    /**
     * Returns state of the difference in classes (this method is useful in test)
     * @return String with the different methods
     */
    public String getDiffClasses(Class<?> firstClass, Class<?> secondClass) {
        return difference.toString();
    }

    /**
     * Compares fields by their names and modifiers
     * @param firstField to compare
     * @param secondField to compare
     * @return true if they are equal, false if not
     */
    private boolean areFieldsEqual(Field firstField, Field secondField) {
        return firstField.getType().getSimpleName().equals(secondField.getType().getSimpleName()) &&
               Modifier.toString(firstField.getModifiers()).equals(Modifier.toString(secondField.getModifiers())) &&
               firstField.getName().equals(secondField.getName()) ;
    }

    /**
     * Compares methods by their parameters, modifiers and exception
     * @param firstMethod to compare
     * @param secondMethod to compare
     * @return true if they are equal, false if not
     */
    private boolean areMethodsEqual(Method firstMethod, Method secondMethod) {
        return Modifier.toString(firstMethod.getModifiers()).equals(Modifier.toString(secondMethod.getModifiers())) &&
               firstMethod.getName().equals(secondMethod.getName()) && areExceptionsEqual(firstMethod, secondMethod)
               && areParametersEqual(firstMethod, secondMethod) &&
                firstMethod.getReturnType().equals(secondMethod.getReturnType());
    }

    /**
     * Compares methods' exceptions up to permutation
     * @param firstMethod to compare
     * @param secondMethod to compare
     * @return true if the are equal, false if not
     */
    private boolean areExceptionsEqual(Method firstMethod, Method secondMethod) {
        if (firstMethod.getGenericExceptionTypes().length != secondMethod.getGenericExceptionTypes().length) {
            return false;
        }
        Type[] firstExceptions = firstMethod.getGenericExceptionTypes();
        List<Type> secondExceptions = Arrays.asList(secondMethod.getGenericExceptionTypes());
        for (Type exception : firstExceptions) {
            if (!secondExceptions.contains(exception)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compares methods' parameters up to permutation
     * @param firstMethod to compare
     * @param secondMethod to compare
     * @return true if the are equal, false if not
     */
    private boolean areParametersEqual(Method firstMethod, Method secondMethod) {
        if (firstMethod.getParameters().length != secondMethod.getParameterTypes().length) {
            return false;
        }
        Class<?>[] firstParameters = firstMethod.getParameterTypes();
        List<Class<?>> secondParameters = Arrays.asList(secondMethod.getParameterTypes());
        for (Class<?> parameter : firstParameters) {
            if (!secondParameters.contains(parameter)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compares two classes by their methods and fields
     * @param firstClass to compare
     * @param secondClass to compare
     * @return true if the are equal, false if not
     */
    private boolean areClassesEqual(Class<?> firstClass, Class<?> secondClass) {
        if (firstClass.getDeclaredMethods().length != secondClass.getDeclaredMethods().length) {
            return false;
        }
        Method[] firstMethods = firstClass.getDeclaredMethods();
        Method[] secondMethods = secondClass.getDeclaredMethods();
        for (int i = 0; i < firstMethods.length; i++) {
            if (!areMethodsEqual(firstMethods[i], secondMethods[i])) {
                return false;
            }
        }
        Field[] firstFields = firstClass.getDeclaredFields();
        Field[] secondFields = secondClass.getDeclaredFields();
        for (int i = 0; i < firstFields.length; i++) {
            if (!areFieldsEqual(firstFields[i], secondFields[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Writes difference between two classes
     * @param firstClass to compare
     * @param secondClass to compare
     */
    private void setDifferentClasses(Class<?> firstClass, Class<?> secondClass) {
        if (areClassesEqual(firstClass, secondClass)) {
            difference.append("The classes are equal");
            return;
        }
        difference.append("Different methods: ");
        writeDifferentMethods(firstClass, secondClass);
        writeDifferentMethods(secondClass, firstClass);
        difference.append("\n");
        difference.append("Different fields: ");
        writeDifferentFields(firstClass, secondClass);
        writeDifferentFields(secondClass, firstClass);
    }

    /**
     * Writes different methods
     * @param firstClass to compare
     * @param secondClass to compare
     */
    private void writeDifferentMethods(Class<?> firstClass, Class<?> secondClass) {
        Method[] firstMethods = firstClass.getDeclaredMethods();
        Method[] secondMethods = secondClass.getDeclaredMethods();
        boolean isEqual;
        for (int i = 0; i < firstMethods.length; i++) {
            isEqual = false;
            for (Method secondMethod : secondMethods) {
                if (areMethodsEqual(firstMethods[i], secondMethod)) {
                    isEqual = true;
                }
            }
            if (!isEqual) {
                difference.append("'").append(Modifier.toString(firstMethods[i].getModifiers())).append(" ")
                        .append(firstMethods[i].getReturnType()).append(" ")
                        .append(firstMethods[i].getName()).append("' ");
            }
        }
    }

    /**
     * Writes different fields
     * @param firstClass to compare
     * @param secondClass to compare
     */
    private void writeDifferentFields(Class<?> firstClass, Class<?> secondClass) {
        Field[] firstFields = firstClass.getDeclaredFields();
        Field[] secondFields = secondClass.getDeclaredFields();
        boolean isEqual;
        for (int i = 0; i < firstFields.length; i++) {
            isEqual = false;
            for (Field secondField : secondFields) {
                if (areFieldsEqual(firstFields[i], secondField)) {
                    isEqual = true;
                }
            }
            if (!isEqual && !firstFields[i].getType().getSimpleName().equals("Main")) {
                difference.append("'").append(firstFields[i].getType().getSimpleName()).append(" ")
                        .append(firstFields[i].getName()).append("' ");
            }
        }
    }
}
