package com.jiyang.system.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jiyang.model.system.SysRole;
import com.jiyang.system.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class SysRoleMapperTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Test
    public void testDelete(){
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name","BA");

        sysRoleMapper.delete(wrapper);
    }

    @Test
    public void testSelect(){

        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("role_name","user manager");
        wrapper.like("role_name","BA");
        List<SysRole> sysRoles= sysRoleMapper.selectList(wrapper);
        System.out.println(sysRoles);
    }

    @Test
    public void testBatchDelete(){
         sysRoleMapper.deleteBatchIds(Arrays.asList(1, 2, 3));
    }

    @Test
    public void deleteId(){
        int rows = sysRoleMapper.deleteById(2);
    }

    @Test
    public void update(){
        SysRole sysRole = sysRoleMapper.selectById(2);

        sysRole.setDescription("System Admin");

        sysRoleMapper.updateById(sysRole);
    }

    @Test
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("BA");
        sysRole.setRoleCode("BusinessAnalyst");
        sysRole.setDescription("Bussiness Analyst");
        int rows = sysRoleMapper.insert(sysRole);
        System.out.println(rows);
    }

    @Test
    public void findAll(){
        List<SysRole> list= sysRoleMapper.selectList(null);
        for(SysRole sysRole:list){
            System.out.println(sysRole);
        }
    }
}
