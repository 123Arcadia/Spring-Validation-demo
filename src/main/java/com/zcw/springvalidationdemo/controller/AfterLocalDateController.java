package com.zcw.springvalidationdemo.controller;

import com.zcw.springvalidationdemo.ResultHandle.Result;
import com.zcw.springvalidationdemo.pojo.TaskForm;
import com.zcw.springvalidationdemo.pojo.VaildatorList;
import com.zcw.springvalidationdemo.pojo.dto.UserDTO;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/timeAfter")
@ApiModel("跨域校验")
@Validated
public class AfterLocalDateController {
    /**
     * 提交表单：检查终止时间必须晚于起始时间
     * @param taskFormsList
     * @return
     */
    @PostMapping("/form")
    public Result saveList(@RequestBody @Valid VaildatorList<TaskForm> taskFormsList) {
        // 校验通过，才会执行业务逻辑处理
        System.out.println("[/timeAfter/form]" + taskFormsList);
        return Result.ok(taskFormsList);
    }
}
