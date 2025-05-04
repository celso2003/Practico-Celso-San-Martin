package com.microservicios.estudiante.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservicios.estudiante.Entities.EstudianteEntity;
import com.microservicios.estudiante.Repository.IEstudianteRepository;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

  @Autowired
  private IEstudianteRepository estudianteRepository;

  //Consultar todos los estudiantes
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<EstudianteEntity> getAllEstudiantes() {
    return estudianteRepository.findAll();
  }

  //Consultar un estudiante por su RUT
  @GetMapping("/{rut}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<EstudianteEntity> getByRut(@PathVariable Integer rut) {
    return estudianteRepository.findById(rut)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  //Crear un nuevo estudiante
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createEstudiante(@RequestBody EstudianteEntity estudiante) {
    estudianteRepository.save(estudiante);
  }
}
