package models.validators;


import models.validators.annotations.MaxAge;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;

public class MaxAgeValidator implements ConstraintValidator<MaxAge, Integer> {

    private int value;
    private String message;

    @Override
    public void initialize(MaxAge constraintAnnotation) {
        this.value = Math.abs(constraintAnnotation.value());
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Integer value, final ConstraintValidatorContext context) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        return (currentYear - value) <= this.value && currentYear >= value;
    }
}