package com.baomidou.mybatisplus.test.web.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
//import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : cheng
 * @version : V0.1
 * @Description: 实体基类
 *
 * @since 2020/12/18 21:14
 */
@Data
public class BasePo implements Serializable {

    /**
     * 创建时间
     */
    //@Schema(description = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime crtTime;

    /**
     * 创建host
     */
    //@Schema(description = "创建host")
    @TableField(fill = FieldFill.INSERT)
    private String crtHost;

    /**
     * 创建人名字
     */
    //@Schema(description = "创建人名字")
    @TableField(fill = FieldFill.INSERT)
    private String crtName;

    /**
     * 创建人Id
     */
    //@Schema(description = "创建人Id")
    @TableField(fill = FieldFill.INSERT)
    private String crtUser;

    /**
     * 更新时间
     */
    //@Schema(description = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updTime;

    /**
     * 更新host
     */
    //@Schema(description = "更新host")
    @TableField(fill = FieldFill.INSERT)
    private String updHost;

    /**
     * 更新人
     */
    //@Schema(description = "更新人")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updName;

    /**
     * 更新人Id
     */
    //@Schema(description = "更新人Id")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updUser;

    /**
     * 是否有效，'1' --有效
     */
    //@Schema(description = "是否有效，'1' --有效")
    @TableField(fill = FieldFill.INSERT)
    private String enabled;

    /**
     * 删除标志 默认'0'
     */
    //@Schema(description = "删除标志 默认'0'")
    @TableLogic
    private String delFlag;
}
