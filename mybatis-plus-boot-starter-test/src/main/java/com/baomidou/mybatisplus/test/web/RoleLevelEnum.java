package com.baomidou.mybatisplus.test.web;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author : cheng
 * @version : V0.1
 * @Description: 系统类型
 * @since 2020/12/19 15:17
 */
@Getter
public enum RoleLevelEnum {
    SUPER_ADMINISTRATOR(1,"超级管理员"),
    FINANCIAL_AFFAIRS(2,"财务"),
    OPERATION(3,"运营"),
    CUSTOMER_SERVICE(4,"客服"),
    ;

    @EnumValue
    private Integer code;

    //@JsonValue
    //使用这个注解，在保存的时候，前端需要传递@JsonValue标记的枚举类属性的值，即"超级管理员/财务/运营/客服"
    private String name;

    RoleLevelEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    //重写toString方法，返回值为显示的值,使用@EnumValue下面2种返回结果都可以，传入的值mp处理了
    //用enum接收前端传过来的值，可以传0，1，2,3也可以SUPER_ADMINISTRATOR。。。等
    @Override
    public String toString() {
        return this.name() + "_" + this.name;
        //return this.name();
    }

    public static String value(String name){
        return name;
    }

    //通过Id获取结果
    public static RoleLevelEnum fromCode(Integer code) {
        for (RoleLevelEnum type : RoleLevelEnum.values()) {
            if (type.getCode() == code)
                return type;
        }
        return null;
    }

    //通过名称来获取结果
    public static RoleLevelEnum fromName(String name) {
        for (RoleLevelEnum type : RoleLevelEnum.values()) {
            if (type.getName().equals(name))
                return type;
        }
        return null;
    }

    //通过name获取结果
    public static RoleLevelEnum fromEnumName(String name) {
        for (RoleLevelEnum validCodeEnum : RoleLevelEnum.values()) {
            if (validCodeEnum.name().equals(name))
                return validCodeEnum;
        }
        return null;
    }


}
