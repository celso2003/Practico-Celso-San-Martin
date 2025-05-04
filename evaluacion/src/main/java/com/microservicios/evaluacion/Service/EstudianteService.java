package com.microservicios.evaluacion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EstudianteService {

    @Autowired
    private RestTemplate restTemplate;

    public boolean existeEstudiante(int rutEstudiante) {
        String url = "http://estudiante-service:8080/api/estudiantes/" + rutEstudiante; 
                                                                                        
        try {
            restTemplate.getForObject(url, Object.class);
            return true; 
        } catch (Exception e) {
            return false; 
        }
    }
}
