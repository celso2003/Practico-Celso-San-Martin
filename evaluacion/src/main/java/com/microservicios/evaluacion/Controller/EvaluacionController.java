package com.microservicios.evaluacion.Controller;

import com.microservicios.evaluacion.Entities.EvaluacionEntity;
import com.microservicios.evaluacion.Repository.IEvaluacionRepository;
import com.microservicios.evaluacion.Service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    @Autowired
    private IEvaluacionRepository evaluacionRepository;

    @Autowired
    private EstudianteService estudianteService;

    //Consultar todas las evaluaciones
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EvaluacionEntity> getAllEvaluaciones() {
        return evaluacionRepository.findAll();
    }

    //Consultar una evaluación por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EvaluacionEntity> getById(@PathVariable Integer id) {
        return evaluacionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Crear una nueva evaluación
    @PostMapping
    public ResponseEntity<String> saveEvaluacion(@RequestBody EvaluacionEntity evaluacion) {
        if (!estudianteService.existeEstudiante(evaluacion.getRutEstudiante())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El estudiante con RUT " + evaluacion.getRutEstudiante() + " no existe.");
        }
        evaluacionRepository.save(evaluacion);
        return ResponseEntity.status(HttpStatus.CREATED).body("Evaluación creada con éxito.");
    }
}
