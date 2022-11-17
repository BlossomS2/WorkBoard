package one.onebitten.service;

import one.onebitten.vo.UserVo;

public interface UserService {

    int UserRegister(UserVo user) throws Exception;
    UserVo login_check(String id) throws Exception;
} 
