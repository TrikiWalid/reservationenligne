package com.informatec.reservationenligne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.informatec.reservationenligne.entites.Role;

public interface IRoleRepositorie extends JpaRepository<Role, Integer>{

	Role findByName(String name);
	
	

}
