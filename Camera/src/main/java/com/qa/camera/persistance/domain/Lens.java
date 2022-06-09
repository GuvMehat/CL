package com.qa.camera.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Lens {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private int Mount;
	
	private long Fstop;

	private int Range;

	private String Brand;

	
	public Lens(long id, int mount, long fstop, int range, String brand) {
		super();
		this.id = id;
		Mount = mount;
		Fstop = fstop;
		Range = range;
		Brand = brand;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getMount() {
		return Mount;
	}

	public void setMount(int mount) {
		Mount = mount;
	}

	public long getFstop() {
		return Fstop;
	}

	public void setFstop(long fstop) {
		Fstop = fstop;
	}

	public int getRange() {
		return Range;
	}

	public void setRange(int range) {
		Range = range;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	
	
}
