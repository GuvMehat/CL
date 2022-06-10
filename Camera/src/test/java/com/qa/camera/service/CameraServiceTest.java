package com.qa.camera.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.camera.persistance.DTO.CameraDTO;
//import com.qa.camera.exception.CameraException;
import com.qa.camera.persistance.domain.Camera;
import com.qa.camera.persistance.repo.CameraRepo;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CameraServiceTest {
	
	@Autowired
	private CameraService service;
	
	@MockBean
	private CameraRepo repo;
	
	@Test
	void createTest() {
		new Camera(1L, "sony",2,2);
		Camera test = new Camera();
		
		Mockito.when(this.repo.save(test)).thenReturn(test);
		
		assertEquals(test, this.service.create(test));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(test);
		
	}
	
	@Test
	void readAllTest () {
		final List<Camera> expectedCamera = List.of(new Camera(1L, "sony",2,2));

		Mockito.when(this.repo.findAll()).thenReturn(expectedCamera);

		assertThat(this.service.getAllCamera()).isEqualTo(expectedCamera);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void readIdTest() throws Exception {
		final Long id = 1L;
		final Camera test = new Camera(1L, "sony",2,2);
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(test));

		assertThat(this.service.CameraByID(id)).isEqualTo(test);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}
	
	@Test
	void updateTest() throws Exception { 
		final Long id = 1L;
		final Camera camera1 = new Camera();
		final Camera camera2 = new Camera();
		final CameraDTO cameraDTO = new CameraDTO();

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(camera1));
		Mockito.when(this.repo.saveAndFlush(camera2)).thenReturn(camera2);


		assertEquals(cameraDTO, this.service.update(id, camera1));

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(camera2);
	}
	
	@Test
	void deleteTest() throws Exception {
		final Long id = 1L;
		final Camera camera = new Camera();

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(camera));
		
		final boolean result = this.service.delete(id);
		
		assertEquals(result, this.service.delete(id));	
		
		Mockito.verify(this.repo, Mockito.times(2)).findById(Mockito.anyLong());	
	}


}