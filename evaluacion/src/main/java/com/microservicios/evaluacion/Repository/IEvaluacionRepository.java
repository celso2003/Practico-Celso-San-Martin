package com.microservicios.evaluacion.Repository;

import com.microservicios.evaluacion.Entities.EvaluacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEvaluacionRepository extends JpaRepository<EvaluacionEntity, Integer> {

}