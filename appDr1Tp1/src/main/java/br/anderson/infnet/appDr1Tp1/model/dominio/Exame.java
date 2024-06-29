package br.anderson.infnet.appDr1Tp1.model.dominio;

import br.anderson.infnet.appDr1Tp1.model.auxiliar.Constantes;
import br.anderson.infnet.appDr1Tp1.model.auxiliar.ProcedimentoTipo;
import br.anderson.infnet.appDr1Tp1.model.auxiliar.PacienteTipo;
import br.anderson.infnet.appDr1Tp1.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appDr1Tp1.model.exceptions.ValorInvalidoException;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TExame")
public class Exame extends Procedimento {
    private String resultado;

    public Exame() {
        // TODO Auto-generated constructor stub
    }

    public Exame(String descricao, float valor)
            throws ValorInvalidoException, DescricaoInvalidaException {
        super(ProcedimentoTipo.EXAME, descricao, valor);
        this.resultado = Constantes.EXAME_NAO_AVALIADO;
    }

    @Override
    public float calcularValorDoProcedimento(PacienteTipo pPacienteTp) {
        return super.getValor()*pPacienteTp.ratio();
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
