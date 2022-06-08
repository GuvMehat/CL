package com.qa.camera.persistance.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LensDTO {
	private long id;

	private int Mount;
	
	private long Fstop;

	private int Range;

	private String Brand;

}
