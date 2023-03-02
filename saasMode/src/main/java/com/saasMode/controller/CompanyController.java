package com.saasMode.controller;

import com.baseCommon.controller.BaseController;
import com.baseCommon.entity.Result;
import com.baseCommon.entity.ResultCode;
import com.baseCommon.exception.CommonException;
import com.saasMode.service.CompanyService;
import com.saasMode.pojo.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//解决跨域问题
@CrossOrigin
@RestController
@RequestMapping(value="/company")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyService companyService;

    //保存
    @RequestMapping(value="",method = RequestMethod.POST)
    public Result insert(@RequestBody Company company)  {
        //业务操作
        companyService.insert(company);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id更新
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value="id") String id, @RequestBody Company company ) {
        //业务操作
        company.setId(id);
        companyService.update(company);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id删除
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value="id") String id) {
        companyService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id查询
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result selectById(@PathVariable(value="id") String id) throws CommonException {
        Company company = companyService.selectById(id);
        return new Result(ResultCode.SUCCESS,company);
    }

    //查询全部
    @RequestMapping(value="",method = RequestMethod.GET)
    public Result selectAll() {
        List<Company> list = companyService.selectAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
    }

    //根据id查询
    @RequestMapping(value="/initDB/{id}",method = RequestMethod.GET)
    public Result initDB(@PathVariable(value="id") String id) throws Exception {
        System.out.println("-------------");
        boolean result = companyService.initDB(id);
        return new Result(ResultCode.SUCCESS,result);
    }


}
