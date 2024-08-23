package unah.lenguajes.reposicion.controladores;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import unah.lenguajes.reposicion.modelos.Posicion;
import unah.lenguajes.reposicion.servicios.PosicionServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/posiciones")
@RestController
public class PosicionControlador {
    
    @Autowired
    private PosicionServicio PosicionServicio;

    @GetMapping("/obtener/todos")
    public List<Posicion> obtenerTodos(){
        return this.PosicionServicio.obtenerTodos();

    }

@GetMapping("/simular/partidos")
public List<Posicion> simularPartidos(){
    return this.PosicionServicio.simularPartidos();

    }


}
    

