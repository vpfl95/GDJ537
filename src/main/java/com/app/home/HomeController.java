package com.app.home;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@GetMapping("/")
	public String home(HttpSession session) {
		log.info("========================");
		Enumeration<String> en = session.getAttributeNames();
		
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			log.info("key =>{}",key); // SPRING_SECURITY_CONTEXT
		}
		
		SecurityContextImpl context = (SecurityContextImpl)session.getAttribute("SPRING_SECURITY_CONTEXT");
		if(context != null) {
			log.info("Context  => {} ", context);
			// SecurityContextImpl [Authentication=UsernamePasswordAuthenticationToken [Principal=UserVO(num=5, id=202201001, roleNum=null, depNum=null, pw=$2a$10$ixE8qUfAFgTuK8P0JcMYA.xTc1ZleZtVczeBrahGxzr3cc8NrexLS, name=김도훈, email=asd@naver.com, phone=null, entDate=null, profile=null, status=null, roleVOs=[RoleVO(roleNum=1, roleName=ROLE_ADMIN)]), Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=EDD403C92BCC11A3452B440D09DCC701], Granted Authorities=[ROLE_ADMIN]]] 
		}
		
		
		return "index";
	}

}
