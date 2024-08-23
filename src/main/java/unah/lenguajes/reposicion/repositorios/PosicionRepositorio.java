package unah.lenguajes.reposicion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.reposicion.modelos.Posicion;

@Repository
public interface PosicionRepositorio extends JpaRepository<Posicion, Long>{
     
    
}
