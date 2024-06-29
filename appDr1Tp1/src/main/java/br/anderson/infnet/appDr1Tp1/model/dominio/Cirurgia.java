package br.anderson.infnet.appDr1Tp1.model.dominio;

import br.anderson.infnet.appDr1Tp1.model.auxiliar.ProcedimentoTipo;
import br.anderson.infnet.appDr1Tp1.model.auxiliar.PacienteTipo;
import br.anderson.infnet.appDr1Tp1.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appDr1Tp1.model.exceptions.ValorInvalidoException;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TCirurgia")
public class Cirurgia extends Procedimento {
    private String indicadoPara;

    public Cirurgia() {
        // TODO Auto-generated constructor stub
    }

    public Cirurgia(/*ProcedimentoTipo pTipo, */String descricao, float valor, String indicadoPara)
            throws ValorInvalidoException, DescricaoInvalidaException {
        super(ProcedimentoTipo.CIRURGIA, descricao, valor);
        this.indicadoPara = indicadoPara;
    }

    @Override
    public float calcularValorDoProcedimento(PacienteTipo pPacienteTp) {
        return super.getValor()*pPacienteTp.ratio();
    }

    public String getIndicadoPara() {
        return indicadoPara;
    }
}
