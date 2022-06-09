package com.qa.camera.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.qa.camera.persistance.domain.Lens;
import com.qa.camera.service.LensService;

@RestController
@CrossOrigin
@RequestMapping("/lens")
public class LensController {

	private LensService service;

	@Autowired
	public LensController(LensService service) {
		this.service = service;
	}

	// A HOME PAGE --- CAN BE EDITED TO LOOK COOL --- WORKS
	@GetMapping("/home")
	public String home() {
		return "home.html";
	}

	// CREATE
	@PostMapping("/create")
	public ResponseEntity<Lens> create(@RequestBody Lens Lens) {
		return new ResponseEntity<>(this.service.create(Lens), HttpStatus.CREATED);
	}

	// READ
	@GetMapping("/read")
	public ResponseEntity<List<Lens>> read() {
		return new ResponseEntity<>(this.service.getAllLens(), HttpStatus.OK);
	}

	// READ BY ID
	@GetMapping("/read/{id}")
	public Lens readID(@PathVariable Long Id) throws Exception {
		return this.service.LensByID(Id);
	}

	// UPDATE
	@PutMapping("/update/{id}")
	public ResponseEntity<Lens> update(@PathVariable Long id, @RequestBody Lens Lens) throws Exception {
		return new ResponseEntity<>(this.service.update(id, Lens), HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {

		return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}
}
