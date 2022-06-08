package src.main.java.com.qa.camera.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import src.main.java.com.qa.camera.persistance.DTO.CameraDTO;
import src.main.java.com.qa.camera.persistance.domain.Camera;
import src.main.java.com.qa.camera.persistance.repo.CameraRepo;


@Service 
public class CameraService {

	private ModelMapper mapper;
	private CameraRepo repo;

	public CameraService(CameraRepo repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	private CameraDTO mapToDTO(Camera camera) {
		return this.mapper.map(camera, CameraDTO.class);
	}

	// CREATE
	public CameraDTO create(Camera camera) {
		return this.mapToDTO(this.repo.save(camera));
	}

	//READ
	public List<CameraDTO> getAllCamera() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	//READ BY ID
	public CameraDTO CameraByID(Long Id) throws Exception {
		return this.mapToDTO(this.repo.findById(Id).orElseThrow(Exception::new));
	}
	
	//UPDATE
	public CameraDTO update(Long ID, Camera camera) throws Exception{
		Camera exists = this.repo.findById(Id).orElseThrow(Exception::new);
		exists.setBrand(camera.getBrand());
		exists.setId(camera.getId());
		exists.setType(camera.getType());
		exists.setMount(camera.getMount());
		return this.mapToDTO(this.repo.saveAndFlush(exists));
	}
	
	//DELETE
	public boolean delete(Long Id) throws Exception{
		this.repo.findById(Id).orElseThrow(Exception::new);
		this.repo.deleteById(Id);
		return !this.repo.existsById(Id);
	}
}
