package br.anderson.infnet.appDr1Tp1;

import br.anderson.infnet.appDr1Tp1.model.dominio.Paciente;
import br.anderson.infnet.appDr1Tp1.service.PacienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacienteServiceTests {
    @Autowired
    private PacienteService _srv;

    @Test
    @DisplayName("Insert Paciente")
    public void testaInsert() {
        long qtd = _srv.count();
        assertDoesNotThrow(() ->
                _srv.incluir(new Paciente("MatheusX João Galvão","779.151.148-75","matheus_galvao@lognat.com.br","27/01/1971")
                ));
        assertEquals(qtd+1, _srv.count());
    }

    @Test
    @DisplayName("Delete Paciente")
    public void testaDelete() {
        long qtd = _srv.count();
        assertDoesNotThrow(() -> _srv.excluir(1) );
        assertEquals(qtd-1, _srv.count());
    }

    @Test
    @DisplayName("Load Paciente")
    public void testaLoad() {
        Paciente a;
        Optional<Paciente> b;
        a = _srv.incluir(new Paciente("MatheusX João Galvão","779.151.148-75","matheus_galvao@lognat.com.br","27/01/1971"));
        b = _srv.ler(a.getId());
        assertNotNull(b.get());
        assertEquals(a.getId(), b.get().getId());
    }
}
