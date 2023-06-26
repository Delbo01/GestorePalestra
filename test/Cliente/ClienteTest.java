package Cliente;

import Abbonamento.GestoreAbbonamenti;
import Controller.Calendario;
import Controller.GestorePT;
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
        is = new Generalita("fddfsd", "mario", "rossi");
        altezza = 180.0F;
        peso = 80.0F;
        gestoreAbbonamenti = new GestoreAbbonamenti();
        calendario = new Calendario(2023);
        gestoreRichiestaScheda = new GestoreRichiestaScheda();
        cliente = new Cliente(is,altezza,peso,gestoreRichiestaScheda);
    }

    @Test
    public void richiediScheda() {
        String obiettivo="ipertrofia";
        int nProg=1;
        String duarta="1 ora";
        Istruttore pt=null;
        cliente.richiediScheda(obiettivo,nProg,duarta,pt);
        assertEquals(1,gestoreRichiestaScheda.getRichieste().size());
        pt= new Istruttore(new Generalita("fddfsd", "mario", "rossi"));
        pt.diventaPT();
        cliente.richiediScheda(obiettivo,nProg,duarta,pt);
        assertEquals(1,pt.getGestoreRichiestaSchedaPT().getRichieste().size());
    }

    @After
    public void tearDown() throws Exception {
        cliente= new Cliente(is,altezza,peso,gestoreRichiestaScheda);
    }
}

