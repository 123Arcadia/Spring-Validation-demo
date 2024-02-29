package com.zcw.springvalidationdemo.controller;

import com.zcw.springvalidationdemo.ResultHandle.Result;
import com.zcw.springvalidationdemo.pojo.dto.UserDTO;
import io.swagger.annotations.Api;
import org.apache.catalina.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * 没人校验完成才返回，如果我们想一旦校验失败就返回
 *
 *
 */
@RestController
@Validated
@Api("fail-fast校验")
public class FailFastController {

    @PostMapping("/failfast")
    public Result getFailfast(@RequestBody @Validated(UserDTO.Save.class) UserDTO userDTO) {
        // 校验通过，才会执行业务逻辑处理
        System.out.println("[fail-fast]userDTO = " + userDTO);
        return Result.ok(userDTO);
    }
}
