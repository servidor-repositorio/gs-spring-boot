package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.model.Cita;
import com.example.springboot.model.Response;
import com.example.springboot.services.CitaService;
import com.example.springboot.services.MedicoService;
import com.example.springboot.services.ValidandoDatos;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/citas")
public class ControladorCitas {

	@Autowired
    CitaService citaService;
	@Autowired
    MedicoService medicoService;

	@Autowired
	ValidandoDatos validadorRegistros;

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<Cita> cargarCitas() {

		return citaService.obtener();
	}
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cita> cargarCita(@PathVariable("id") Integer id) {

		return new ResponseEntity<>(citaService.obtenerPorId(id), HttpStatus.OK);
	}

	@PostMapping 
	public Response insertarCita(@RequestBody @Valid Cita cita) {

		return validadorRegistros.validarRegistro(cita);
	}

}
