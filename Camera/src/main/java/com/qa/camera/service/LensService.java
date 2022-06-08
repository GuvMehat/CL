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
		this.repo = repo;
		this.mapper = mapper;
	}

	private LensDTO mapToDTO(Lens lens) {
		return this.mapper.map(lens, LensDTO.class);
	}

	// CREATE
	public LensDTO create(Lens lens) {
		return this.mapToDTO(this.repo.save(lens));
	}

	// READ
	public List<LensDTO> getAllLens() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// READ BY ID
	public LensDTO LensByID(Long Id) throws Exception {
		return this.mapToDTO(this.repo.findById(Id).orElseThrow(Exception::new));
	}

	// UPDATE
	public LensDTO update(Long ID, Lens lens) throws Exception {
		Lens exists = this.repo.findById(ID).orElseThrow(Exception::new);
		exists.setBrand(lens.getBrand());
		exists.setId(lens.getId());
		exists.setFstop(lens.getFstop());
		exists.setMount(lens.getMount());
		return this.mapToDTO(this.repo.saveAndFlush(exists));
	}

	// DELETE
	public boolean delete(Long Id) throws Exception {
		this.repo.findById(Id).orElseThrow(Exception::new);
		this.repo.deleteById(Id);
		return !this.repo.existsById(Id);
	}
}
