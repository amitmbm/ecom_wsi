package com.wsi.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = UserRegisterStatusValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD  })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUserRegisterStatus {

    String message() default "{ValidUserRegisterStatus}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}