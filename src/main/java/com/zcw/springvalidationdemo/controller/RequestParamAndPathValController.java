package com.zcw.springvalidationdemo.controller;


import com.zcw.springvalidationdemo.ResultHandle.Result;
import com.zcw.springvalidationdemo.pojo.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * requestParam/PathVariable参数校验
 *
 * 必须在类上加 @Validated
 */
@RequestMapping("/user")
@RestController
@Validated
@Api("参数管理")
public class RequestParamAndPathValController {

    // 路径变量: userId最小不能低于100
    @GetMapping("{userId}")
    public Result detail(@PathVariable("userId") @Min(100) Long userId) {
        // 校验通过，才会执行业务逻辑处理
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setAccount("11111111111111111");
        userDTO.setUserName("xixi");
        userDTO.setAccount("11111111111111111");
        System.out.println("userDTO = " + userDTO);
        return Result.ok(userDTO);
    }

    // 查询参数http://127.0.0.1:8080/user/getByAccount?account=123456
    @GetMapping("getByAccount")
    public Result getByAccount(@Length(min = 6, max = 20) @NotNull String  account) {
        // 校验通过，才会执行业务逻辑处理
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(10000000000000003L);
        userDTO.setAccount(account);
        userDTO.setUserName("xixi");
        System.out.println("[getByAccount]userDTO = " + userDTO);
        return Result.ok(userDTO);
    }
}
