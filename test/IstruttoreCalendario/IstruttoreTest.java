package IstruttoreCalendario;

import Cliente.Generalita;
import GestioneRichieste.GestoreRichiestaScheda;
import org.junit.BeforeClass;
import org.junit.Test;

public class IstruttoreTest {
    static GestoreRichiestaScheda gt;
    static GestorePT gestorePT;
    static Generalita is;
    static Calendario ca;
    @BeforeClass
    public static void setUp() {
         gt = new GestoreRichiestaScheda();
         gestorePT = new GestorePT(10);
         is = new Generalita("fddfsd", "mario", "rossi");
         ca = new Calendario(2022);

    }
    @Test
    public void inserisciCorso() {
        Istruttore istruttore = new Istruttore(is, ca, gestorePT, gt);
    }

    @Test
    public void rimuoviCorso() {

    }
}