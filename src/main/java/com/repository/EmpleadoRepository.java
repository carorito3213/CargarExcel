package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.EmpleadoEntity;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity,String>  {
	
	

}



