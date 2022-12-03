package com.jiyang.system.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jiyang.model.system.SysRole;
import com.jiyang.system.service.SysRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SysRoleServiceTest {
    @Autowired
    private SysRoleService sysRoleService;
    
    @Test
    public void findAll(){
        List<SysRole> list = sysRoleService.list();
        System.out.println(list);
    }

    @Test
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("super admin");
        sysRole.setRoleCode("role");
        sysRole.setDescription("super admin");
        sysRoleService.save(sysRole);
    }

    @Test
    public void update(){
        SysRole sysRole = sysRoleService.getById(8);
        sysRole.setRoleCode("common");
        sysRoleService.updateById(sysRole);
    }

    @Test
    public void remove(){
       sysRoleService.removeById(8);
    }

    @Test
    public void select(){
        QueryWrapper queryWrapper = new QueryWrapper();

        queryWrapper.eq("role_code","common");
        List list = sysRoleService.list(queryWrapper);
        System.out.println(list);
    }
}
