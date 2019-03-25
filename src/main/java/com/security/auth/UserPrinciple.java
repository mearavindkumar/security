package com.security.auth;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.auth.data.entity.AuthGroup;
import com.security.auth.data.entity.User;

public class UserPrinciple implements UserDetails {
	
	private final User user;
	private final List<AuthGroup> authGroups;
	
	public UserPrinciple(User user, List<AuthGroup> authGroups) {
		super();
		this.user = user;
		this.authGroups = authGroups;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(null == authGroups) {
			return Collections.emptyList();
		}
		Set<GrantedAuthority> grantedAuthority = new HashSet<>();
		authGroups.forEach(group -> {
			grantedAuthority.add(new SimpleGrantedAuthority(group.getAuthGroup()));
		});
		return grantedAuthority;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
