package com.auth.controller;

import com.auth.pojo.PermissionRoleDTO;
import com.auth.pojo.PermissionUserDTO;
import com.auth.pojo.ResponseResult;
import com.baseCommon.controller.BaseController;
import com.baseCommon.entity.PageResult;
import com.baseCommon.entity.Result;
import com.baseCommon.entity.ResultCode;
import com.baseCommon.exception.CommonException;
import com.auth.service.SystemPermissionService;
import com.auth.pojo.SystemPermission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//解决跨域问题
@CrossOrigin
@RestController
@Api(value = "systemPermission", tags = "用户管理")
@RequestMapping(value="/systemPermission")
public class SystemPermissionController extends BaseController {

    @Autowired
    private SystemPermissionService systemPermissionService;

    //保存
    @ApiOperation("自动生成：保存实体")
    @RequestMapping(value="",method = RequestMethod.POST)
    public Result insert(@RequestBody SystemPermission systemPermission)  {
        //业务操作
        systemPermissionService.insert(systemPermission);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id更新
    @ApiOperation("自动生成：根据id更新实体")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value="id") String id, @RequestBody SystemPermission systemPermission ) {
        //业务操作
        systemPermission.setId(id);
        systemPermissionService.update(systemPermission);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id删除
    @ApiOperation("自动生成：根据id删除实体")
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value="id") String id) {
        systemPermissionService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id查询
    @ApiOperation("自动生成：根据id查询实体")
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value="id") String id) throws CommonException {
        SystemPermission systemPermission = systemPermissionService.selectById(id);
        return new Result(ResultCode.SUCCESS,systemPermission);
    }

    //查询全部
    @ApiOperation("自动生成：根据条件查询实体列表")
    @RequestMapping(value="/selectList",method = RequestMethod.POST)
    public Result selectList(@RequestParam(name = "pageSize") Integer pageSize, @RequestParam(name = "page") Integer page,@RequestBody SystemPermission systemPermission) {
        PageResult<SystemPermission> pageResult = systemPermissionService.selectList(pageSize,page,systemPermission);
        Result result = new Result(ResultCode.SUCCESS,pageResult);
        return result;
    }

    //查询全部
    @ApiOperation("自动生成：查询全部实体列表")
    @RequestMapping(value="",method = RequestMethod.GET)
    public Result selectAll() {
        List<SystemPermission> list = systemPermissionService.selectAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
        }
        //修改过
    @ApiOperation("自动生成：根据Permission的id查询和Role的实体列表")
    @RequestMapping(value="/selectPermissionRole/{id}",method = RequestMethod.GET)
    public Result selectPermissionRole(@PathVariable(value="id") String id) {
        PermissionRoleDTO permissionRoleDTO = systemPermissionService.selectPermisssionAndRole(id);
        if(permissionRoleDTO == null)
        {
            return new Result(ResultCode.FAIL);
        }
        Result result=new Result(ResultCode.SUCCESS);
        result.setData(permissionRoleDTO);
        return result;
    }

    /**
     * 删除Permission实体和对应的PermissionRole
     * @param id
     * @return
     */
    //修改过
    @ApiOperation("自动生成：根据id删除Permission实体和对应的PermissionRole")
    @RequestMapping(value="/deleteByIdPermission/{id}",method = RequestMethod.DELETE)
    public Result deleteByIdPermission(@PathVariable(value="id") String id) {
        int result=systemPermissionService.deleteByIdRolePermission(id);
        if(result==0)
        {
            return new Result(ResultCode.FAIL);
        }

        return new Result(ResultCode.SUCCESS);
    }
    //修改过
    @ApiOperation("自动生成：根据userId查询Permission")
    @RequestMapping(value="/userIdSelectPermission/{id}",method = RequestMethod.GET)
    public Result userIdSelectPermission(@PathVariable(value="id") String UserId) {
        PermissionUserDTO permissionUserDTOs =systemPermissionService.selectUserIdAndPermission(UserId);
        Result result = new Result(ResultCode.SUCCESS);

        result.setData(permissionUserDTOs);
        return result;
}}
