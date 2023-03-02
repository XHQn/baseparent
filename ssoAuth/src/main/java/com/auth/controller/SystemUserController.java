package com.auth.controller;

import com.auth.mapper.SystemUserMapper;
import com.auth.pojo.SystemUserRole;
import com.auth.pojo.UserRoleDTO;
import com.auth.service.SystemUserRoleService;
import com.baseCommon.controller.BaseController;
import com.baseCommon.entity.PageResult;
import com.baseCommon.entity.Result;
import com.baseCommon.entity.ResultCode;
import com.baseCommon.exception.CommonException;
import com.auth.service.SystemUserService;
import com.auth.pojo.SystemUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//解决跨域问题
@Slf4j
@CrossOrigin
@RestController
@Api(value = "systemUser", tags = "用户管理")
@RequestMapping(value="/systemUser")
public class SystemUserController extends BaseController {

    @Autowired
    private SystemUserMapper systemUserMapper;
    @Autowired
    private SystemUserService systemUserService;

    //保存
    @ApiOperation("自动生成：保存实体")
    @RequestMapping(value="",method = RequestMethod.POST)
    public Result insert(@RequestBody SystemUser systemUser)  {
        //业务操作
        systemUserService.insert(systemUser);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id更新
    @ApiOperation("自动生成：根据id更新实体")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value="id") String id, @RequestBody SystemUser systemUser ) {
        //业务操作
        systemUser.setId(id);
        systemUserService.update(systemUser);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id删除
    @ApiOperation("自动生成：根据id删除实体")
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value="id") String id) {
        systemUserService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id查询
    @ApiOperation("自动生成：根据id查询实体")
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value="id") String id) throws CommonException {
        SystemUser systemUser = systemUserService.selectById(id);
        return new Result(ResultCode.SUCCESS,systemUser);
    }

    //查询全部
    @ApiOperation("自动生成：根据条件查询实体列表")
    @RequestMapping(value="/selectList",method = RequestMethod.POST)
    public Result selectList(@RequestParam(name = "pageSize") Integer pageSize, @RequestParam(name = "page") Integer page,@RequestBody SystemUser systemUser) {
        PageResult<SystemUser> pageResult = systemUserService.selectList(pageSize,page,systemUser);
        Result result = new Result(ResultCode.SUCCESS,pageResult);
        return result;
    }

    //查询全部
    @ApiOperation("自动生成：查询全部实体列表")
    @RequestMapping(value="",method = RequestMethod.GET)
    public Result selectAll() {
        List<SystemUser> list = systemUserService.selectAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
    }
    //修改过
    @ApiOperation("自动生成：查询User和Role")
    @RequestMapping(value="/selectUserWRole",method = RequestMethod.GET)
    public Result selectUserWRole(@RequestParam(value = "userId") String userId)
    {
        UserRoleDTO userRoleDTO = systemUserService.selectUserandRole(userId);
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(userRoleDTO);
        return result;
    }
    //修改过
    @ApiOperation("自动生成：根据id删除实体并删除UserRole表")
    @RequestMapping(value="/deletes/{id}",method = RequestMethod.DELETE)
    public Result deletes(@PathVariable(value="id") String id) {
       int result = systemUserService.deleteByIdAndUserRole(id);
       if(result == 0)
       {
           return new Result(ResultCode.FAIL);
       }
        return new Result(ResultCode.SUCCESS);
    }
    //修改过
    @ApiOperation("前端传送一个UserId，修改密码，密码默认为123456")
    @RequestMapping(value="/updatePassword/{userId}",method = RequestMethod.PUT)
    public Result updatePassword(@PathVariable String userId)
    {
        int result=systemUserService.updateByPassword(userId);
        if(result==0)
        {
            return new Result(ResultCode.FAIL);
        }
        return new Result(ResultCode.SUCCESS);
    }
    //修改过
    @ApiOperation("前端传送UserId和status，修改状态")
    @RequestMapping(value="/updateStatus/{userId}/{status}",method = RequestMethod.PUT)
    public Result updateStatus(@PathVariable String userId,@PathVariable Integer status)
    {
        int result = systemUserService.updateByStatus(userId, status);
        if(result == 0)
        {
            return new Result(ResultCode.FAIL);
        }
        return new Result(ResultCode.SUCCESS);
    }
    //修改过
    @ApiOperation("自动生成：保存user和role")
    @RequestMapping(value="/saveUserWithRole",method = RequestMethod.POST)
    public Result saveUserWithRole(@RequestBody UserRoleDTO userRoleDTO)
    {

        int result = systemUserService.saveUserAndRole(userRoleDTO);
        if(result != 0)
        {
            return new Result(ResultCode.SUCCESS);
        }

        return new Result(ResultCode.FAIL);
    }
}

