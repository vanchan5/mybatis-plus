package com.baomidou.mybatisplus.test.web.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.test.web.enums.RoleLevelEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;


/**
 * <p>
 * 角色表
 * </p>
 *
 * @author wanchenghuang
 * @since 2020-12-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
//@Schema(name = "SysRoles对象", description = "角色表")
public class SysRoles extends BasePo {

    private static final long serialVersionUID = 1L;

    //@Schema(description = "id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private Long id;

    /**
     * 角色名 以ROLE_开头
     */
    //@Schema(description = "角色名 以ROLE_开头")
    private String name;

    /**
     * 是否为注册默认角色
     */
    //@Schema(description = "是否为注册默认角色")
    private Boolean defaultRole;

    /**
     * 备注
     */
    //@Schema(description = "备注")
    private String description;

    /**
     * 数据权限类型 0全部默认 1自定义
     */
    //@Schema(description = "数据权限类型 0全部默认 1自定义")
    private Integer dataType;

    /**
     * 角色级别 1-超级管理员 2-财务 3-运营 4-客服等等
     */
    //@Schema(description = "角色级别 1-超级管理员 2-财务 3-运营 4-客服等等")
    private RoleLevelEnum level;

    /**
     * 系统类型 1-平台 2-商家
     */
    //@Schema(description = "系统类型 1-平台 2-商家")
    private Integer systemType;

    /**
     * 店铺ID
     */
    //@Schema(description = "店铺ID")
    private Long storeId;

    private BigDecimal price;

    @TableField("is_success_als")
    private Boolean successAls;


}
