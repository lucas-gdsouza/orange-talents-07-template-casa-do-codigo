package br.com.zupacademy.cdc.validations.annotations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GenericUniqueElementValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GenericUniqueElement {
    String message() default "{br.com.zupacademy.cdc.validations.annotations.GenericUniqueElementValidator}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}