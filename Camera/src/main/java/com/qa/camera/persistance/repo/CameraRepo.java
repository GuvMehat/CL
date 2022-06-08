package src.main.java.com.qa.camera.persistance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import src.main.java.com.qa.camera.persistance.domain.Camera;

@Repository
public interface CameraRepo extends JpaRepository<Camera, Long> {

}
