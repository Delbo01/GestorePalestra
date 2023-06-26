package Istruttore;

import Controller.Calendario;
import Cliente.Generalita;
import Controller.GestorePT;
import GestioneRichieste.GestoreRichiestaScheda;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import Calendario.Corso;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class IstruttoreTest {
    static GestoreRichiestaScheda gt;
    static GestorePT gestorePT;
    static Generalita is;

    static Istruttore istruttore;
    static Calendario ca;
    @BeforeClass
    public static void setUp() {
         gt = new GestoreRichiestaScheda();
         is = new Generalita("lcurss95d12d612u", "luca", "rossi");
         gestorePT = new GestorePT(10,ca);
         istruttore = new Istruttore(is);

    }
    @Test
    public void diventaPT() {
        istruttore.diventaPT();
        gestorePT.inserisciPT(istruttore);
        assertEquals(istruttore.getGeneralita().getCf(),gestorePT.ottieniPT().getGeneralita().getCf());
    }
}