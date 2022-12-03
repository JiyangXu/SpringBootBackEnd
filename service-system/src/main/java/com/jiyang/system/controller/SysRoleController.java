package com.jiyang.system.controller;

import com.jiyang.common.result.Result;
import com.jiyang.model.system.SysRole;
import com.jiyang.system.service.SysRoleService;
import com.jiyang.system.service.impl.SysRoleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Role Management API")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService = new SysRoleServiceImpl();

    @ApiOperation("Soft Delete")
    @DeleteMapping("remove/{id}")
    public Result removeRole(@PathVariable String id){
        boolean isSuccess = sysRoleService.removeById(id);
        if(isSuccess)
            return Result.ok();
        return Result.fail();
    }

    @ApiOperation("Find All")
    @GetMapping("findAll")
    public Result findAllRole(){
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }

}
