package appdr1tp3.model.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TAluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matricula;
    private  String nome;
    private  String endereco;
    private  String Telefone;
    //@JoinColumn(name="cursoId")
    //private Integer cursoId;
    @ManyToMany
    @JoinTable(
            name = "curso_aluno",
            joinColumns = @JoinColumn(name = "aluno_matricula"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> cursos = new ArrayList<Curso>();

    public Aluno() {
    }

    public Aluno(String nome, String endereco, String Telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.Telefone = Telefone;
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
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
