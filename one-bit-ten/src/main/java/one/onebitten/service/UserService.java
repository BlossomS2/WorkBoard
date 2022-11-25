package one.onebitten.service;

import java.util.List;

import one.onebitten.vo.BoardVo;
import one.onebitten.vo.GroupVO;
import one.onebitten.vo.UserVo;

public interface UserService {

    int UserRegister(UserVo user) throws Exception;
    UserVo login_check(String id) throws Exception;
    
    List<BoardVo> board_list() throws Exception;
    BoardVo check_board(int num);
    int board_insert(BoardVo boardVo) throws Exception;
    int board_update(BoardVo boardVo) throws Exception;
    int board_delete(int num) throws Exception;
    List<GroupVO> group_list() throws Exception;
} 
