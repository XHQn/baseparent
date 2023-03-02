package com.auth.controller;

import com.baseCommon.controller.BaseController;
import com.baseCommon.entity.PageResult;
import com.baseCommon.entity.Result;
import com.baseCommon.entity.ResultCode;
import com.baseCommon.exception.CommonException;
import com.auth.service.SystemPermissionApiService;
import com.auth.pojo.SystemPermissionApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//解决跨域问题
@CrossOrigin
@RestController
@Api(value = "systemPermissionApi", tags = "用户管理")
@RequestMapping(value="/systemPermissionApi")
public class SystemPermissionApiController extends BaseController {

    @Autowired
    private SystemPermissionApiService systemPermissionApiService;

    //保存
    @ApiOperation("自动生成：保存实体")
    @RequestMapping(value="",method = RequestMethod.POST)
    public Result insert(@RequestBody SystemPermissionApi systemPermissionApi)  {
        //业务操作
        systemPermissionApiService.insert(systemPermissionApi);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id更新
    @ApiOperation("自动生成：根据id更新实体")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value="id") String id, @RequestBody SystemPermissionApi systemPermissionApi ) {
        //业务操作
        systemPermissionApi.setId(id);
        systemPermissionApiService.update(systemPermissionApi);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id删除
    @ApiOperation("自动生成：根据id删除实体")
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value="id") String id) {
        systemPermissionApiService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id查询
    @ApiOperation("自动生成：根据id查询实体")
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value="id") String id) throws CommonException {
        SystemPermissionApi systemPermissionApi = systemPermissionApiService.selectById(id);
        return new Result(ResultCode.SUCCESS,systemPermissionApi);
    }

    //查询全部
    @ApiOperation("自动生成：根据条件查询实体列表")
    @RequestMapping(value="/selectList",method = RequestMethod.POST)
    public Result selectList(@RequestParam(name = "pageSize") Integer pageSize, @RequestParam(name = "page") Integer page,@RequestBody SystemPermissionApi systemPermissionApi) {
        PageResult<SystemPermissionApi> pageResult = systemPermissionApiService.selectList(pageSize,page,systemPermissionApi);
        Result result = new Result(ResultCode.SUCCESS,pageResult);
        return result;
    }

    //查询全部
    @ApiOperation("自动生成：查询全部实体列表")
    @RequestMapping(value="",method = RequestMethod.GET)
    public Result selectAll() {
        List<SystemPermissionApi> list = systemPermissionApiService.selectAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
        }

}
