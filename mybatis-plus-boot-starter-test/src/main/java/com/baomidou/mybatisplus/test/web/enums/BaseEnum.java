package com.baomidou.mybatisplus.test.web.enums;

/**
 * @Author vanchan
 * @Date 2022/8/22 11:00
 * @Version 1.0
 * <p>
 * description：
 */
public interface BaseEnum<T> {

    T getValue();

    String getLabel();

    String getKey();

}
