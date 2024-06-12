package appdr1tp3.model.domain;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "TCuso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private     Integer id;
    private      String professor;
    private      String disciplina;

    //@OneToMany(mappedBy = "cursoId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ManyToMany(mappedBy = "cursos")
    private List<Aluno> alunos = new ArrayList<>();

    public Curso() {
        this.alunos = new ArrayList<Aluno>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void addAluno(Aluno aluno) {
        aluno.getCursos().add(this);//.id);
        //this.alunos.add(aluno);
    }

    public Curso assign(Curso de) {
        professor  = de.getProfessor();
        disciplina = de.getDisciplina();
        this.alunos.clear();
        for( Aluno aluno : de.getAlunos() ) {
            addAluno(aluno);
        }
        return this;
    }
}
