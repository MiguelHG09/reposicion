package unah.lenguajes.reposicion.servicios;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unah.lenguajes.reposicion.modelos.Posicion;
import unah.lenguajes.reposicion.repositorios.PosicionRepositorio;

@Service
public class PosicionServicio {
    @Autowired
    private PosicionRepositorio posicionRepositorio;

    public List<Posicion> obtenerTodos(){
        return this.posicionRepositorio.findAll();
    }

    public List<Posicion> simularPartidos(){
        
        int numeroEquipos = this.posicionRepositorio.findAll().size();
        List<Posicion> equipos = new ArrayList<Posicion>();
        equipos = this.posicionRepositorio.findAll();
        Random random = new Random();

        // Revisar si existen al menos 6 equipos
        if(equipos.size() < 6){
            return null;
        }else{
        for (int i = 0; i < numeroEquipos; i++) {
            for (int k = 0; k < numeroEquipos; k++) {
                if(i != k){
                    // Realizar el enfrentamiento
                    // Generar numero de goles de cada equipo
                    int golesPrimerEquipo = random.nextInt(7);
                    int golesSegundoEquipo = random.nextInt(7);

                    equipos.get(i).getGolesFavor();
                    equipos.get(k).getGolesFavor();

                    //  Obtener los goles que ya se tenian y sumarlos con los goles recien generados
                    long golesPrimerEquipoAcum = equipos.get(i).getGolesFavor() + golesPrimerEquipo;
                    long golesSegundoEquipoAcum = equipos.get(k).getGolesFavor() + golesSegundoEquipo;
                   
                    // Establecer los goles acumulados en la propiedad del objeto
                    equipos.get(i).setGolesFavor(golesPrimerEquipoAcum);
                    equipos.get(k).setGolesFavor(golesSegundoEquipoAcum);

                    // Mismo procedimiento para establecer los goles en contra
                    long golesPrimerEquipoAcumContra = equipos.get(i).getGolesenContra() + golesSegundoEquipo;
                    long golesSegundoEquipoAcumContra = equipos.get(k).getGolesenContra() + golesPrimerEquipo;

                    equipos.get(i).setGolesenContra(golesPrimerEquipoAcumContra);
                    equipos.get(k).setGolesenContra(golesSegundoEquipoAcumContra);

                    // Caso 1: Victoria del primer equipo
                    if(golesPrimerEquipo > golesSegundoEquipo){
                        // Sumarle una victoria al primer equipo
                        long ganados = equipos.get(i).getGanados();
                        ganados++;
                        equipos.get(i).setGanados(ganados);

                        // Sumarle una derrota al segundo equipo
                        long derrotas = equipos.get(k).getPerdidos();
                        derrotas++;
                        equipos.get(k).setPerdidos(derrotas);
                        
                        // Sumarle tres puntos al primer equipo por la victoria
                        long puntosPrimerEquipo = equipos.get(i).getPuntos() + 3;
                        equipos.get(i).setPuntos(puntosPrimerEquipo);
                    }

                    // Caso 2: Victoria del segundo equipo
                    if(golesPrimerEquipo < golesSegundoEquipo){
                        // Sumarle una victoria al segundo equipo
                        long ganados = equipos.get(k).getGanados();
                        ganados++;
                        equipos.get(k).setGanados(ganados);

                        // Sumarle una derrota al primer equipo
                        long derrotas = equipos.get(i).getPerdidos();
                        derrotas++;
                        equipos.get(i).setPerdidos(derrotas);
                        
                        // Sumarle tres puntos al segundo equipo por la victoria
                        long puntosSegundoEquipo = equipos.get(k).getPuntos() + 3;
                        equipos.get(k).setPuntos(puntosSegundoEquipo);
                    }

                    // Caso 3: Empate
                    if(golesPrimerEquipo == golesSegundoEquipo){
                        // Sumarle un empate a ambos equipos
                        long empates1 = equipos.get(i).getEmpate();
                        empates1++;
                        equipos.get(i).setEmpate(empates1);
                       
                        long empates2 = equipos.get(k).getEmpate();
                        empates2++;
                        equipos.get(k).setEmpate(empates2);
                        
                        //Sumarle un punto a ambos equipos
                        long puntosPorEmpate1 = equipos.get(i).getPuntos() + 1;
                        equipos.get(i).setPuntos(puntosPorEmpate1);

                        long puntosPorEmpate2 = equipos.get(k).getPuntos() + 1;
                        equipos.get(k).setPuntos(puntosPorEmpate2);
                    }
                }
            }
        }
    }
    // Guardar todos los cambios mediante el repositorio
        this.posicionRepositorio.saveAll(equipos);
        return equipos;
    }

}


