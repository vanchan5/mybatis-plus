package com.baomidou.mybatisplus.test.web.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : cheng
 * @version : V0.1
 * @Description: 系统类型
 * @since 2020/12/19 15:17
 */
@RequiredArgsConstructor
@AllArgsConstructor
public enum RoleLevelEnum implements BaseEnum<Integer>{

    SUPER_ADMINISTRATOR(1,"超级管理员"),
    FINANCIAL_AFFAIRS(2,"财务"),
    OPERATION(3,"运营"),
    CUSTOMER_SERVICE(4,"客服"),

    ;

    @EnumValue
    @Getter
    private Integer value;

    //@JsonValue
    //使用这个注解，在保存的时候，前端需要传递@JsonValue标记的枚举类属性的值，即"超级管理员/财务/运营/客服"
    @Getter
    private String label;

    private static final Map<Integer, RoleLevelEnum> VALUE_MAP = Collections.unmodifiableMap(Arrays.stream(values()).collect(Collectors.toMap(RoleLevelEnum::getValue, Function.identity())));

    private static final Map<String, RoleLevelEnum> LABEL_MAP = Collections.unmodifiableMap(Arrays.stream(values()).collect(Collectors.toMap(RoleLevelEnum::getLabel, Function.identity())));

    public static Optional<RoleLevelEnum> lookup(final Integer value) {
        return Optional.ofNullable(VALUE_MAP.get(value));
    }

    public static Optional<RoleLevelEnum> lookupByLabel(final String label) {
        return Optional.ofNullable(LABEL_MAP.get(label));
    }

    //重写toString方法，返回值为显示的值,使用@EnumValue下面2种返回结果都可以，传入的值mp处理了
    //用enum接收前端传过来的值，可以传0，1，2,3也可以SUPER_ADMINISTRATOR。。。等
    @Override
    public String toString() {
        return this.name() + "_" + this.value;
        //return this.name();
    }

    @Override
    public String getKey() {
        return "roleLevelEnum";
    }
}
