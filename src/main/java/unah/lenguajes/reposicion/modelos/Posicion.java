package unah.lenguajes.reposicion.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity
@Table(name = "posicion")
public class Posicion {
 
    @Id
    @Column(name = "codigoequipo")
    private long  codigoEquipo;

    private long empate;

    private long ganados;

    private long perdidos;

    @Column(name="golesaFavor")
    private long golesFavor;
    
    @Column(name="golesenContra")
    private long golesenContra;

    private long puntos;

    @PrimaryKeyJoinColumn(name="codigoequipo")
    @JsonIgnore
    @OneToOne
    private Equipo equipo;


}
