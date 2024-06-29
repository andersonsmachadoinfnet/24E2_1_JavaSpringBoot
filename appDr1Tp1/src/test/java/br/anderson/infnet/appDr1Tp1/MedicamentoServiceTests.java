package br.anderson.infnet.appDr1Tp1;

import br.anderson.infnet.appDr1Tp1.model.dominio.Medicamento;
import br.anderson.infnet.appDr1Tp1.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appDr1Tp1.model.exceptions.ValorInvalidoException;
import br.anderson.infnet.appDr1Tp1.service.MedicamentoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MedicamentoServiceTests {
    @Autowired
    private MedicamentoService _srv;

    @Test
    @DisplayName("Insert Medicamento")
    public void testaInsert() {
        long qtd = _srv.count();
        assertDoesNotThrow(() ->
                _srv.incluir(new Medicamento("Carvedilol 3,125mg",(float)9.75,"Vide bula")
                ));
        assertEquals(qtd+1, _srv.count());
    }

    @Test
    @DisplayName("Delete Medicamento")
    public void testaDelete() {
        long qtd = _srv.count();
        assertDoesNotThrow(() -> _srv.excluir(1) );
        assertEquals(qtd-1, _srv.count());
    }

    @Test
    @DisplayName("Load Medicamento")
    public void testaLoad() {
        Medicamento a;
        Optional<Medicamento> b;
        try {
            a = _srv.incluir(new Medicamento("Carvedilol 3,125mg",(float)9.75,"Vide bula"));
        } catch (ValorInvalidoException e) {
            throw new RuntimeException(e);
        } catch (DescricaoInvalidaException e) {
            throw new RuntimeException(e);
        }
        b = _srv.ler(a.getId());
        assertNotNull(b.get());
        assertEquals(a.getId(), b.get().getId());
    }
}
