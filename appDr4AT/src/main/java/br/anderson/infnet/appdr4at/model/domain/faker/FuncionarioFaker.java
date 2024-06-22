package br.anderson.infnet.appdr4at.model.domain.faker;

import br.anderson.infnet.appdr4at.model.auxiliar.Faker;
import br.anderson.infnet.appdr4at.model.domain.Departamento;
import br.anderson.infnet.appdr4at.model.domain.Funcionario;

public class FuncionarioFaker {
    public static Funcionario getFuncionario(Departamento departamento) {
        Funcionario f = new Funcionario();
        f.setNome(Faker.getNome());
        f.setEmail(Faker.getEmail(f.getNome()));
        f.setEndereco("Rua "+Faker.getNome()+", nº "+ Faker.getNumero(255));
        f.setTelefone(Faker.getNumero(5555555).toString());
        f.setDataNascimento(Faker.getDtNasc());
        f.setDepartamentoId(departamento.getId());
        return f;
    }
}
