package com.app.home.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class UserServiceTest {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	void test() throws Exception {
		UserVO userVO = new UserVO();
		userVO.setId("202201001");
		userVO.setName("김도훈");
		userVO.setPw(passwordEncoder.encode("111"));
		userVO.setEmail("asd@naver.com");
		userVO.setPhone("01012341234");
		int result = userMapper.setJoin(userVO);
		assertEquals(1, result);
	}

}
