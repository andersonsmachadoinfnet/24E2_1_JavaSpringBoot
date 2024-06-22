package br.anderson.infnet.appdr4at.controller;

import br.anderson.infnet.appdr4at.model.domain.Departamento;
import br.anderson.infnet.appdr4at.model.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Departamento")
public class DepartamentoController {
    @Autowired
    private DepartamentoService _sc;

    @GetMapping(value="")
    public Iterable<Departamento> getDepartamentos(){
        return _sc.obterLista();
    }

    @GetMapping(value="{id}")
    public Optional<Departamento> getDepartamentoById(@PathVariable Integer id){
        return _sc.buscarPorId(id);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deletar(@PathVariable Integer id) {
        _sc.excluir(id);
        return true;
    }

    @PutMapping("")
    ResponseEntity<Optional<Departamento>> setDepartamento(@RequestBody Departamento itm) {
        Optional<Departamento> lTmp;
        lTmp = _sc.buscarPorId(itm.getId());
        if (lTmp.isEmpty()) {
            return new ResponseEntity<Optional<Departamento>>(lTmp, HttpStatus.NOT_FOUND);
        }
        else {
            lTmp = Optional.ofNullable(_sc.incluir(itm));
            return new ResponseEntity<Optional<Departamento>>(lTmp, HttpStatus.OK);
        }
    }

    @PostMapping("")
    Departamento novo(@RequestBody Departamento itm) {
        _sc.incluir(itm);
        return itm;
    }
}
