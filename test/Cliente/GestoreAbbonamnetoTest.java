package Cliente;
import Abbonamento.Abbonamento;
import org.junit.*;
import static org.junit.Assert.*;

public class GestoreAbbonamnetoTest {
    GestoreAbbonamenti gestoreAbbonamenti;

    @Before
    public void setUp() throws Exception {
        gestoreAbbonamenti= new GestoreAbbonamenti();
    }

    @Test
    public void addAbbonamneti() {
        Abbonamento ab= new Abbonamento(1,"mensile",60,false);
        assertEquals(0,gestoreAbbonamenti.getAbbonamenti().size());
        gestoreAbbonamenti.addAbbonamneti(1,"mensile",60);
        assertEquals(1,gestoreAbbonamenti.getAbbonamenti().size());

    }

    @Test
    public void rimuoviAbbonamneto() {
        Abbonamento ab= new Abbonamento(1,"mensile",60,false);
        gestoreAbbonamenti.addAbbonamneti(1,"mensile",60);
        assertFalse(gestoreAbbonamenti.rimuoviAbbonamneti(1,"trimestrale",60));
        assertTrue(gestoreAbbonamenti.rimuoviAbbonamneti(1,"mensile",60));
    }

    @Test
    public void getAbbonamneto() {
        Abbonamento ab= new Abbonamento(1,"mensile",60,false);
        gestoreAbbonamenti.addAbbonamneti(1,"mensile",60);
        assertEquals(ab.getDurata(),gestoreAbbonamenti.getAbbonamenti().get(0).getDurata());
        assertEquals(ab.getPrezzo(),gestoreAbbonamenti.getAbbonamenti().get(0).getPrezzo());
        assertEquals(ab.isCorsi(),gestoreAbbonamenti.getAbbonamenti().get(0).isCorsi());
        assertEquals(ab.getNome(),gestoreAbbonamenti.getAbbonamenti().get(0).getNome());
    }

    @After
    public void tearDown() throws Exception {
        gestoreAbbonamenti= new GestoreAbbonamenti();
    }
}
