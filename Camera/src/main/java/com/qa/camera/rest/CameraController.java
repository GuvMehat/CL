package com.qa.camera.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.camera.persistance.DTO.CameraDTO;
import com.qa.camera.persistance.domain.Camera;
import com.qa.camera.service.CameraService;

@Controller
public class CameraController {

	private CameraService service;

	@Autowired
	public CameraController(CameraService service) {
		this.service = service;
	}

	// A HOME PAGE --- CAN BE EDITED TO LOOK COOL --- WORKS
	@GetMapping("/home")
	public String home() {
		return "home.html";
	}

	// CREATE
	@PostMapping("/create")
	public CameraDTO create(@RequestBody Camera Camera) {
		return this.service.create(Camera);
	}

	// READ
	@GetMapping("/read")
	public List<CameraDTO> read() {
		return this.service.getAllCamera();
	}

	// READ BY ID
	@GetMapping("/read/{id}")
	public CameraDTO readID(@PathVariable Long Id) throws Exception {
		return this.service.CameraByID(Id);
	}

	// UPDATE
	@PutMapping("/update/{id}")
	public CameraDTO update(@PathVariable Long id, @RequestBody Camera Camera) throws Exception {
		return this.service.update(id, Camera);
	}

	// DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {

		return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}

}
