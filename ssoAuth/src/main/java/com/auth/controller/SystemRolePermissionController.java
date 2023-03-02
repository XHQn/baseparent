package com.auth.controller;

import com.auth.pojo.PermissionRoleDTO;
import com.baseCommon.controller.BaseController;
import com.baseCommon.entity.PageResult;
import com.baseCommon.entity.Result;
import com.baseCommon.entity.ResultCode;
import com.baseCommon.exception.CommonException;
import com.auth.service.SystemRolePermissionService;
import com.auth.pojo.SystemRolePermission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//解决跨域问题
@CrossOrigin
@RestController
@Api(value = "systemRolePermission", tags = "用户管理")
@RequestMapping(value="/systemRolePermission")
public class SystemRolePermissionController extends BaseController {

    @Autowired
    private SystemRolePermissionService systemRolePermissionService;

    //保存
    @ApiOperation("自动生成：保存实体")
    @RequestMapping(value="",method = RequestMethod.POST)
    public Result insert(@RequestBody SystemRolePermission systemRolePermission)  {
        //业务操作
        systemRolePermissionService.insert(systemRolePermission);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id更新
    @ApiOperation("自动生成：根据id更新实体")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value="id") String id, @RequestBody SystemRolePermission systemRolePermission ) {
        //业务操作
//        systemRolePermission.setId(id);
        systemRolePermissionService.update(systemRolePermission);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id删除
    @ApiOperation("自动生成：根据id删除实体")
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value="id") String id) {
        systemRolePermissionService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id查询
    @ApiOperation("自动生成：根据id查询实体")
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value="id") String id) throws CommonException {
        SystemRolePermission systemRolePermission = systemRolePermissionService.selectById(id);
        return new Result(ResultCode.SUCCESS,systemRolePermission);
    }

    //查询全部
    @ApiOperation("自动生成：根据条件查询实体列表")
    @RequestMapping(value="/selectList",method = RequestMethod.POST)
    public Result selectList(@RequestParam(name = "pageSize") Integer pageSize, @RequestParam(name = "page") Integer page,@RequestBody SystemRolePermission systemRolePermission) {
        PageResult<SystemRolePermission> pageResult = systemRolePermissionService.selectList(pageSize,page,systemRolePermission);
        Result result = new Result(ResultCode.SUCCESS,pageResult);
        return result;
    }

    //查询全部
    @ApiOperation("自动生成：查询全部实体列表")
    @RequestMapping(value="",method = RequestMethod.GET)
    public Result selectAll() {
        List<SystemRolePermission> list = systemRolePermissionService.selectAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
        }
        //修改
    @ApiOperation("自动生成：修改Permission实体,重构RolePermisssion实体")
    @RequestMapping(value="/savePermissionRole",method = RequestMethod.POST)
    public Result savePermissionRole(@RequestBody PermissionRoleDTO permissionRoleDTO)
    {
        int result = systemRolePermissionService.savaPermissionAndRole(permissionRoleDTO);
        if(result==0)
        {
            return new Result(ResultCode.FAIL);
        }
        return new Result(ResultCode.SUCCESS);
    }

}
