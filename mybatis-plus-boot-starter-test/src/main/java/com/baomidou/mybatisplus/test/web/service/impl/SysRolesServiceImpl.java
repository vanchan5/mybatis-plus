package com.baomidou.mybatisplus.test.web.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.test.web.mapper.SysRolesMapper;
import com.baomidou.mybatisplus.test.web.po.SysRoles;
import com.baomidou.mybatisplus.test.web.service.ISysRolesService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author vanchan
 * @Date 2022/9/23 11:25
 * @Version 1.0
 * <p>
 * description：
 */
@Service
@DS("slave1")
public class SysRolesServiceImpl extends ServiceImpl<SysRolesMapper, SysRoles> implements ISysRolesService {


    @Autowired
    private SysRolesMapper mapper;

    @Override
    public SysRoles getRoleById(Long id) {
        //SysRoles sysRole = mapper.selectById(id);
        SysRoles sysRoles = new SysRoles();
        sysRoles.setId(14L)
            .setDefaultRole(false)
            .setName("2")
            .setDataType(0)
            .setPrice(BigDecimal.ZERO)
            .setSuccessAls(true)
            .setStoreId(1L)
            .setSystemType(1)
            .setCrtTime(LocalDateTime.now());
        sysRoles.setUpdTime(LocalDateTime.now());
        sysRoles.setCrtUser("2");
        sysRoles.setUpdUser("2");
        mapper.insert(sysRoles);


        SysRoles sysRole = mapper.selectByIds(id);
        return sysRole;
    }
}
