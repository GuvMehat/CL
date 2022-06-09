package com.qa.camera.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.camera.persistance.domain.Camera;

@Repository
public interface CameraRepo extends JpaRepository<Camera, Long> {

}
