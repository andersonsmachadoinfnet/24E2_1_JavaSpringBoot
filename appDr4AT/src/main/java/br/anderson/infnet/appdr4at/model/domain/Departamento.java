package br.anderson.infnet.appdr4at.model.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import br.anderson.infnet.appdr4at.model.domain.Funcionario;


@Entity
@Table(name = "TDepartamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String nome;
    private  String local;

    @OneToMany(mappedBy = "departamentoId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios = new ArrayList<>();

    public Departamento() {
        this.funcionarios = new ArrayList<>();
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Departamento assign(Departamento de) {
        this.setNome(de.getNome());
        this.setLocal(de.getLocal());
        this.setFuncionarios(de.getFuncionarios());
        return this;
    }
}
