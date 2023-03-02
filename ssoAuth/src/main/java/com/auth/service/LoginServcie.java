package com.auth.service;

import com.auth.pojo.ResponseResult;
import com.auth.pojo.SystemUser;

public interface LoginServcie {
    ResponseResult login(SystemUser systemUser);

    ResponseResult logout();

}
