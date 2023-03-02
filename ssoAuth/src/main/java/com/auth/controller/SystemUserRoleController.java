package com.auth.controller;

import com.auth.pojo.UserRoleDTO;
import com.auth.service.SystemUserService;
import com.baseCommon.controller.BaseController;
import com.baseCommon.entity.PageResult;
import com.baseCommon.entity.Result;
import com.baseCommon.entity.ResultCode;
import com.baseCommon.exception.CommonException;
import com.auth.service.SystemUserRoleService;
import com.auth.pojo.SystemUserRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//解决跨域问题
@CrossOrigin
@RestController
@Api(value = "systemUserRole", tags = "用户管理")
@RequestMapping(value="/systemUserRole")
public class SystemUserRoleController extends BaseController {
    @Autowired
    private SystemUserService systemUserService;
    @Autowired
    private SystemUserRoleService systemUserRoleService;

    //保存
    @ApiOperation("自动生成：保存实体")
    @RequestMapping(value="",method = RequestMethod.POST)
    public Result insert(@RequestBody SystemUserRole systemUserRole)  {
        //业务操作
        systemUserRoleService.insert(systemUserRole);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id更新
    @ApiOperation("自动生成：根据id更新实体")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value="id") String id, @RequestBody SystemUserRole systemUserRole ) {
        //业务操作
//        systemUserRole.setId(id);
        systemUserRoleService.update(systemUserRole);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id删除
    @ApiOperation("自动生成：根据id删除实体")
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value="id") String id) {
        systemUserRoleService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id查询
    @ApiOperation("自动生成：根据id查询实体")
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value="id") String id) throws CommonException {
        SystemUserRole systemUserRole = systemUserRoleService.selectById(id);
        return new Result(ResultCode.SUCCESS,systemUserRole);
    }

    //查询全部
    @ApiOperation("自动生成：根据条件查询实体列表")
    @RequestMapping(value="/selectList",method = RequestMethod.POST)
    public Result selectList(@RequestParam(name = "pageSize") Integer pageSize, @RequestParam(name = "page") Integer page,@RequestBody SystemUserRole systemUserRole) {
        PageResult<SystemUserRole> pageResult = systemUserRoleService.selectList(pageSize,page,systemUserRole);
        Result result = new Result(ResultCode.SUCCESS,pageResult);
        return result;
    }

    //查询全部
    @ApiOperation("自动生成：查询全部实体列表")
    @RequestMapping(value="",method = RequestMethod.GET)
    public Result selectAll() {
        List<SystemUserRole> list = systemUserRoleService.selectAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
        }

}
