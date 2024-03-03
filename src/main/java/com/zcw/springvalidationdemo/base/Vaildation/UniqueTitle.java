package com.zcw.springvalidationdemo.base.Vaildation;

/**
 * 自定义唯一性的校验
 */

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueTitleValidator.class)
public @interface UniqueTitle {
    String message() default "Title must be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}