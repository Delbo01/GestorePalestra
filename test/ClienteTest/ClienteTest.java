package ClienteTest;

import Calendario.*;
import Cliente.*;
import GestioneRichieste.*;
import Istruttore.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClienteTest {
    static GestorePT gestorePT;
    static Generalita is;
    static Cliente cliente;
    static float altezza;
    static float peso;
    static GestoreAbbonamenti gestoreAbbonamenti;
    static Calendario calendario;
    static GestoreRichiestaScheda gestoreRichiestaScheda;

    @BeforeClass
    public static void  setUp() throws Exception {
        gestorePT= new GestorePT(10);
        is = new Generalita("fddfsd", "mario", "rossi");
        altezza = 180.0F;
        peso = 80.0F;
        gestoreAbbonamenti = new GestoreAbbonamenti();
        calendario = new Calendario(2023);
        gestoreRichiestaScheda = new GestoreRichiestaScheda();
        cliente = new Cliente(is,altezza,peso,gestoreRichiestaScheda,gestoreAbbonamenti,gestorePT,calendario);
    }

    @Test
    public void richiediPT() {
        assertEquals(cliente.getPt(),null);
        Istruttore i= new Istruttore(new Generalita("dgdgshs","francesco","bianchi"),calendario,gestorePT,gestoreRichiestaScheda);
        i.diventaPT();
        cliente.richiediPersonalTrainer();
        assertEquals(cliente.getPt(),i.getGeneralita().getCf());

    }

    @Test
    public void rimuoviPT() {
        cliente.rimuoviPersonalTrainer();
        assertEquals(null,cliente.getPt());
        Istruttore i= new Istruttore(new Generalita("dgdgshs","francesco","bianchi"),calendario,gestorePT,gestoreRichiestaScheda);
        i.diventaPT();
        cliente.richiediPersonalTrainer();
        cliente.rimuoviPersonalTrainer();
        assertEquals(null,cliente.getPt());
    }

    @Test
    public void richiediPTbyCf() {
        assertEquals(null,cliente.getPt());
        Istruttore i= new Istruttore(new Generalita("dgdgshs","francesco","bianchi"),calendario,gestorePT,gestoreRichiestaScheda);
        i.diventaPT();
        cliente.richiediPersonalTrainer("dgdgshs");
        assertEquals(i.getGeneralita().getCf(),cliente.getPt());
    }

    @After
    public void tearDown() throws Exception {
        cliente= new Cliente(is,altezza,peso,gestoreRichiestaScheda,gestoreAbbonamenti,gestorePT,calendario);
    }
}

