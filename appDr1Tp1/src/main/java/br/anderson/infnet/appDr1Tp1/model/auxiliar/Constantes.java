package br.anderson.infnet.appDr1Tp1.model.auxiliar;

import java.time.format.DateTimeFormatter;

public class Constantes {
    public static final String _FMT_DATE_BR_     = "dd/MM/yyyy";
    public static final String SEPARADOR = ";";

    public static final DateTimeFormatter FMT_DATE_BR() {
        return DateTimeFormatter.ofPattern(_FMT_DATE_BR_);
    }
}
