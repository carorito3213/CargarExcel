package com.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExcelService {
	
	public List<String> uploadAndReadExcelFile(@RequestParam("file") MultipartFile file) throws IOException {
		
		List<String> result = new ArrayList<>();

        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {
             
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            result.add(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            result.add(String.valueOf(cell.getNumericCellValue()));
                            break;
                        default:
                            result.add("Unknown cell type");
                    }
                }
            }
        } catch (IOException e) {
        	throw e;
        }
	
		return result;
	}
	

}
