package com.qa.camera.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Camera {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String Brand;

	private int Type;

	private int Mount;

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
