package com.wsi.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
 
@Documented
@Constraint(validatedBy = ImageValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ImageAnnotation {
  
      
    String message() default "{Image}";
      
    Class<?>[] groups() default {};
      
    Class<? extends Payload>[] payload() default {};
       
}