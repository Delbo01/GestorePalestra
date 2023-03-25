package Allenamento;
import org.junit.Test;

import static org.junit.Assert.*;


public class SchedaTest {
    @Test
    public void addProgramma() {
        Scheda scheda= new Scheda("istruttore","obbiettivo");
        ProgrammaAllenamento pa = new ProgrammaAllenamento("2");
        assertEquals(0,scheda.getnProg());
        scheda.addProgramma(pa);
        assertEquals(1,scheda.getnProg());
    }

    @Test
    public void removeProgramma() {
        Scheda scheda= new Scheda("istruttore","obbiettivo");
        ProgrammaAllenamento pa = new ProgrammaAllenamento("2");
        scheda.addProgramma(pa);
        assertEquals(1,scheda.getnProg());
        scheda.removeProgramma(pa);
        assertEquals(0,scheda.getnProg());
    }
}
