package com.auth.controller;

import com.baseCommon.controller.BaseController;
import com.baseCommon.entity.PageResult;
import com.baseCommon.entity.Result;
import com.baseCommon.entity.ResultCode;
import com.baseCommon.exception.CommonException;
import com.auth.service.SystemPermissionPointService;
import com.auth.pojo.SystemPermissionPoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//解决跨域问题
@CrossOrigin
@RestController
@Api(value = "systemPermissionPoint", tags = "用户管理")
@RequestMapping(value="/systemPermissionPoint")
public class SystemPermissionPointController extends BaseController {

    @Autowired
    private SystemPermissionPointService systemPermissionPointService;

    //保存
    @ApiOperation("自动生成：保存实体")
    @RequestMapping(value="",method = RequestMethod.POST)
    public Result insert(@RequestBody SystemPermissionPoint systemPermissionPoint)  {
        //业务操作
        systemPermissionPointService.insert(systemPermissionPoint);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id更新
    @ApiOperation("自动生成：根据id更新实体")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value="id") String id, @RequestBody SystemPermissionPoint systemPermissionPoint ) {
        //业务操作
        systemPermissionPoint.setId(id);
        systemPermissionPointService.update(systemPermissionPoint);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id删除
    @ApiOperation("自动生成：根据id删除实体")
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value="id") String id) {
        systemPermissionPointService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id查询
    @ApiOperation("自动生成：根据id查询实体")
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value="id") String id) throws CommonException {
        SystemPermissionPoint systemPermissionPoint = systemPermissionPointService.selectById(id);
        return new Result(ResultCode.SUCCESS,systemPermissionPoint);
    }

    //查询全部
    @ApiOperation("自动生成：根据条件查询实体列表")
    @RequestMapping(value="/selectList",method = RequestMethod.POST)
    public Result selectList(@RequestParam(name = "pageSize") Integer pageSize, @RequestParam(name = "page") Integer page,@RequestBody SystemPermissionPoint systemPermissionPoint) {
        PageResult<SystemPermissionPoint> pageResult = systemPermissionPointService.selectList(pageSize,page,systemPermissionPoint);
        Result result = new Result(ResultCode.SUCCESS,pageResult);
        return result;
    }

    //查询全部
    @ApiOperation("自动生成：查询全部实体列表")
    @RequestMapping(value="",method = RequestMethod.GET)
    public Result selectAll() {
        List<SystemPermissionPoint> list = systemPermissionPointService.selectAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
        }

}
