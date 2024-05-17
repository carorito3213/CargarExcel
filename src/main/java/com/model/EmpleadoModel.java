package com.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpleadoModel {
	
	String nombre;
	String apellido;
	String email;
	String telefono;
	RoleModel rol;
	
	public EmpleadoModel() {
		super();
	}
	
	public EmpleadoModel(String nombre, String apellido, String email, String telefono, RoleModel rol) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.rol = rol;
	}
	
	public EmpleadoModel(String nombre, String apellido, String email, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public RoleModel getRol() {
		return rol;
	}
	public void setRol(RoleModel rol) {
		this.rol = rol;
	}
	
	
	
}
