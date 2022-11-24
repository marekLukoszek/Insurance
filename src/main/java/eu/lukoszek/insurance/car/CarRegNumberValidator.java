package eu.lukoszek.insurance.car;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarRegNumberValidator implements ConstraintValidator<RegNumberConstraint, String> {

    @Override
    public void initialize(RegNumberConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String registrationNumber, ConstraintValidatorContext constraintValidatorContext) {
        //zakładam, że poprawne rejestracje to tylko 2 lub 3 litery i 5 cyfr lub 4 cyfry i litera
        Pattern pattern = Pattern.compile("[A-Z]{2}[A-Z]?[0-9]{4}([A-Z|0-9])?");
        Matcher matcher = pattern.matcher(registrationNumber);
        return matcher.matches();
    }
}
