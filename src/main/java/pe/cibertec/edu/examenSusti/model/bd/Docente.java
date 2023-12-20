package pe.cibertec.edu.examenSusti.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "docente")
@Data @AllArgsConstructor @NoArgsConstructor
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddocente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "dni")
    private String dni;

    @Column(name = "fechanacimiento")
    private Date fechanacimiento;

    @Column(name = "sueldo")
    private Double sueldo;

    @Column(name = "email")
    private String email;

    @Column(name = "sexo")
    private String sexo;

    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;

}
