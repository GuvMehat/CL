package com.qa.camera.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.camera.persistance.DTO.LensDTO;
//import com.qa.camera.exception.LensException;
import com.qa.camera.persistance.domain.Lens;
import com.qa.camera.persistance.repo.LensRepo;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class LensServiceTest {
	
	@Autowired
	private LensService service;
	
	@MockBean
	private LensRepo repo;
	
	@Test
	void createTest() {

		Lens test = new Lens(1L,2,1L,2, "tameron");
		
		Mockito.when(this.repo.save(test)).thenReturn(test);
		
		assertEquals(test, this.service.create(test));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(test);
		
	}
	
	@Test
	void readAllTest () {
		final List<Lens> expectedLens = List.of(new Lens(1L,2,1L,2, "tameron"));

		Mockito.when(this.repo.findAll()).thenReturn(expectedLens);

		assertThat(this.service.getAllLens()).isEqualTo(expectedLens);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void readIdTest() throws Exception {
		final Long id = 1L;
		final Lens test = new Lens(1L,2,1L,2, "tameron");
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(test));

		assertThat(this.service.LensByID(id)).isEqualTo(test);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}
	
//	@Test
//	void updateTest() throws Exception { 
//		final Long id = 1L;
//		final Lens lens1 = new Lens();
//		final Lens lens2 = new Lens();
//
//		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(lens1));
//		Mockito.when(this.repo.save(lens2)).thenReturn(lens2);
//		
//		Assertion.assertThat(this.service.update(lens1.getId(), lens2)).isEqualTo(lens2);	
//		
//		Mockito.verify(this.repo, Mockito.times(1)).findById(id);	
//		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(lens2);	
//	}
	
	@Test
	void deleteTest() throws Exception {
		final Long id = 1L;
		final Lens lens = new Lens(1L,2,1L,2, "tameron");

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(lens));
		
		final boolean result = this.service.delete(id);
		
		assertEquals(result, this.service.delete(id));	
		
		Mockito.verify(this.repo, Mockito.times(2)).findById(Mockito.anyLong());	
	}


}