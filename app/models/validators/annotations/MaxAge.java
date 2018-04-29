package models.validators.annotations;


import models.validators.MaxAgeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MaxAgeValidator.class)
@Documented
public @interface MaxAge {

    String message() default "Too old";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int value();
}
