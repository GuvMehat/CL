package com.qa.camera.service;

import java.util.List;
//import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

//import com.qa.camera.persistance.DTO.CameraDTO;
import com.qa.camera.persistance.domain.Camera;
import com.qa.camera.persistance.repo.CameraRepo;


@Service 
public class CameraService {

//	private ModelMapper mapper;
	private CameraRepo repo;

	
	public CameraService(CameraRepo repo) {
		this.repo = repo;
		//this.mapper = mapper;
	}

//	private CameraDTO mapToDTO(Camera camera) {
//	//	return this.mapper.map(camera, CameraDTO.class);
//		
//	}

	// CREATE
	public Camera create(Camera camera) {
		return this.repo.save(camera);
	}

	//READ
	public List<Camera> getAllCamera() {
		return this.repo.findAll();
	}
	
	//READ BY ID
	public Camera CameraByID(Long Id) throws Exception {
		return this.repo.findById(Id).orElseThrow(Exception::new);
	}
	
	//UPDATE
	public Camera update(Long ID, Camera camera) throws Exception{
		Camera exists = this.repo.findById(ID).orElseThrow(Exception::new);
		exists.setBrand(camera.getBrand());
		exists.setId(camera.getId());
		exists.setType(camera.getType());
		exists.setMount(camera.getMount());
		return this.repo.saveAndFlush(exists);
	}
	
	//DELETE
	public boolean delete(Long Id) throws Exception{
		this.repo.findById(Id).orElseThrow(Exception::new);
		this.repo.deleteById(Id);
		return !this.repo.existsById(Id);
	}
}
