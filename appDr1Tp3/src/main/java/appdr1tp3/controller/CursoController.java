package appdr1tp3.controller;

import appdr1tp3.model.domain.Curso;
import appdr1tp3.model.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoService _sc;

    @GetMapping(value="")
    public Iterable<Curso> getCursos(){
        return _sc.obterLista();
    }

    @GetMapping(value="{id}")
    public Optional<Curso> getCursoById(@PathVariable Integer id){
        return _sc.buscarCursoPorId(id);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deletarCurso(@PathVariable int id) {
        _sc.excluirCurso(id);
        return true;
    }

    @PutMapping("")
    ResponseEntity<Optional<Curso>> setPaciente(@RequestBody Curso curso) {
        Optional<Curso> lTmp;
        lTmp = _sc.buscarCursoPorId(curso.getId());
        if (lTmp.isEmpty()) {
            return new ResponseEntity<Optional<Curso>>(lTmp, HttpStatus.NOT_FOUND);
        }
        else {
            lTmp = Optional.ofNullable(_sc.incluir(curso));
            return new ResponseEntity<Optional<Curso>>(lTmp, HttpStatus.OK);
        }
    }

    @PostMapping("")
    Curso novoPaciente(@RequestBody Curso curso) {
        _sc.incluir(curso);
        return curso;
    }

}
