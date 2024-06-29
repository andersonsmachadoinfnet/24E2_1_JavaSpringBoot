package br.anderson.infnet.appDr1Tp1.model.dominio;

import br.anderson.infnet.appDr1Tp1.model.auxiliar.Constantes;
import br.anderson.infnet.appDr1Tp1.model.auxiliar.ProcedimentoTipo;
import br.anderson.infnet.appDr1Tp1.model.auxiliar.PacienteTipo;
import br.anderson.infnet.appDr1Tp1.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appDr1Tp1.model.exceptions.ValorInvalidoException;
import jakarta.persistence.*;

@Entity
@Table(name = "TMedicamento")
public class Medicamento extends Procedimento {
    private String bula;

    public Medicamento() {
        // TODO Auto-generated constructor stub
    }

    public Medicamento(/*ProcedimentoTipo pTipo, */String descricao, float valor, String bula)
            throws ValorInvalidoException, DescricaoInvalidaException {
        super(ProcedimentoTipo.MEDICAMENTO, descricao, valor);
        this.bula = bula;
    }

    @Override
    public float calcularValorDoProcedimento(PacienteTipo pPacienteTp) {
        return super.getValor()*pPacienteTp.ratio();
    }

    public String getBula() {
        return bula;
    }
}
