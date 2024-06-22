package br.anderson.infnet.appdr4at.model.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "TFuncionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String nome;
    private  String endereco;
    private  String telefone;
    private  String email;
    private LocalDate dataNascimento;
    private Integer departamentoId;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }

    public Funcionario assign(Funcionario de) {
        this.setDepartamentoId(de.getDepartamentoId());
        this.setTelefone(de.getTelefone());
        this.setEndereco(de.getEndereco());
        this.setEmail(de.getEmail());
        this.setTelefone(de.getTelefone());
        this.setDepartamentoId(de.getDepartamentoId());
        this.setEndereco(de.getEndereco());
        return this;
    }
}
