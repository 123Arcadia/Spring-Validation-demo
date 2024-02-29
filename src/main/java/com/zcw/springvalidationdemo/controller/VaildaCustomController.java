package com.zcw.springvalidationdemo.controller;

import com.zcw.springvalidationdemo.ResultHandle.Result;
import com.zcw.springvalidationdemo.pojo.VaildatorList;
import com.zcw.springvalidationdemo.pojo.dto.UserDTO;
import io.swagger.annotations.ApiModel;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 集合校验
 *
 * 如果请求体直接传递了json数组给后台，并希望对数组中的每一项都进行参数校验。此时，如果我们直接使用java.util.Collection下的list或者set来接收数据，参数校验并不会生效！
 * 我们可以使用自定义list集合来接收参数：
 */
@RestController
@RequestMapping("/custom")
@ApiModel("自定义校验")
public class VaildaCustomController {
    @PostMapping("/1")
    public Result custom01(@RequestBody @Validated UserDTO userDTO) {
        System.out.println("[custom01]" + userDTO);
        return Result.ok();
    }
}
