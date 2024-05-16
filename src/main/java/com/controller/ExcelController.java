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

import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelController {

	@Autowired
	ExcelService excelService;

	@PostMapping("/upload")
	public ResponseEntity<List<String>> uploadAndReadExcelFile(@RequestParam("file") MultipartFile file) {
		try {
			List<String> result = excelService.uploadAndReadExcelFile(file);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
