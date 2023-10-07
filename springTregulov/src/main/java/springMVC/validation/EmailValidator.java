package springMVC.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {

    public String emailEnd;

    @Override
    public void initialize(Email emailValue) {


        emailEnd = emailValue.value();
    }

    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext constraintValidatorContext) {

        System.out.println(enteredValue);
        System.out.println(emailEnd);
        return enteredValue.endsWith(emailEnd);
    }
}
