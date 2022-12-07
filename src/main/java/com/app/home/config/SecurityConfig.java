package com.app.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.app.home.user.UserSecurityService;
import com.app.home.user.security.LoginFail;
import com.app.home.user.security.LoginSuccess;
import com.app.home.user.security.LogoutCustom;
import com.app.home.user.security.LogoutSuccessCustom;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private LoginSuccess loginSuccess;
	@Autowired
	private LoginFail loginFail;
	@Autowired
	private LogoutCustom logoutCustom;
	@Autowired
	private LogoutSuccessCustom logoutSuccessCustom;
	@Autowired
	private UserSecurityService userSecurityService;
	
	@Bean
	WebSecurityCustomizer webSecurityConfig() {
		return web -> web.ignoring()
						.antMatchers("/images/**")
						.antMatchers("/css/**")
						.antMatchers("/js/**")
						.antMatchers("/favicon/**")
						.antMatchers("/resources/**");
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
		httpSecurity
					.cors()
					.and()
					.csrf()
					.disable()
				.authorizeRequests()
					.antMatchers("/admin").hasRole("ADMIN")
					.antMatchers("/manager").hasRole("MANAGER")
					.antMatchers("/user").permitAll()
					.anyRequest().permitAll()
					.and()
				.formLogin()
					.loginPage("/user/login")
					.passwordParameter("pw")
					.usernameParameter("id")
					.successHandler(loginSuccess)
					.failureHandler(loginFail)
					.permitAll()
					.and()
				.logout()
					.logoutUrl("/user/logout")
					.logoutSuccessHandler(logoutSuccessCustom)
					.addLogoutHandler(logoutCustom)
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")
					.permitAll()
					.and()
				.rememberMe()  //RememberMe 설정
					.rememberMeParameter("rememberMe") //파라미터명
					.tokenValiditySeconds(300)         //로그인유지 유지시간, 초단위
					.key("rememberMe")  // 인증받은 사용자의 정보f로 Token 생성시 필요, 필수값
					.userDetailsService(userSecurityService) //인증 절차를 실행할 UserDetailService, 필수
					.authenticationSuccessHandler(loginSuccess); //Login 성공 Handler
		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}
}
