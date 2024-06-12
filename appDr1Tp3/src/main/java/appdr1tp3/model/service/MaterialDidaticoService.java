package appdr1tp3.model.service;

import appdr1tp3.model.domain.Curso;
import appdr1tp3.model.domain.MaterialDidatico;
import appdr1tp3.model.repository.MaterialDidaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MaterialDidaticoService {
    @Autowired
    private MaterialDidaticoRepository _rps;

    public MaterialDidaticoService(MaterialDidaticoRepository rps) {
        _rps = rps;
        if (_rps.count()==0) {
            MaterialDidatico m = new MaterialDidatico();
            m.setMaterial("Borracha");
            _rps.save(m);
            m.setMaterial("Quadro");
            _rps.save(m);
            m.setMaterial("Giz");
            _rps.save(m);
            m.setMaterial("Apagador");
            _rps.save(m);
        }
    }

    public MaterialDidatico incluir(MaterialDidatico itm) {
        return _rps.save(itm);
    }

    public Collection<MaterialDidatico> obterLista() {
        return _rps.findAll();
    }
}
