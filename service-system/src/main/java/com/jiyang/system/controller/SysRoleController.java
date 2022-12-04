package com.jiyang.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiyang.common.result.Result;
import com.jiyang.model.system.SysRole;
import com.jiyang.model.vo.SysRoleQueryVo;
import com.jiyang.system.exception.CustomException;
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

    //Final Edit
    @ApiOperation("")
    @PostMapping("update")
    public Result updateRole(@RequestBody SysRole sysRole){
        boolean isSuccess = sysRoleService.updateById(sysRole);
        if(isSuccess)
            return Result.ok();
        return Result.fail();
    }

    @ApiOperation("Bulk Delete")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<String> ids){
        sysRoleService.removeByIds(ids);
        return Result.ok();
    }

    @ApiOperation("FindByID")
    @PostMapping("dindRoleById/{id}")
    public Result findRoleById(@PathVariable String id){
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }

    //Add
    //RequestBody cannot use get
    //pass json data, enclose json to an object
    @ApiOperation("Add Role")
    @PostMapping("save")
    public Result saveRole(@RequestBody SysRole sysRole){
        boolean isSuccess = sysRoleService.save(sysRole);
        if(isSuccess)
            return Result.ok();
        return Result.fail();
    }

    //conditional page search
    /*
     *  page is current page
     *  limit is maximum number in one page
     * */
    @ApiOperation("Paging Search")
    @GetMapping("{page}/{limit}")
    public Result findPageQueryRole(@PathVariable Long page, @PathVariable Long limit, SysRoleQueryVo sysRoleQueryVo) {
        Page<SysRole> pageParam = new Page<>(page,limit);
        IPage<SysRole> pageModel =sysRoleService.selectPage(pageParam,sysRoleQueryVo);

        return Result.ok(pageModel);
    }

    @ApiOperation("Soft Delete")
    @DeleteMapping("remove/{id}")
    public Result removeRole(@PathVariable String id) {
        boolean isSuccess = sysRoleService.removeById(id);
        if (isSuccess)
            return Result.ok();
        return Result.fail();
    }

    @ApiOperation("Find All")
    @GetMapping("findAll")
    public Result findAllRole() {
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }

}
