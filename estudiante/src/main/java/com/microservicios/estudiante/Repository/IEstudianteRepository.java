package com.microservicios.estudiante.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservicios.estudiante.Entities.EstudianteEntity;

public interface IEstudianteRepository extends JpaRepository<EstudianteEntity, Integer> {
  
}
