package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.BaseDatos;
import com.fasterxml.jackson.databind.JsonSerializable.Base;

@RestController
public class Controller {

	BaseDatos bd = new BaseDatos();

	// Execute the method prueba from the class BaseDatos
	@GetMapping("/prueba")
	public String getPrueba() {
		return "prueba";
	}

	
	
	@GetMapping("/consultaempresas")
	public String getEmpresas() {
		// call the method consultaEmpresas() from the class BaseDatos
		return "consultaEmpresas";
	}

	
	@GetMapping("/bye/bye1")
	public String getNBye() {
		return "bye1";
	}


	
	
}
