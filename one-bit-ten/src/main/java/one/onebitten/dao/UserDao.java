package one.onebitten.dao;

import org.apache.ibatis.annotations.Mapper;

import one.onebitten.vo.UserVo;


@Mapper
public interface UserDao {

	 int UserRegister(UserVo user) throws Exception;
	 UserVo login_check(String id); 
}
