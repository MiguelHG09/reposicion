package unah.lenguajes.reposicion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import unah.lenguajes.reposicion.modelos.Equipo;
import unah.lenguajes.reposicion.servicios.EquipoServicio;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoServicio equipoServicio;

    @GetMapping("/obtener/todos")
    public List<Equipo> obtenerTodos(){
        return this.equipoServicio.obtenerTodos();
    }

    @PostMapping("/crear/equipo/")
    public Equipo crearEquipo(@RequestBody Equipo nvoEquipo){
        return this.equipoServicio.crearEquipo(nvoEquipo);
    }

    @GetMapping("/buscar/{codigoEquipo}")
    public Equipo buscarporCodigo(@PathVariable long codigoEquipo){
        return this.equipoServicio.buscarPorCodigo(codigoEquipo);
    }    
    
    @DeleteMapping("/eliminar/{codigoEquipo}")
    public String eliminarporCodigo(@PathVariable long codigoEquipo){
        return this.equipoServicio.eliminarPorCodigo(codigoEquipo);
    }
}
