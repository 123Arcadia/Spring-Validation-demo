package com.zcw.springvalidationdemo.base.Vaildation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Array;
import java.util.*;

public class UniqueTitleValidator implements ConstraintValidator<UniqueTitle, String> {

    private static final Set<String> uniqueTitles = new HashSet<>(Arrays.asList("mytitle"));
    /**
     * 如果 title 为 null 或唯一，则验证成功，并返回 true
     * @param title
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String title, ConstraintValidatorContext constraintValidatorContext) {
        if (title == null) {
            return true;
        }
        if (!uniqueTitles.contains(title)) {
        } else {
            return false;
        }
        return true;
//        // result表示数据库中是否已经存在该title
//        String result = "";
//        return StringUtils.isEmpty(result);
    }

    @Override
    public void initialize(UniqueTitle constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
