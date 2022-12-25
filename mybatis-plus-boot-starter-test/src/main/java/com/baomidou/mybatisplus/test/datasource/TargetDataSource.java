package com.baomidou.mybatisplus.test.datasource;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author vanchan
 * @Date 2022/12/23 13:14
 * @Version 1.0
 * <p>
 * description：
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface TargetDataSource {
    String name();

}
