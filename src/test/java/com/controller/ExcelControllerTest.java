package com.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.service.ExcelService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ExcelControllerTest {


    @Mock
    private ExcelService excelService;

    @InjectMocks
    private ExcelController excelController;

    @Test
    public void testEtlExcelFile_Success() throws Exception {
        // Mock para el archivo
        MockMultipartFile file = new MockMultipartFile("file", "test.xlsx", "application/vnd.ms-excel", "contenido del archivo".getBytes());

        // Mock para el servicio de Excel
        doNothing().when(excelService).etlExcelFile(any(MultipartFile.class));

        // Llamar al método que se está probando
        ResponseEntity<String> response = excelController.etlExcelFile(file);

        // Verificar que se inició el procesamiento del archivo
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Se inicio el procesamiento del archivo", response.getBody());
    }

   /* @Test
    public void testEtlExcelFile_Failure() throws Exception {
        // Mock para el archivo
        MockMultipartFile file = new MockMultipartFile("file", "test.xlsx", "application/vnd.ms-excel", "contenido del archivo".getBytes());

        // Mock para el servicio de Excel
        doThrow(new Exception()).when(excelService).etlExcelFile(any(MultipartFile.class));

        // Llamar al método que se está probando
        ResponseEntity<String> response = excelController.etlExcelFile(file);

        // Verificar que se obtuvo un error interno del servidor
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNull(response.getBody());
    }*/

	
}
