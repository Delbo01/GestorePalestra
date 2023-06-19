package Cliente;
import Abbonamento.*;
import org.junit.*;
import static org.junit.Assert.*;

public class GestoreAbbonamentoTest {
    GestoreAbbonamenti gestoreAbbonamenti;

    @Before
    public void setUp() throws Exception {
        gestoreAbbonamenti= new GestoreAbbonamenti();
    }

    @Test
    public void addAbbonamenti() {
        assertNull(gestoreAbbonamenti.getAbbonamento(0, true));
        gestoreAbbonamenti.addAbbonamenti(1,"prova",300,"01/01/2019");
        assertEquals("prova",gestoreAbbonamenti.getAbbonamento(0, true).getNome());

    }

    @Test
    public void rimuoviAbbonamento() {
        gestoreAbbonamenti.addAbbonamenti(1,"prova",60,"01/01/2019");
        assertFalse(gestoreAbbonamenti.rimuoviAbbonamenti(1,"provaErrata",60));
        gestoreAbbonamenti.rimuoviAbbonamenti(1,"prova",60);
        assertNull(gestoreAbbonamenti.getAbbonamento(0,false));
    }

    @Test
    public void getAbbonamento() {
        gestoreAbbonamenti.addAbbonamenti(1,"prova",60,"01/01/2019");
        Abbonamento abb = gestoreAbbonamenti.getAbbonamento(0,false);
        assertEquals("prova",abb.getNome());
        assertFalse(abb.isCorsi());
        assertEquals(60,abb.getPrezzo());
        assertEquals(1,abb.getDurata());
    }

    @After
    public void tearDown() throws Exception {
        gestoreAbbonamenti= new GestoreAbbonamenti();
    }
}
