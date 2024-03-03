package com.zcw.springvalidationdemo.base.Vaildation;

import com.zcw.springvalidationdemo.pojo.TaskForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EndDateAfterStartDateValidator implements ConstraintValidator<EndDateAfterStartDate, TaskForm>  {
    @Override
    public void initialize(EndDateAfterStartDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TaskForm taskForm, ConstraintValidatorContext context) {
        if (taskForm.getStartDate() == null || taskForm.getEndDate() == null) {
            return true;
        }
//        System.out.println("taskForm.getEndDate().isAfter(taskForm.getStartDate()) = " + taskForm.getEndDate().isAfter(taskForm.getStartDate()));
        // false
        // 如果起始终止时间都有
        return taskForm.getEndDate().isAfter(taskForm.getStartDate());
    }
}
