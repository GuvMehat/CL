package com.qa.camera.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Camera {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String Brand;
	private int Type;
	private int Mount;

	public Camera() {}
	
	public Camera(Long id, String Brand, int Type, int Mount) {
		super();
		this.id=id;
		this.Brand=Brand;
		this.Type=Type;
		this.Mount=Mount;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public int getType() {
		return Type;
	}

	public void setType(int type) {
		Type = type;
	}

	public int getMount() {
		return Mount;
	}

	public void setMount(int mount) {
		Mount = mount;
	}

}
