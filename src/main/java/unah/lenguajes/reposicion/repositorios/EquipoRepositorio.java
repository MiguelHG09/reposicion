package unah.lenguajes.reposicion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.reposicion.modelos.Equipo;

@Repository
public interface EquipoRepositorio extends JpaRepository<Equipo, Long> {


}
    

