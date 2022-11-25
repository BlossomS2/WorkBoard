package one.onebitten.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import one.onebitten.dao.UserDao;
import one.onebitten.service.UserService;
import one.onebitten.vo.BoardVo;
import one.onebitten.vo.GroupVO;
import one.onebitten.vo.UserVo;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userMapper; 

	@Override
	public int UserRegister(UserVo user) throws Exception {
		return userMapper.UserRegister(user);
	}

	@Override
	public UserVo login_check(String id) throws Exception {

		return userMapper.login_check(id);
	}

	@Override
	public List<BoardVo> board_list() throws Exception {
		
		return userMapper.board_list();
	}

	@Override
	public BoardVo check_board(int num) {
		
		return userMapper.check_board(num);
	}

	@Override
	public int board_insert(BoardVo boardVo) throws Exception {
		
		return userMapper.board_insert(boardVo);
	}

	@Override
	public int board_update(BoardVo boardVo) throws Exception {
		
		return userMapper.board_update(boardVo);
	}

	@Override
	public int board_delete(int num) throws Exception {
		
		return userMapper.board_delete(num);
	}

	@Override
	public List<GroupVO> group_list() throws Exception {
		
		return userMapper.group_list();
	}

}
