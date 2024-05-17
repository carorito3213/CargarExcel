package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.service.ExcelService;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/excel")
public class ExcelController {

	@Autowired
	ExcelService excelService;

	@PostMapping("/upload")
	public ResponseEntity<String> etlExcelFile(@RequestParam("file") MultipartFile file) {
		
		try {
			excelService.etlExcelFile(file);

			return new ResponseEntity<>("Se inicio el procesamiento del archivo", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
