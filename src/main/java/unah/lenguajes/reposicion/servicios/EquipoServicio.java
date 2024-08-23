package unah.lenguajes.reposicion.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.reposicion.repositorios.EquipoRepositorio;
import unah.lenguajes.reposicion.repositorios.PosicionRepositorio;
import unah.lenguajes.reposicion.modelos.Equipo;


@Service
public class EquipoServicio {

    @Autowired
    private EquipoRepositorio equipoRepositorio;

    @Autowired
    private PosicionRepositorio posicionRepositorio;

    public List<Equipo> obtenerTodos(){
        return this.equipoRepositorio.findAll();
    }

    public Equipo crearEquipo(Equipo nuevoEquipo){
        return this.equipoRepositorio.save(nuevoEquipo);
    }

    public Equipo buscarPorCodigo(long codigoEquipo){
        return this.equipoRepositorio.findById(codigoEquipo).get();

    }

    public String eliminarPorCodigo(long codigoEquipo){
        if(this.equipoRepositorio.existsById(codigoEquipo)){
            if(!this.posicionRepositorio.existsById(codigoEquipo)){
                this.equipoRepositorio.deleteById(codigoEquipo);
                return "El equipo fue eliminado.";
            }
    }
    if(this.posicionRepositorio.existsById(codigoEquipo)){
        return "El equipo esta registrado en la tabla de Posiciones";
    }
    return "El equipo no existe";
 }
}

