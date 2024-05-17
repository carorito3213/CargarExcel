package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="Role", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class RoleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_generator")
	@SequenceGenerator(name = "role_generator", sequenceName = "role_seq", allocationSize = 1)
	private Integer id;
	private String nombre;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
	private EmpleadoEntity empleado;

	public RoleEntity() {
		super();
	}

	public RoleEntity(Integer id, String nombre, EmpleadoEntity empleadoId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.empleado = empleadoId;
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

	public EmpleadoEntity getEmpleadoId() {
		return empleado;
	}

	public void setEmpleadoId(EmpleadoEntity empleado) {
		this.empleado = empleado;
	}
	
	
		
}
