package com.informatec.reservationenligne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.informatec.reservationenligne.entites.User;

public interface IUserRepositorie extends JpaRepository<User, Long>{

	

	//public User findByName(String nomUser);
}
