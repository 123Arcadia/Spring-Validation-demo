package com.zcw.springvalidationdemo.base.ExceptionHandler;

import com.zcw.springvalidationdemo.ResultHandle.Result;
import com.zcw.springvalidationdemo.ResultHandle.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 *
 */
@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.toString();
       return Result.fail(ResultCode.FAIL, msg);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleConstraintViolationException(ConstraintViolationException ex) {
        return Result.fail(ResultCode.FAIL, ex.getMessage());
    }

    @ExceptionHandler({NotReadablePropertyException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleNotReadablePropertyException(NotReadablePropertyException ex) {
        return Result.fail(ResultCode.FAIL, ex.getMessage());
    }


    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleException(Exception ex) {
        System.out.println(ExceptionUtils.getStackTrace(ex));
        return Result.fail(ResultCode.EXCEPTION, ex.getMessage());
    }
}
