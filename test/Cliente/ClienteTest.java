package Cliente;

import Abbonamento.GestoreAbbonamenti;
import Calendario.*;
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
        gestoreAbbonamenti.addAbbonamenti(1,"mensile",60);
        cliente.ottieniAbbonamento(0,true);
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
    @Test
    public void richiediScheda() {
        String obiettivo="ipertrofia";
        int nProg=1;
        String duarta="1 ora";
        cliente.richiediScheda(obiettivo,nProg,duarta);
        assertEquals(1,gestoreRichiestaScheda.getRichieste().size());
        Istruttore i= new Istruttore(new Generalita("dgdgshs","francesco","bianchi"),calendario,gestorePT,gestoreRichiestaScheda);
        i.diventaPT();
        cliente.richiediPersonalTrainer();
        cliente.richiediScheda(obiettivo,nProg,duarta);
        assertEquals(1,gestorePT.getPtbyCF(cliente.getPt()).getGestoreRichiestaSchedaPT().getRichieste().size());
    }

    @Test
    public void checkAbbonamento() {
        cliente= new Cliente(is,altezza,peso,gestoreRichiestaScheda,gestoreAbbonamenti,gestorePT,calendario);
        assertEquals(false,cliente.checkAbbonamento());
        cliente.ottieniAbbonamento(0,true);
        assertEquals(true,cliente.checkAbbonamento());
    }

    @Test
    public void ottieniAbbonamneto() {
        cliente= new Cliente(is,altezza,peso,gestoreRichiestaScheda,gestoreAbbonamenti,gestorePT,calendario);
        assertEquals(false,cliente.checkAbbonamento());
        cliente.ottieniAbbonamento(0,true);
        assertEquals(true,cliente.checkAbbonamento());
    }

    @Test
    public void prenotaCorso() {
        calendario.inserisciCorso(1,1,new Corso("pilates",10,"10","11","paolo"));
        assertEquals(0,calendario.getNumeroPrenotazioni(1,1,"pilates"));
        cliente.prenotaCorso(1,1,"pilates");
        assertEquals(1,calendario.getNumeroPrenotazioni(1,1,"pilates"));
    }

    @Test
    public void rimuoviPrenotazioneCorso() {
        calendario.inserisciCorso(1,1,new Corso("pilates",10,"10","11","paolo"));
        cliente.prenotaCorso(1,1,"pilates");
        assertEquals(1,calendario.getNumeroPrenotazioni(1,1,"pilates"));
        cliente.rimuoviPrenotazioneCorso(1,1,"pilates");
        assertEquals(0,calendario.getNumeroPrenotazioni(1,1,"pilates"));
    }

    @After
    public void tearDown() throws Exception {
        cliente= new Cliente(is,altezza,peso,gestoreRichiestaScheda,gestoreAbbonamenti,gestorePT,calendario);
        cliente.ottieniAbbonamento(0,true);
    }
}

