package com.brent.comparison.models;

public enum ClassNameConstants {
    Arrays("java.util.Arrays.ArrayList"),
    ArrayList("java.util.ArrayList"),
    List("java.util.List"),
    HashSet("java.util.HashMap"),
    LinkedHashSet("java.util.LinkedHashMap");

    private String classNameDefinition;

    ClassNameConstants(String classNameDefinition) {
        this.classNameDefinition = classNameDefinition;
    }

    public String getClassNameDefinition() {
        return classNameDefinition;
    }

    public static boolean isArrayClass(String className) {
        return Arrays.getClassNameDefinition().equals(className) || ArrayList.getClassNameDefinition().equals(className) || List.getClassNameDefinition().equals(className);
    }
}
