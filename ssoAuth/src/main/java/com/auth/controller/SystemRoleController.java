package com.auth.controller;

import com.auth.pojo.PermissionRoleDTO;
import com.auth.pojo.RolePermissionDTO;
import com.auth.pojo.SystemUserRole;
import com.baseCommon.controller.BaseController;
import com.baseCommon.entity.PageResult;
import com.baseCommon.entity.Result;
import com.baseCommon.entity.ResultCode;
import com.baseCommon.exception.CommonException;
import com.auth.service.SystemRoleService;
import com.auth.pojo.SystemRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//解决跨域问题
@CrossOrigin
@RestController
@Api(value = "systemRole", tags = "用户管理")
@RequestMapping(value="/systemRole")
public class SystemRoleController extends BaseController {

    @Autowired
    private SystemRoleService systemRoleService;

    //保存
    @ApiOperation("自动生成：保存实体")
    @RequestMapping(value="",method = RequestMethod.POST)
    public Result insert(@RequestBody SystemRole systemRole)  {
        //业务操作
        systemRoleService.insert(systemRole);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id更新
    @ApiOperation("自动生成：根据id更新实体")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value="id") String id, @RequestBody SystemRole systemRole ) {
        //业务操作
        systemRole.setId(id);
        systemRoleService.update(systemRole);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id删除
    @ApiOperation("自动生成：根据id删除实体")
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value="id") String id) {
        systemRoleService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id查询
    @ApiOperation("自动生成：根据id查询实体")
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value="id") String id) throws CommonException {
        SystemRole systemRole = systemRoleService.selectById(id);
        return new Result(ResultCode.SUCCESS,systemRole);
    }

    //查询全部
    @ApiOperation("自动生成：根据条件查询实体列表")
    @RequestMapping(value="/selectList",method = RequestMethod.POST)
    public Result selectList(@RequestParam(name = "pageSize") Integer pageSize, @RequestParam(name = "page") Integer page,@RequestBody SystemRole systemRole) {
        PageResult<SystemRole> pageResult = systemRoleService.selectList(pageSize,page,systemRole);
        Result result = new Result(ResultCode.SUCCESS,pageResult);
        return result;
    }

    //查询全部
    @ApiOperation("自动生成：查询全部实体列表")
    @RequestMapping(value="",method = RequestMethod.GET)
    public Result selectAll() {
        List<SystemRole> list = systemRoleService.selectAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
        }
        //修改
    @ApiOperation("根据roleId查询Permission")
    @RequestMapping(value="/selectRolePermission/{roleId}",method = RequestMethod.GET)
    public Result selectRolePermission(@PathVariable String roleId)
    {
        RolePermissionDTO rolePermissionDTO = systemRoleService.selectRolePermission(roleId);
        Result result=new Result(ResultCode.SUCCESS);
        result.setData(rolePermissionDTO);
        return result;
    }
    @ApiOperation("修改Role实体,重构RolePermisssion实体")
    @RequestMapping(value="/savePermissionRole",method = RequestMethod.POST)
    public Result saveRolePermission(@RequestBody RolePermissionDTO rolePermissionDTO)
    {
        int result = systemRoleService.savaRoleAndPermission(rolePermissionDTO);
        if(result==0)
        {
            return new Result(ResultCode.FAIL);
        }
        return new Result(ResultCode.SUCCESS);
    }
    //修改
    @ApiOperation("根据roleId删除role实体和rolePermission实体")
    @RequestMapping(value="/deleteRolePermission/{roleId}",method = RequestMethod.DELETE)
    public Result deleteRolePermission(@PathVariable String roleId)
    {
        int result=systemRoleService.deleteRoleAndPermission(roleId);
        if(result==0)
        {
            return new Result(ResultCode.FAIL);
        }
        return new Result(ResultCode.SUCCESS);
    }
    //修改
    @ApiOperation("用户角色保存实体")
    @RequestMapping(value="/insertRolePermission",method = RequestMethod.POST)
    public Result insertRolePermission(@RequestBody RolePermissionDTO rolePermissionDTO)
    {
        int result = systemRoleService.insertRoleAndPermission(rolePermissionDTO);
        if(result==0)
        {
            return new Result(ResultCode.FAIL);
        }
        return new Result(ResultCode.SUCCESS);
    }
}
