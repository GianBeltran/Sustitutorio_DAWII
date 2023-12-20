package pe.cibertec.edu.examenSusti.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.edu.examenSusti.model.bd.Docente;
import pe.cibertec.edu.examenSusti.model.request.DocenteRequest;
import pe.cibertec.edu.examenSusti.service.DocenteService;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/docente")
public class DocenteController {
    private DocenteService docenteService;

    @GetMapping("")
    public ResponseEntity<List<Docente>> listarDocentes(){
        List<Docente> docenteList = new ArrayList<>();
        docenteService.listarDocentes().forEach(docenteList::add);
        if(docenteList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(docenteList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Docente> guardarOActualizarDocente(@RequestBody DocenteRequest docenteRequest) {
        Docente docenteGuardado = docenteService.guardarDocente(docenteRequest);
        return new ResponseEntity<>(docenteGuardado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{iddocente}")
    public ResponseEntity<Void> eliminarDocente(@PathVariable Integer iddocente) {
        docenteService.eliminarDocente(iddocente);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
