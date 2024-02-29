package com.zcw.springvalidationdemo.controller;

import com.zcw.springvalidationdemo.ResultHandle.Result;
import com.zcw.springvalidationdemo.pojo.dto.UserDTO;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分组校验
 */
@RequestMapping("/group")
@RestController
@Validated
@Api("分组校验")
public class GroupVaildatorController {

    /**
     * 保存是使用save校验分组
     * @param userDTO
     * @return
     */
    @PostMapping("/save")
    public Result saveUser(@RequestBody @Validated(UserDTO.Save.class) UserDTO userDTO) {
        // 校验通过，才会执行业务逻辑处理
        System.out.println("[save]" + userDTO);
        //[save]UserDTO(userId=123, userName=xixi, account=123456, password=123456789, job=null)
        return Result.ok();
    }
    /**
     * 更新是使用update校验分组
     * @param userDTO
     * @return
     */
    @PostMapping("/update")
    public Result updateUser(@RequestBody @Validated(UserDTO.Update.class) UserDTO userDTO) {
        // 校验通过，才会执行业务逻辑处理
        System.out.println("[update]" + userDTO);
        return Result.ok();
        //响应:
        //{
        //    "code": 500,
        //    "msg": "失败",
        //    "exceptionMsg": "校验失败:userId：最小不能小于10000000000000000, ",
        //    "body": null
        //}

    }
}
