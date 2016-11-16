package com.informatec.reservationenligne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class indexController {
	
	@RequestMapping("/index")
	public String index(){
		return"/dispatcher/index.jsp";
	}

}
