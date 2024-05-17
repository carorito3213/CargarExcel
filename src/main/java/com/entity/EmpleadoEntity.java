package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(name="Empleado", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class EmpleadoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleado_generator")
	@SequenceGenerator(name = "empleado_generator", sequenceName = "empleado_seq", allocationSize = 1)
	Integer id;
	String nombre;
	String apellido;
	String email;
	String telefono;
	
	@OneToOne(mappedBy = "empleado")
	RoleEntity rol;
	
	public EmpleadoEntity() {
		super();
	}

	public EmpleadoEntity(Integer id, String nombre, String apellido, String email, String telefono, RoleEntity rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.rol = rol;
	}
	
	public EmpleadoEntity(String nombre, String apellido, String email, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public RoleEntity getRol() {
		return rol;
	}

	public void setRol(RoleEntity rol) {
		this.rol = rol;
	}
	
	
	
}
