package com.zcw.springvalidationdemo.pojo;

import lombok.experimental.Delegate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public class VaildatorList<E> implements List<E> {
    @Delegate
    @Valid
    public List<E> list = new ArrayList<>();

    @Override
    public String toString() {
        return list.toString();
    }
}
