package br.anderson.infnet.appDr1Tp1.service;

import br.anderson.infnet.appDr1Tp1.model.dominio.Produto;
import br.anderson.infnet.appDr1Tp1.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    private void _populaDados() {
        if (repository.count()==0) {
            repository.save(new Produto("Coca Cola 2l","7894900011517",(float)9.75));
            repository.save(new Produto("Pao Plusvita 480g","7896002306348",(float)59.90));
            repository.save(new Produto("Feijao Picinin 1kg","7896864400192",(float)7.99));
        }
    }

    public ProdutoService(){
        super();
    }

    public Produto incluir(Produto item) {
        item.setId(null);
        return repository.save(item);
    }

    public Optional<Produto> ler(Integer key) {
        return repository.findById(key);
    }

    public void excluir(Integer key) {
        repository.deleteById(key);
    }

    public Collection<Produto> obterLista(){
        _populaDados();
        return (Collection<Produto>) repository.findAll();
    }

    public Produto salvar(Produto item) {
        return repository.save(item);
    }
}
