package br.anderson.infnet.appdr4at.controller;

import br.anderson.infnet.appdr4at.model.domain.Funcionario;
import br.anderson.infnet.appdr4at.model.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService _sc;

    @GetMapping(value="")
    public Iterable<Funcionario> getFuncionarios(){
        return _sc.obterLista();
    }

    @GetMapping(value="{id}")
    public Optional<Funcionario> getFuncionarioById(@PathVariable Integer id){
        return _sc.buscarPorId(id);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deletar(@PathVariable int id) {
        _sc.excluir(id);
        return true;
    }

    @PutMapping("")
    ResponseEntity<Optional<Funcionario>> setFuncionario(@RequestBody Funcionario itm) {
        Optional<Funcionario> lTmp;
        lTmp = _sc.buscarPorId(itm.getId());
        if (lTmp.isEmpty()) {
            return new ResponseEntity<Optional<Funcionario>>(lTmp, HttpStatus.NOT_FOUND);
        }
        else {
            lTmp = Optional.ofNullable(_sc.incluir(itm));
            return new ResponseEntity<Optional<Funcionario>>(lTmp, HttpStatus.OK);
        }
    }

    @PostMapping("")
    Funcionario novo(@RequestBody Funcionario itm) {
        _sc.incluir(itm);
        return itm;
    }
}
