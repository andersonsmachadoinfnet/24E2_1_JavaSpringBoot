package br.anderson.infnet.appDr1Tp1.controller;

import br.anderson.infnet.appDr1Tp1.model.dominio.Paciente;
import br.anderson.infnet.appDr1Tp1.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping(value = "")
    public Iterable<Paciente> getLista() {
        return pacienteService.obterLista();
    }

    @GetMapping(value = "/{id}")
    public Optional<Paciente> getPaciente(@PathVariable int id) {
        return pacienteService.ler(id);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deletarPaciente(@PathVariable int id) {
        pacienteService.excluir(id);
        return true;
    }

    @PutMapping("")
    ResponseEntity<Optional<Paciente>> setPaciente(@RequestBody Paciente paciente) {
        Optional<Paciente> lTmp;
        lTmp = pacienteService.ler(paciente.getId());
        if (lTmp.isEmpty()) {
            return new ResponseEntity<Optional<Paciente>>(lTmp, HttpStatus.NOT_FOUND);
        }
        else {
            lTmp = Optional.ofNullable(pacienteService.salvar(paciente));
            return new ResponseEntity<Optional<Paciente>>(lTmp, HttpStatus.OK);
        }
    }

    @PostMapping("")
    Paciente novoPaciente(@RequestBody Paciente paciente) {
        pacienteService.incluir(paciente);
        return paciente;
    }
}
