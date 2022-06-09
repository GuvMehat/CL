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



import com.qa.camera.persistance.domain.Camera;
import com.qa.camera.service.CameraService;

@RestController
@CrossOrigin
@RequestMapping("/camera")
public class CameraController {

	private CameraService service;

	@Autowired
	public CameraController(CameraService service) {
		this.service = service;
	}

	// A HOME PAGE
	@GetMapping("/home")
	public String home() {
		return "home.html";
	}

	// CREATE
	@PostMapping("/create")
	public ResponseEntity<Camera> create(@RequestBody Camera Camera) {
		return new ResponseEntity<>(this.service.create(Camera), HttpStatus.CREATED);
	}

	// READ
	@GetMapping("/read")
	public ResponseEntity<List<Camera>> read() {
		return new ResponseEntity<>(this.service.getAllCamera(), HttpStatus.OK);
	}

	// READ BY ID
	@GetMapping("/read/{id}")
	public ResponseEntity<Camera> readID(@PathVariable Long Id) throws Exception {
		return new ResponseEntity<>(this.service.CameraByID(Id), HttpStatus.OK);
	}

	// UPDATE
	@PutMapping("/update/{id}")
	public  ResponseEntity<Camera> update(@PathVariable Long id, @RequestBody Camera Camera) throws Exception {
		return new ResponseEntity<>(this.service.update(id, Camera), HttpStatus.ACCEPTED);
	}

	// DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {

		return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}

}
