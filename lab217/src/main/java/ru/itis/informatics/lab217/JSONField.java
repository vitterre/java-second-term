package ru.itis.informatics.lab217;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JSONField {
	public final static String USE_DEFAULT_NAME = "";
	String value() default USE_DEFAULT_NAME;
}
