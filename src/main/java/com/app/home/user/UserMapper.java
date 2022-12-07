package com.app.home.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Mapper
public interface UserMapper {
	public int setJoin(UserVO userVO)throws Exception;
	public UserVO getLogin(String username)throws UsernameNotFoundException;
}
