package appdr1tp3.model.domain.faker;

import appdr1tp3.model.domain.Curso;

public class CursoFaker {
    public static Curso getCurso() {
        Curso curso = new Curso();
        curso.setDisciplina("Desenvolvimento de Serviços com Spring Boot");
        curso.setProfessor("Ricardo Frohlich da Silva");

        return curso;
    }
}
