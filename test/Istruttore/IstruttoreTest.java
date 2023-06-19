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
         is = new Generalita("fddfsd", "mario", "rossi");
         ca = new Calendario(2022);
         gestorePT = new GestorePT(10,ca);
         istruttore = new Istruttore(is,ca);

    }

    public void putSimpleCourse(int mese,int giorno,String nCorso){
        Corso corso = new Corso(nCorso,5,"20","23","Alberto","Rossi");
        ca.inserisciCorso(mese,giorno,corso);
    }

    @Test
    public void testRimuoviCorso() {
        putSimpleCourse(1,1,"Pilates");
        Assert.assertTrue(istruttore.rimuoviCorso(1, 1, "Pilates"));
        Assert.assertFalse(istruttore.rimuoviCorso(1, 1, "Pilates"));

    }

    @Test
    public void testInserisciCorso(){
        Corso cs = new Corso("Pilates",5,"20","23","Alberto","Rossi");
        istruttore.inserisciCorso(1,1,cs);
        assertEquals(ca.checkCorsiGiornalieri(1,1,cs.getNome()),true);
    }

    @Test
    public void diventaPT() {
        assertNull(gestorePT.ottieniPT());
        istruttore.diventaPT();
        assertEquals(istruttore,gestorePT.ottieniPT());
    }
}