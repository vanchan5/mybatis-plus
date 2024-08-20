package com.baomidou.mybatisplus.test.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.test.web.po.SysRoles;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * <p>
 * 角色表 IBaseMapper 接口
 * </p>
 *
 * @author wanchenghuang
 * @since 2020-12-19
 */
public interface SysRolesMapper extends BaseMapper<SysRoles> {

    SysRoles selectByIds(@Param("id") Long id);
}
