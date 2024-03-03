package com.zcw.springvalidationdemo.base.Vaildation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 跨域验证
 * <p>
 * 假设我们有一个表单，用户可以在其中输入任务的开始日期和结束日期，并且我们希望确保结束日期不早于开始日期。我们可以使用跨域验证来实现这一点
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EndDateAfterStartDateValidator.class)
public @interface EndDateAfterStartDate {
    String message() default "End date must be after start date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}