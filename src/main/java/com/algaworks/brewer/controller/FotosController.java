package com.algaworks.brewer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fotos")
public class FotosController {

	@PostMapping
	public String upload(@RequestParam("files[]") MultipartFile[] file) {
		System.out.println(">>files: "+file.length);
		return "ok";
	}
}
