package IstruttoreCalendario;

import Cliente.Generalita;
import GestioneRichieste.GestoreRichiestaScheda;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IstruttoreTest {  //FIXME: cambiare scope sul controller
    static GestoreRichiestaScheda gt;
    static GestorePT gestorePT;
    static Generalita is;

    static Istruttore istruttore;
    static Calendario ca;
    @BeforeClass
    public static void setUp() {
         gt = new GestoreRichiestaScheda();
         gestorePT = new GestorePT(10);
         is = new Generalita("fddfsd", "mario", "rossi");
         ca = new Calendario(2022);
         istruttore = new Istruttore(is,ca,gestorePT,gt);

    }

    public void putSimpleCourse(int mese,int giorno,String nCorso){
        Corso corso = new Corso(nCorso,5,"20","23","Alberto");
        ca.inserisciCorso(mese,giorno,corso);
    }

    @Test
    public void testRimuoviCorso() {
        putSimpleCourse(1,1,"Pilates");
        Assert.assertEquals(istruttore.rimuoviCorso(1,1,"Pilates"),true);

        Assert.assertEquals(istruttore.rimuoviCorso(1,1,"Pilates"),false);

    }
   /*
    @Test                                   FIXME: cambiare comportamento di inserisciCorso
    public void testInserisciCorso(){
        Corso cs = new Corso("Pilates",5,"20","23","Alberto");
        assertEquals(istruttore.inserisciCorso(1,1,cs),true);
    }*/
}