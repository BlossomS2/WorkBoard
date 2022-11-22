package one.onebitten.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import one.onebitten.vo.BoardVo;
import one.onebitten.vo.UserVo;


@Mapper
public interface UserDao {

	 int UserRegister(UserVo user) throws Exception;
	 UserVo login_check(String id); 
	 
	 List<BoardVo> board_list() throws Exception;
	 BoardVo check_board(int num);
}
