package com.informatec.reservationenligne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class indexController {
	
	@RequestMapping("/pages/index")
	public String index(){
		return"/pages/index.jsp";
	}
	
	@RequestMapping("/pages/users/admin")
	public String indexAdmin(){
		return"hellow admin";
	}

}
