package com.social.manager.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.social.manager.entities.Roles;
import com.social.manager.repository.UserRepository;

@Service
@Transactional
public class RepositoryBasedUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	/*@Autowired
	private RolesRepository rolesRepository;*/

	/**
	 * Returns a populated {@link UserDetails} object. The username is first retrieved from 
	 * the database and then mapped to a {@link UserDetails} object.
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			com.social.manager.entities.User domainUser = userRepository.findByUsername(username);
			
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			
			return new User(
					domainUser.getUsername(), 
					new BCryptPasswordEncoder().encode(domainUser.getPassword().toLowerCase()),
					enabled,
					accountNonExpired,
					credentialsNonExpired,
					accountNonLocked,
					getAuthorities(domainUser));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Retrieves a collection of {@link GrantedAuthority} based on a numerical role.
	 * 
	 * @param role the numerical role
	 * @return a collection of {@link GrantedAuthority
	 */
	public Collection<? extends GrantedAuthority> getAuthorities(com.social.manager.entities.User user) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(user));
		return authList;
	}
	
	/**
	 * Converts a numerical role to an equivalent list of roles.
	 * 
	 * @param role the numerical role
	 * @return list of roles as as a list of {@link String}
	 */
	public List<String> getRoles(com.social.manager.entities.User user) {
		
		List<String> rols = new ArrayList<String>();
		try{
			Set<Roles> roles = user.getRoles();
			for(Roles rl : roles){
				rols.add(rl.getRoleName());
			}
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		
		return rols;
	}
	
	/**
	 * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects.
	 * 
	 * @param roles {@link String} of roles
	 * @return list of granted authorities
	 */
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
}