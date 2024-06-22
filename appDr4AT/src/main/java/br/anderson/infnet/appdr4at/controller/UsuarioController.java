package br.anderson.infnet.appdr4at.controller;

import br.anderson.infnet.appdr4at.model.domain.Usuario;
import br.anderson.infnet.appdr4at.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService _sc;

    @GetMapping(value = "")
    public Iterable<Usuario> getUsuario() {
        return _sc.obterLista();
    }

    @PutMapping(value = "")
    Usuario setPaciente(@RequestBody Usuario itm) {
        return _sc.incluir(itm);
    }
}
