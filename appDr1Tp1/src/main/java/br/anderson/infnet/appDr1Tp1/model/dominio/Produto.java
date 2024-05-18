package br.anderson.infnet.appDr1Tp1.model.dominio;

import br.anderson.infnet.appDr1Tp1.model.auxiliar.Constantes;
import jakarta.persistence.*;

@Entity
@Table(name = "TProduto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String nome;
    private  String ean;
    private   Float preco;

    public Produto() {
        // Construtor padrão requerido pelo framework
    }

    public Produto(String nome, String ean, Float preco) {
        super();
        //this.id = id;
        this.nome = nome;
        this.ean = ean;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(id).append(Constantes.SEPARADOR)
                .append(nome).append(Constantes.SEPARADOR)
                .append(ean).append(Constantes.SEPARADOR)
                .append(preco).append(Constantes.SEPARADOR)
                .toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
}
