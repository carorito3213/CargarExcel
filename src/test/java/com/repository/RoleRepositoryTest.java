package com.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.entity.EmpleadoEntity;
import com.entity.RoleEntity;

@DataJpaTest
public class RoleRepositoryTest {

	@Autowired
    private RoleRepository roleRepository;

    @Test
    public void testSaveRoleEntity() {

    	EmpleadoEntity empleado = new EmpleadoEntity();
    	empleado.setNombre("Alejandra");
    	empleado.setApellido("Hernandez");
    	empleado.setEmail("healejandra@crehana.com.co");
    	empleado.setTelefono("5555555");
    	
        RoleEntity role = new RoleEntity();
        
        role.setNombre("Auditor");
        role.setEmpleadoId(empleado);

        // PersistirDatos
        RoleEntity savedRole = roleRepository.save(role);

        // Obtener la entidad guardada desde la base de datos
        RoleEntity retrievedRole = roleRepository.findById(savedRole.getId()).orElse(null);

        // Verificar que la entidad guardada y la recuperada sean iguales
        assertNotNull(retrievedRole);
        assertEquals(savedRole.getId(), retrievedRole.getId());
        assertEquals(savedRole.getNombre(), retrievedRole.getNombre());
    }
}
