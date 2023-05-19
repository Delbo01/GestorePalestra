package Istruttore;
import Calendario.Calendario;
import Cliente.Generalita;
import org.junit.*;
import GestioneRichieste.GestoreRichiestaScheda;
import static org.junit.Assert.*;

public class GestorePTTest {
    GestorePT gestorePT;
    Istruttore i;

    @Before
    public void setUp() throws Exception {
        gestorePT = new GestorePT(1);
        i=new Istruttore(new Generalita("www","mario","rossi"),new Calendario(2022),new GestoreRichiestaScheda());
    }

    @Test
    public void inserisciPT() {
        assertEquals(0, gestorePT.getAllenatori().size());
        gestorePT.inserisciPT(i);
        assertEquals(1, gestorePT.getAllenatori().size());
    }

    @Test
    public void controlloDisponibilità() {
        gestorePT.inserisciPT(i);
        assertTrue(gestorePT.controlloDisponibilita(i));
        i.incrementaAssistiti();
        assertFalse(gestorePT.controlloDisponibilita(i));
    }

    @Test
    public void ottieniPT() {
        gestorePT.inserisciPT(i);
        assertEquals(i, gestorePT.ottieniPT());
    }

    @Test
    public void ottieniPTbyCF() {
        gestorePT.inserisciPT(i);
        assertEquals(i, gestorePT.ottieniPT("www"));
    }

    @Test
    public void rimuoviAssistito() {
        gestorePT.inserisciPT(i);
        i.incrementaAssistiti();
        assertEquals(1, gestorePT.getAllenatori().get(0).getNumeroAssistiti());
        gestorePT.rimuoviAssistito(i);
        assertEquals(0, gestorePT.getAllenatori().get(0).getNumeroAssistiti());
    }

    @Test
    public void getPTbyCF() {
        gestorePT.inserisciPT(i);
        assertEquals(i, gestorePT.getPtbyCF("www"));
        assertEquals(null, gestorePT.getPtbyCF("www2"));
        assertEquals(null, gestorePT.getPtbyCF(null));
    }

    @After
    public void tearDown() throws Exception {
        gestorePT = new GestorePT(1);
        i=new Istruttore(new Generalita("www","mario","rossi"),new Calendario(2022),new GestoreRichiestaScheda());
    }
}
