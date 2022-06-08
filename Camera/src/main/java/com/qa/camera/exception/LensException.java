package com.qa.camera.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Lens not found")
public class LensException extends Exception{
	private static final long serialVersionUID = 3322179265522227925L;
}
