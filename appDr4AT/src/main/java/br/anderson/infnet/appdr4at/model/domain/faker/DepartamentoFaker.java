package br.anderson.infnet.appdr4at.model.domain.faker;

import br.anderson.infnet.appdr4at.model.auxiliar.Faker;
import br.anderson.infnet.appdr4at.model.domain.Departamento;

public class DepartamentoFaker {
    public static Departamento getDepartamento() {
        Departamento d = new Departamento();
        d.setNome(Faker.getDEPARTAMENTO());
        return d;
    }
}
