package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	
	@GetMapping("/consultaempresas")
	public String getEmpresas() {
		return "empresas";
	}

	
	@GetMapping("/bye/bye1")
	public String getNBye() {
		return "bye1";
	}
	
	
}
