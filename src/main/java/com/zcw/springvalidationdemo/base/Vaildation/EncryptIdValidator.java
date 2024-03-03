package com.zcw.springvalidationdemo.base.Vaildation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncryptIdValidator implements ConstraintValidator<EncryptId, String> {
    /**
     * 一个由32到256个大小写字母和数字组成的字符串，以字母a-f开头
     */
    private static final Pattern PATTERN = Pattern.compile("^[a-f\\d]{32,256}$");

    /**
     * 是否强制校验的boolean值；默认true
     */
    private boolean required;
    @Override
    public void initialize(EncryptId constraintAnnotation) {
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        // 不为null才进行校验
        System.out.println("value = " + value);
        if (required && value != null) {
            Matcher matcher = PATTERN.matcher(value);
            return matcher.find();
        }
        return true;
    }
}
