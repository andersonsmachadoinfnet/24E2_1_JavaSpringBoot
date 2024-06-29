package br.anderson.infnet.appDr1Tp1.model.dominio;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TUsuario")
public class Usuario  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private    int id;
    private String nome;
    private String senha;
    private String email;
    private    int tipo; //0=Administrador;1=Geral

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idPaciente")
    private List<Paciente> pacientes;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idProntuario")
    private List<Prontuario> prontuario;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idProcedimento")
    private List<Procedimento> procedimento;

    public List<Procedimento> getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(List<Procedimento> procedimento) {
        this.procedimento = procedimento;
    }

    public List<Prontuario> getProntuario() {
        return prontuario;
    }

    public void setProntuario(List<Prontuario> prontuario) {
        this.prontuario = prontuario;
    }

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha) {
        this();
        this.setId(-1);
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
    }

    public Usuario(String email, String senha) {
        this("", email, senha);
    }

    public String toString() {
        return String.format("Usuário: %s (%s) [%s]", nome, email, getUserIdLabel());
    }

    public int getId() {
        return id;
    }

    public String getUserIdLabel( ) {
        if (this.id==-1) {
            return "Sem identificador!";
        }
        else {
            return String.valueOf(this.id);
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }
    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
