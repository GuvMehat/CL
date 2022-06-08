package com.qa.camera.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.camera.persistance.DTO.LensDTO;
import com.qa.camera.persistance.domain.Lens;
import com.qa.camera.service.LensService;

public class LensController {

	private LensService service;

	@Autowired
	public LensController(LensService service) {
		this.service = service;
	}

	// A HOME PAGE --- CAN BE EDITED TO LOOK COOL --- WORKS
	@GetMapping("/homeLens")
	public String home() {
		return "home.html";
	}

	// CREATE
	@PostMapping("/createLens")
	public LensDTO create(@RequestBody Lens Lens) {
		return this.service.create(Lens);
	}

	// READ
	@GetMapping("/readLens")
	public List<LensDTO> read() {
		return this.service.getAllLens();
	}

	// READ BY ID
	@GetMapping("/readLens/{id}")
	public LensDTO readID(@PathVariable Long Id) throws Exception {
		return this.service.LensByID(Id);
	}

	// UPDATE
	@PutMapping("/updateLens/{id}")
	public LensDTO update(@PathVariable Long id, @RequestBody Lens Lens) throws Exception {
		return this.service.update(id, Lens);
	}

	// DELETE
	@DeleteMapping("/deleteLens/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {

		return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}
}
