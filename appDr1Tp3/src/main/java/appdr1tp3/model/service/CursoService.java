package appdr1tp3.model.service;

import appdr1tp3.model.domain.Aluno;
import appdr1tp3.model.domain.Curso;
import appdr1tp3.model.domain.faker.AlunoFaker;
import appdr1tp3.model.domain.faker.CursoFaker;
import appdr1tp3.model.repository.AlunoRepository;
import appdr1tp3.model.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository _rps;
    @Autowired
    private AlunoRepository _ar;


    public CursoService(CursoRepository rps, AlunoRepository ar) {
        _rps = rps;
        _ar  = ar;
        Aluno a;

        if (_rps.count()==0) {
            Curso curso = CursoFaker.getCurso();
            _rps.save(curso);
            a = AlunoFaker.getAluno();
            a.getCursos().add(curso);
            _ar.save(a);
            a = AlunoFaker.getAluno();
            a.getCursos().add(curso);
            _ar.save(a);
            a = AlunoFaker.getAluno();
            a.getCursos().add(curso);
            _ar.save(a);
        }
    }

    public Curso incluir(Curso itm) {
        return _rps.save(itm);
    }

    @Cacheable(value="curso", key="#id")
    public Optional<Curso> buscarCursoPorId(Integer id) {
        return _rps.findById(id);
    }

    @CacheEvict(value="curso", key="#id")
    public void excluirCurso(Integer id) {
        _rps.deleteById(id);
    }

    @CacheEvict(value="curso", key="#id")
    public Curso alterar(Integer id, Curso itm) {
        Curso curso = _rps.getReferenceById(id);
        return _rps.save(curso.assign(itm));
    }

    @Cacheable(value="Cursos")
    public Collection<Curso> obterLista() {
        return _rps.findAll();
    }
}
