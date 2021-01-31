package com.springdatajpa.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueMovieTitleValidator.class)
@Target({ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface UniqueMovieTitle {
    String message() default "Movie title should be unique";
    Class<?> groups();
    Class<? extends Payload> payload();
}
