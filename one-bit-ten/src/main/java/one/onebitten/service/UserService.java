package one.onebitten.service;

import java.util.List;

import one.onebitten.vo.BoardVo;
import one.onebitten.vo.UserVo;

public interface UserService {

    int UserRegister(UserVo user) throws Exception;
    UserVo login_check(String id) throws Exception;
    
    List<BoardVo> board_list() throws Exception;
} 
