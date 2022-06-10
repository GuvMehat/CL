package com.qa.camera.persistance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.camera.persistance.domain.Lens;



@Repository
public interface LensRepo extends JpaRepository<Lens, Long>{

}
