package com.util;

import com.entity.EmpleadoEntity;
import com.entity.RoleEntity;
import com.model.EmpleadoModel;
import com.model.RoleModel;

public class Converter {
	
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
