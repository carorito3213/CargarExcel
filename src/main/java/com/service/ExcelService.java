package com.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.entity.RoleEntity;
import com.exception.ExcelIOException;
import com.exception.InvalidExcelFormatException;
import com.model.EmpleadoModel;
import com.model.RoleModel;
import com.repository.EmpleadoRepository;
import com.repository.RoleRepository;
import com.util.Converter;
import com.util.ErrorMessages;

@Service
public class ExcelService {
	
	private static final Logger logger = LogManager.getLogger(ExcelService.class);
	
    @Autowired
    private EmpleadoRepository empleadoRepository;
    
    @Autowired
    private RoleRepository roleRepository;

	public void etlExcelFile(MultipartFile file) throws IOException, InvalidExcelFormatException {

		// Cola para el almacenamiento temporal de datos transformados
		BlockingQueue<RoleModel> queue = new LinkedBlockingQueue<>();

		ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
		
		// Extracción
		executorService.submit(() -> extractData(file, queue));
		
		// Transformación y Carga
		executorService.submit(() -> transformAndLoadData(queue));
			
        // Apagar el executor cuando todas las tareas hayan terminado
        executorService.shutdown();

	}

	private static void extractData(MultipartFile file, BlockingQueue<RoleModel> queue) 
			throws InvalidExcelFormatException {

		try {
			
			InputStream inputStream = file.getInputStream(); 
			Workbook workbook = new XSSFWorkbook(inputStream);

			Sheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				
				String columnNombre = getCellValueAsString(row.getCell(0));
				String columnApellido = getCellValueAsString(row.getCell(1));
				String columnEmail = getCellValueAsString(row.getCell(2));
				String columnTelefono = getCellValueAsString(row.getCell(3));
				String columnRol = getCellValueAsString(row.getCell(4));

				/*Dependencia de lombok no funciona :( */
				//Empleado empleado = new Empleado.builder().nombre(columnNombre).build(); 
				
				EmpleadoModel empleado = new EmpleadoModel(columnNombre,columnApellido,columnEmail,columnTelefono);
				
				RoleModel rol = new RoleModel(columnRol, empleado);
				// Añadir registros a la cola//
				queue.put(rol); 

				//System.out.println("Extracted: " + empleado);
			}

		} catch (IOException | InterruptedException e) { 
			throw new ExcelIOException(ErrorMessages.IO_EXCEPTION.getMessage());
		} 
		
		/*catch (InvalidExcelFormatException e) {
			throw e;
		}*/
		 
	}
	
	private void transformAndLoadData(BlockingQueue<RoleModel> queue){
        
		while (true) {
			
			try {
				
				RoleModel model = queue.take();
				
				RoleEntity entity  = Converter.convertToRoleEntity(model);
		        
	    		roleRepository.save(entity);
	    		
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}   catch (Exception e ) {
				
				e.printStackTrace();
			} 

		}
		
	}

	private static String getCellValueAsString(Cell cell) {
		if (cell == null) {
			logger.error(ErrorMessages.INVALID_FILE_FORMAT.getMessage());
			throw new InvalidExcelFormatException(ErrorMessages.INVALID_FILE_FORMAT.getMessage());
		}
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue().toString();
			} else {
				return String.valueOf(cell.getNumericCellValue());
			}
		default:
			throw new InvalidExcelFormatException(ErrorMessages.INVALID_FILE_FORMAT.getMessage());
		}
	}

}
