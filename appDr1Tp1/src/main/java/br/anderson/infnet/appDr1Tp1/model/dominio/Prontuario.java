package br.anderson.infnet.appDr1Tp1.model.dominio;

import br.anderson.infnet.appDr1Tp1.model.auxiliar.Constantes;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TProntuario")
public class Prontuario  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private                int id;
    private             String descricao;
    private            boolean web;
    private LocalDateTime data;

    @OneToOne(cascade = CascadeType.DETACH) //obriga ter um paciente para ter um protuario
    @JoinColumn(name = "idPaciente")
    private           Paciente paciente;

    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Procedimento> procedimentos;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Prontuario() {

        data      = LocalDateTime.now();
        descricao = Constantes.PRONTUARIO_DESCRICAO;
    }

    @Override
    public String toString() {
        return
                String.format("%s%s%s%s%s%s",
                        descricao, Constantes.SEPARADOR,
                        web ? "Web": "Loja", Constantes.SEPARADOR,
                        data.format(Constantes.FMT_DATETIME_BR()), Constantes.SEPARADOR
                );
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isWeb() {
        return web;
    }

    public void setWeb(boolean web) {
        this.web = web;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Procedimento> getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(List<Procedimento> procedimentos) {
        this.procedimentos = procedimentos;
    }

    public LocalDateTime getData() {
        return data;
    }

    public float getValorTotal() {
        float lVrTot = (float) 0.00;
        for(Procedimento p : this.procedimentos) {
            lVrTot = lVrTot + p.getValor();
        }

        return lVrTot;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int pId) {
        this.id = pId;
    }
}
