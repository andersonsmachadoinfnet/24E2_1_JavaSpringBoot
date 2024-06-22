package br.anderson.infnet.appdr4at.model.service;

import br.anderson.infnet.appdr4at.model.domain.Usuario;
import br.anderson.infnet.appdr4at.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository _rps;

    public UsuarioService(UsuarioRepository _rps) {
        this._rps = _rps;
        if (_rps.count()==0) {
            Usuario u = new Usuario();
            u.setNome("Admin");
            u.setPapel("Administrador");
            u.setSenha("1234");
            _rps.save(u);
        }
    }

    public Usuario incluir(Usuario itm) {
        return _rps.save(itm);
    }

    public Collection<Usuario> obterLista() {
        return _rps.findAll();
    }
}
