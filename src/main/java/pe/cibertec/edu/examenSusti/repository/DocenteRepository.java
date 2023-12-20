package pe.cibertec.edu.examenSusti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.edu.examenSusti.model.bd.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> {
}
