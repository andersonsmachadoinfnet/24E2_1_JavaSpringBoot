package appdr1tp3.model.domain.faker;

import appdr1tp3.model.auxiliar.Faker;
import appdr1tp3.model.domain.Aluno;

public class AlunoFaker {
    public static Aluno getAluno() {
        return new Aluno(Faker.getNome(), "Rua "+Faker.getNome(), "(21) 5555-5555");
    }
}
