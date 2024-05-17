package com.model;

public class RoleModel {
	
	private String nombre;
	private EmpleadoModel empleado;
	
	

	public RoleModel() {
		super();
	}

	public RoleModel(String nombre) {
		super();
		this.nombre = nombre;
	}


	public RoleModel(String nombre, EmpleadoModel empleado) {
		super();
		this.nombre = nombre;
		this.empleado = empleado;
	}

	
	


	public EmpleadoModel getEmpleado() {
		return empleado;
	}



	public void setEmpleado(EmpleadoModel empleado) {
		this.empleado = empleado;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
}
