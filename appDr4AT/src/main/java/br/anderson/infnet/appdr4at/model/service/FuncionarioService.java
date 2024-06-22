package br.anderson.infnet.appdr4at.model.service;

import br.anderson.infnet.appdr4at.model.auxiliar.Faker;
import br.anderson.infnet.appdr4at.model.domain.Departamento;
import br.anderson.infnet.appdr4at.model.domain.Funcionario;
import br.anderson.infnet.appdr4at.model.domain.faker.FuncionarioFaker;
import br.anderson.infnet.appdr4at.model.repository.DepartamentoRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import br.anderson.infnet.appdr4at.model.repository.FuncionarioRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository _rps;
    @Autowired
    private DepartamentoRepository _drs;

    public FuncionarioService(FuncionarioRepository rps, DepartamentoRepository drs) {
        this._rps = rps;
        this._drs = drs;
        if (this._rps.count() == 0) {
            for(Departamento d : _drs.findAll()) {
                for (int i=0; i< Faker.getNumero(10); i++) {
                    _rps.save(FuncionarioFaker.getFuncionario(d));
                }
            }
        }
    }

    public Funcionario incluir(Funcionario itm) {
        return _rps.save(itm);
    }

    @Cacheable(value="funcionario", key="#id")
    public Optional<Funcionario> buscarPorId(Integer id) {
        return _rps.findById(id);
    }

    @CacheEvict(value="funcionario", key="#id")
    public void excluir(Integer id) {
        _rps.deleteById(id);
    }

    @CacheEvict(value="funcionario", key="#id")
    public Funcionario alterar(Integer id, Funcionario itm) {
        Funcionario _itm = _rps.getReferenceById(id);
        return _rps.save(_itm.assign(itm));
    }

    @Cacheable(value="funcionario")
    public Collection<Funcionario> obterLista() {
        return _rps.findAll();
    }
}
