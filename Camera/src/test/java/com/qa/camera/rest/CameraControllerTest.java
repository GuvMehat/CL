package com.qa.camera.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.qa.camera.persistance.domain.Camera;
import com.qa.camera.persistance.repo.CameraRepo;
import com.qa.camera.service.CameraService;


@SpringBootTest
public class CameraControllerTest {
	
	@Autowired
	private CameraController controller;
	
	@MockBean
	private CameraService service;
	
	@MockBean
	private CameraRepo repo;
	
	
	// Create
	@Test
	public void createTest() {
		final Camera camera = new Camera();
		assertEquals(new ResponseEntity<>(this.service.create(camera), HttpStatus.CREATED), this.controller.create(camera));
	}
	
	// Read All
	@Test
	public void readAllTest() {
		assertEquals(new ResponseEntity<>(this.service.getAllCamera(), HttpStatus.OK), this.controller.read());
	}
	
	// Read By ID
	@Test
	public void readByIdTest() throws Exception {
		final Long id = 1L;
		assertEquals(new ResponseEntity<>(this.service.CameraByID(id), HttpStatus.OK), this.controller.readID(id));
	}
	
	// Update
	@Test
	public void updateTest() throws Exception {
		final Long id = 1L;
		final Camera camera = new Camera();
		assertEquals(new ResponseEntity<>(this.service.update(id, camera), HttpStatus.ACCEPTED), this.controller.update(id, camera));
	}
	
	// Delete
	@Test
	public void deleteTest() throws Exception {
		final Long id = 1L;
		assertEquals(new ResponseEntity<>(this.service.delete(id), HttpStatus.NO_CONTENT), this.controller.delete(id));
	}
	

}
