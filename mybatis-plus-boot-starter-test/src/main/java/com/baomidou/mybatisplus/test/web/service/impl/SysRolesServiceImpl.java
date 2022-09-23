package com.baomidou.mybatisplus.test.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.test.web.mapper.SysRolesMapper;
import com.baomidou.mybatisplus.test.web.po.SysRoles;
import com.baomidou.mybatisplus.test.web.service.ISysRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author vanchan
 * @Date 2022/9/23 11:25
 * @Version 1.0
 * <p>
 * description：
 */
@Service
public class SysRolesServiceImpl extends ServiceImpl<SysRolesMapper, SysRoles> implements ISysRolesService {


    @Autowired
    private SysRolesMapper mapper;

    @Override
    public SysRoles getRoleById(Long id) {
        SysRoles sysRole = mapper.selectById(id);
        return sysRole != null ? sysRole : new SysRoles();
    }
}
