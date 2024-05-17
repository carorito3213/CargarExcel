package com.util;

import com.entity.EmpleadoEntity;
import com.entity.RoleEntity;
import com.model.EmpleadoModel;
import com.model.RoleModel;

public class Converter {
	
	/**
	 * Metodo que convierte un objeto EmpleadoModel en un objeto EmpleadoEntity
	 * 
	 * @param model el objeto model al que se le va a dar la conversion.
	 */
	public static EmpleadoEntity convertToEmpleadoEntity(EmpleadoModel model) {
        
		if (model == null) {
            return null;
        }

		EmpleadoEntity entity = new EmpleadoEntity();
		entity.setNombre(model.getNombre());
		entity.setApellido(model.getApellido());
		entity.setEmail(model.getEmail());
		entity.setTelefono(model.getTelefono());
		
        return entity;
    }

	/**
	 * Metodo que convierte un objeto EmpleadoEntity en un objeto EmpleadoModel
	 * 
	 * @param entity el objeto model al que se le va a dar la conversion.
	 */
    public static EmpleadoModel convertToEmpleadoModel(EmpleadoEntity entity) {
        
    	if (entity == null) {
            return null;
        }
    	

    	EmpleadoModel model = new EmpleadoModel();
    	model.setNombre(entity.getNombre());
    	model.setApellido(entity.getApellido());
    	model.setEmail(entity.getEmail());
    	model.setTelefono(entity.getTelefono());
    	
    	
        return model;
    }
    
    /**
	 * Metodo que convierte un objeto RoleModel en un objeto RoleEntity
	 * 
	 * @param model el objeto model al que se le va a dar la conversion.
	 */
    public static RoleEntity convertToRoleEntity(RoleModel model) {
        
		if (model == null) {
            return null;
        }

		EmpleadoEntity empEntity = convertToEmpleadoEntity(model.getEmpleado());
		
		RoleEntity roleEtity = new RoleEntity();
		
		roleEtity.setNombre(model.getNombre());
		roleEtity.setEmpleadoId(empEntity);
	
        return roleEtity;
    }
    
    /**
	 * Metodo que convierte un objeto RoleEntity en un objeto RoleModel
	 * 
	 * @param entity el objeto model al que se le va a dar la conversion.
	 */
    public static RoleModel convertToRoleModel(RoleEntity entity) {
        
    	if (entity == null) {
            return null;
        }
    	
    	EmpleadoModel empModel = convertToEmpleadoModel(entity.getEmpleadoId());

    	RoleModel roleModel = new RoleModel();
    	roleModel.setNombre(entity.getNombre());
    	roleModel.setEmpleado(empModel);
    	
        return roleModel;
    }

}
