package br.anderson.infnet.appdr4at.model.service;

import br.anderson.infnet.appdr4at.model.domain.Departamento;
import br.anderson.infnet.appdr4at.model.domain.faker.DepartamentoFaker;
import br.anderson.infnet.appdr4at.model.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository _rps;

    public DepartamentoService(DepartamentoRepository _rps) {
        this._rps = _rps;
        if (this._rps.count() == 0) {
            _rps.save(DepartamentoFaker.getDepartamento());
            _rps.save(DepartamentoFaker.getDepartamento());
            _rps.save(DepartamentoFaker.getDepartamento());
        }
    }

    public Departamento incluir(Departamento itm) {
        return _rps.save(itm);
    }

    @Cacheable(value="departamento", key="#id")
    public Optional<Departamento> buscarPorId(Integer id) {
        return _rps.findById(id);
    }

    @CacheEvict(value="departamento", key="#id")
    public void excluir(Integer id) {
        _rps.deleteById(id);
    }

    @CacheEvict(value="departamento", key="#id")
    public Departamento alterar(Integer id, Departamento itm) {
        Departamento _itm = _rps.getReferenceById(id);
        return _rps.save(_itm.assign(itm));
    }

    @Cacheable(value="departamento")
    public Collection<Departamento> obterLista() {
        return _rps.findAll();
    }
}
