package appdr1tp3.controller;

import appdr1tp3.model.domain.Curso;
import appdr1tp3.model.domain.MaterialDidatico;
import appdr1tp3.model.service.MaterialDidaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/materialdidatico")
public class MaterialDidaticoController {
    @Autowired
    private MaterialDidaticoService _sc;

    @GetMapping(value = "")
    public Iterable<MaterialDidatico> getMaterialDidatico() {
        return _sc.obterLista();
    }

    @PutMapping(value = "")
    MaterialDidatico setPaciente(@RequestBody MaterialDidatico material) {
        return _sc.incluir(material);
    }
}