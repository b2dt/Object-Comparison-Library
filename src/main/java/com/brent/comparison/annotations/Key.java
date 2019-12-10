package com.brent.comparison.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
This annotation is REQUIRED for Lists of Objects.

This is an annotation for attributes. This annotation is required for array object comparison.
Use this annotation to show uniqueness of an Object in an array.

why?
Object 1 changes to Object 3
Object 2 changes to Object 2
Object 3 changes to Object 1

If i only compare the objects by their values, i wouldn't be able to detect that Object 1 became object 3, and object 3 became 1.
This/These keys should tell me that object 1 and object 3 were changed.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Key {
}
