package Allenamento;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProgrammaAllenamentoTest {

    @Test
    public void addEsercizio() {
        ProgrammaAllenamento pa = new ProgrammaAllenamento("2");
        Esercizio es = new Esercizio("prova",1,1,1,"prova");
        pa.addEsercizio(es);
        assertEquals(es.getNome(),pa.getEsercizio(0).getNome());
    }
}