package eu.lukoszek.insurance.car;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CarRegNumberValidator.class)
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface RegNumberConstraint {
    String message() default "Niepoprawny numer rejestracyjny";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}