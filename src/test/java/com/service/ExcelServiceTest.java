package com.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.entity.EmpleadoEntity;
import com.entity.RoleEntity;
import com.model.EmpleadoModel;
import com.model.RoleModel;
import com.repository.RoleRepository;
import com.util.Converter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExcelServiceTest {
	
    @InjectMocks
    private ExcelService excelService;
    
    private BlockingQueue<RoleModel> queue;
    
    @Mock
    private Converter converter; 
    @Mock
    private RoleRepository repositorio; 
    
    private RoleModel roleModel;
    private RoleEntity roleEntity;
    
    @BeforeEach
    void setUp() {
    	queue = new LinkedBlockingQueue<>();
        
        roleEntity = new RoleEntity();
        
        String columnNombre = "Luisa";
		String columnApellido = "Guerrero";
		String columnEmail = "gueluisa@crehana.com.co";
		String columnTelefono = "3213567894";
		String columnRol = "Aseadora";

		EmpleadoModel empleado = new EmpleadoModel(columnNombre,columnApellido,columnEmail,columnTelefono);
		roleModel = new RoleModel(columnRol, empleado);
		
		EmpleadoEntity empleadoEnt = new EmpleadoEntity(columnNombre,columnApellido,columnEmail,columnTelefono);
		roleEntity = new RoleEntity(columnRol, empleadoEnt);

    }   
    /*
    @Test
    void testTransformAndLoadData() throws InterruptedException {
       
        RoleEntity roleEntity = new RoleEntity();
        
        queue.put(roleModel);

        when(converter.convertToRoleEntity(roleModel)).thenReturn(roleEntity);

        // Ejecutar el método en un hilo virtual para que no bloquee el test
        Thread virtualThread = Thread.ofVirtual().start(() -> excelService.transformAndLoadData(queue));

        // Espera un momento para que el método procese el elemento de la cola
        Thread.sleep(100);

        //Verifica que el método save fue llamado con la entidad convertida
        verify(repositorio).save(roleEntity);

        // Interrumpe el hilo para terminar el bucle infinito
        virtualThread.interrupt();
        virtualThread.join();
    }*/
    
    
    
}
