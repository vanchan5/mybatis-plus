package com.baomidou.mybatisplus.test.web.rest;

import com.baomidou.mybatisplus.test.web.service.ISysRolesService;
import com.baomidou.mybatisplus.test.web.po.SysRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author wanchenghuang
 * @since 2020-12-19
 */
@RestController
@RequestMapping("/sys-roles")
//@Tag(name = "角色表")
public class SysRolesController {

    @Autowired
    private ISysRolesService service;

    /**
     * 根据id查询角色信息
     * @param id
     * @return
     */
    @GetMapping("/getRoleById/{id}")
    //@Operation(summary = "根据id查询角色信息")
    public SysRoles getRoleById(@PathVariable Long id){

        return service.getRoleById(id);
    }


}

