package com.baomidou.mybatisplus.test.web;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Author vanchan
 * @Date 2022/9/23 11:24
 * @Version 1.0
 * <p>
 * description：
 */
public interface ISysRolesService extends IService<SysRoles> {

    /**
     * 根据id查询角色信息
     *
     * @param id
     * @return
     */
    SysRoles getRoleById(Long id);
}
