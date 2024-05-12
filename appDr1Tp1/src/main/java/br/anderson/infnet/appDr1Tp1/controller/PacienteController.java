package br.anderson.infnet.appDr1Tp1.controller;

import br.anderson.infnet.appDr1Tp1.model.dominio.Paciente;
import br.anderson.infnet.appDr1Tp1.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping(value = "/paciente")
    public Iterable<Paciente> getLista() {
        return pacienteService.obterLista();
    }

    @GetMapping(value = "/paciente/{id}")
    public Optional<Paciente> getPaciente(@PathVariable int id) {
        return pacienteService.ler(id);
    }

    @DeleteMapping(value = "/paciente/{id}")
    public boolean deletarPaciente(@PathVariable int id) {
        pacienteService.excluir(id);
        return true;
    }

    @PostMapping("/paciente")
    Paciente setPaciente(@RequestBody Paciente paciente) {
        if (pacienteService.ler(paciente.getId()).isEmpty()) {

        }
        pacienteService.incluir(paciente);
        return paciente;
    }

    @PutMapping("/paciente")
    Paciente novoPaciente(@RequestBody Paciente paciente) {
        pacienteService.incluir(paciente);
        return paciente;
    }
}
