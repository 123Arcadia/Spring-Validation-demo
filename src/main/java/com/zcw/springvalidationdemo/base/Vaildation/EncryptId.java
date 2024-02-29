package com.zcw.springvalidationdemo.base.Vaildation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义加密id（由数字或者a-f的字母组成，32-256长度）校验
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {EncryptIdValidator.class})
public @interface EncryptId {
    /**
     * 是否强制校验
     *
     * @return 是否强制校验的boolean值
     */
    boolean required() default true;

    String message() default "加密id格式错误";

    Class<?>[] groups() default {};
    /**
     * 主要是针对bean，很少使用
     *
     * @return 负载
     */
    Class<? extends Payload>[] payload() default {};
}