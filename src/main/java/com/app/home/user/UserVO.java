package com.app.home.user;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



import lombok.Data;

@Data
public class UserVO implements UserDetails {
	private Long num;
	private String id;
	private Long roleNum;
	private Long depNum;
	private String pw;
	private String name;
	private String email;
	private String phone;
	private Date entDate;
	private String profile;
	private String status;
	private List<RoleVO> roleVOs;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// <? super T> T나 T의 부모타입을 담을 수 있다. grantedauthority타입이나 이걸 상속받는 타입 을 담을 수 있다.
		List<GrantedAuthority> authorities= new ArrayList<>();
		for(RoleVO roleVO: roleVOs) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
			
		}
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.getPw();
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.id;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
