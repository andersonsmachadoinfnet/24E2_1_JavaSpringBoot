package br.anderson.infnet.appDr1Tp1.controller;

import br.anderson.infnet.appDr1Tp1.model.dominio.Produto;
import br.anderson.infnet.appDr1Tp1.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "")
    public Iterable<Produto> getLista() {
        return produtoService.obterLista();
    }

    @GetMapping(value = "/{id}")
    public Optional<Produto> getProduto(@PathVariable int id) {
        return produtoService.ler(id);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deletarProduto(@PathVariable int id) {
        produtoService.excluir(id);
        return true;
    }

    @PutMapping("")
    ResponseEntity<Optional<Produto>> setProduto(@RequestBody Produto produto) {
        Optional<Produto> lTmp;
        lTmp = produtoService.ler(produto.getId());
        if (lTmp.isEmpty()) {
            return new ResponseEntity<Optional<Produto>>(lTmp, HttpStatus.NOT_FOUND);
        }
        else {
            lTmp = Optional.ofNullable(produtoService.salvar(produto));
            return new ResponseEntity<Optional<Produto>>(lTmp, HttpStatus.OK);
        }
    }

    @PostMapping("")
    Produto novoProduto(@RequestBody Produto produto) {
        produtoService.incluir(produto);
        return produto;
    }
}
