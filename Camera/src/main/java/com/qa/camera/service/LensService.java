package com.qa.camera.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.camera.persistance.DTO.LensDTO;
import com.qa.camera.persistance.domain.Lens;
import com.qa.camera.persistance.repo.LensRepo;

@Service
public class LensService {
	
	private ModelMapper mapper;
	private LensRepo repo;

	public LensService(LensRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

//	private LensDTO mapToDTO(Lens lens) {
//		return this.mapper.map(lens, LensDTO.class);
//	}

	// CREATE
	public Lens create(Lens lens) {
		return this.repo.save(lens);
	}

	// READ
	public List<Lens> getAllLens() {
		return this.repo.findAll();
	}

	// READ BY ID
	public Lens LensByID(Long Id) throws Exception {
		return this.repo.findById(Id).orElseThrow(Exception::new);
	}

	// UPDATE
	public Lens update(Long ID, Lens lens) throws Exception {
		Lens exists = this.repo.findById(ID).orElseThrow(Exception::new);
		exists.setId(lens.getId());
		exists.setMount(lens.getMount());
		exists.setFstop(lens.getFstop());
		exists.setRange(lens.getRange());
		exists.setBrand(lens.getBrand());
		return this.repo.save(exists);
	}

	// DELETE
	public boolean delete(Long Id) throws Exception {
		this.repo.findById(Id).orElseThrow(Exception::new);
		this.repo.deleteById(Id);
		return !this.repo.existsById(Id);
	}
}
