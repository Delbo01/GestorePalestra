package Calendario;
import org.junit.Test;
import static org.junit.Assert.*;
public class CorsoTest{

    @Test
    public void testPrenota() {
        Corso co = new Corso("prova",1,"10","11","carlo");
        assertEquals(true,co.prenota());

        assertEquals(false,co.prenota());
    }
    @Test
    public void testRimuoviPrenotazione(){
        Corso co = new Corso("prova",1,"10","11","carlo");
        assertEquals(false,co.rimuoviPrenotazione());

        co.prenota();
        assertEquals(true,co.rimuoviPrenotazione());
    }
}