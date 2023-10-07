package springMVC.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
public @interface Email {

    public String value() default "@gmail.com";

    public String message() default "Должно быть @gmail.com почтой";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
