package com.zcw.springvalidationdemo.pojo;

import com.zcw.springvalidationdemo.base.Vaildation.EndDateAfterStartDate;
import com.zcw.springvalidationdemo.base.Vaildation.UniqueTitle;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;



@Data
@EndDateAfterStartDate
public class TaskForm {

    @NotEmpty
    @Length(max = 10)
    @UniqueTitle
    private String title;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;


    public interface first {
    }
}
