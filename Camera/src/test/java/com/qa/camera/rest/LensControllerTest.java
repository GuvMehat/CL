package com.qa.camera.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.camera.persistance.domain.Lens;
import com.qa.camera.persistance.repo.LensRepo;
import com.qa.camera.service.LensService;





@SpringBootTest
public class LensControllerTest {
	
	@Autowired
	private LensController controller;
	
	@MockBean
	private LensService service;
	
	@MockBean
	private LensRepo repo;
	
	
	// Create
	@Test
	public void createTest() {
		final Lens Lens = new Lens(1, 1, 1, 1, "Tameron");
		assertEquals(new ResponseEntity<>(this.service.create(Lens), HttpStatus.CREATED), this.controller.create(Lens));
	}
	
	// Read All
	@Test
	public void readAllTest() {
		assertEquals(new ResponseEntity<>(this.service.getAllLens(), HttpStatus.OK), this.controller.read());
	}
	
	// Read By ID
	@Test
	public void readByIdTest() throws Exception {
		final Long id = 1L;
		assertEquals(new ResponseEntity<>(this.service.LensByID(id), HttpStatus.OK), this.controller.readID(id));
	}
	
	// Update
	@Test
	public void updateTest() throws Exception {
		final Long id = 1L;
		final Lens Lens = new Lens(1, 1, 1, 1, "Tameron");
		assertEquals(new ResponseEntity<>(this.service.update(id, Lens), HttpStatus.ACCEPTED), this.controller.update(id, Lens));
	}
	
	// Delete
	@Test
	public void deleteTest() throws Exception {
		final Long id = 1L;
		assertEquals(new ResponseEntity<>(this.service.delete(id), HttpStatus.NO_CONTENT), this.controller.delete(id));
	}
	

}