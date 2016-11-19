package com.informatec.reservationenligne.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.informatec.reservationenligne.entites.Role;
import com.informatec.reservationenligne.entites.User;
import com.informatec.reservationenligne.repositories.IRoleRepositorie;
import com.informatec.reservationenligne.repositories.IUserRepositorie;

@Service
@Transactional
public class UserServices {

	@Autowired
	IUserRepositorie iUserRepositorie;

	@Autowired
	IRoleRepositorie iRoleRepositorie;

	public List<User> findAll() {
		return iUserRepositorie.findAll();
	}

	public User findOne(Long codeUser) {
		return iUserRepositorie.findOne(codeUser);
	}

	public void delete(Long codeUser) {
		iUserRepositorie.delete(codeUser);
	}

	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setMdpUser(encoder.encode(user.getMdpUser()));

		List<Role> roles = new ArrayList<Role>();
		roles.add(iRoleRepositorie.findByName("ROLE_USER"));
		user.setRoles(roles);

		iUserRepositorie.save(user);
	}

	@PostConstruct
	public void init() {
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		iRoleRepositorie.save(roleUser);
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_Admin");
		
		iRoleRepositorie.save(roleAdmin);
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		User user = new User();
		user.setNomUser("Triki");
		user.setPrenomUser("Walid");
		user.setEmail("triki.walid.01@gmail.com");
		user.setLoginUser("admin1");
		user.setMdpUser("admin");
		user.setRoles(roles);
		iUserRepositorie.save(user);

	}
}
