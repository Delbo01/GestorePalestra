package Istruttore;

import Calendario.Calendario;
import Cliente.Generalita;
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
         ca = new Calendario(2022);
         gestorePT = new GestorePT(10,ca);
         istruttore = new Istruttore(is,ca);

    }



    @Test
    public void testRimuoviCorso() {
        Corso corso = new Corso("Pilates",5,"20","23","luca","rossi",0);
        ca.inserisciCorso(1,1,corso);
        Assert.assertTrue(istruttore.rimuoviCorso(1, 1, "Pilates"));
        Assert.assertFalse(istruttore.rimuoviCorso(1, 1, "Pilates"));

    }

    @Test
    public void testInserisciCorso(){
        Corso cs = new Corso("Pilates",5,"20","23","luca","rossi",0);
        istruttore.inserisciCorso(1,1,cs);
        assertEquals(true,ca.checkCorsiGiornalieri(1,1,cs.getNome()));
        istruttore.rimuoviCorso(1,1,"Pilates");
    }

    @Test
    public void diventaPT() {
        istruttore.diventaPT();
        gestorePT.inserisciPT(istruttore);
        assertEquals(istruttore.getGeneralita().getCf(),gestorePT.ottieniPT().getGeneralita().getCf());
    }
}