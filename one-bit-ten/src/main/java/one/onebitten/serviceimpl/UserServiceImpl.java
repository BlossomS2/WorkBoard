package one.onebitten.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import one.onebitten.dao.UserDao;
import one.onebitten.service.UserService;
import one.onebitten.vo.UserVo;

@Component
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

}
