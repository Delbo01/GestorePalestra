package Controller;

import Calendario.Calendario;
import Cliente.Generalita;
import GestioneRichieste.GestoreRichiestaScheda;
import  Istruttore.GestorePT;
import Istruttore.Istruttore;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class ControllerIstruttoreTest {
    static Scanner sc;
    static ControllerIstruttore controllerIstruttore;
    static Calendario ca= new Calendario(2022);
    static GestorePT gp = new GestorePT(10,ca);
    static GestoreRichiestaScheda grs = new GestoreRichiestaScheda();
    static Istruttore istruttore;
    @BeforeClass
    public static void setUp() {
        sc = new Scanner(System.in);
        Generalita ge = new Generalita("lcurss95d12d612u","luca","rossi");
        istruttore = new Istruttore(ge,ca);
        controllerIstruttore = new ControllerIstruttore(istruttore,ca,grs,gp);
    }
    @Test
    public void inserisciCorso() { //TODO chiedere al prof gestione input

    }
    @Test
    public void rimuoviCorso() {
    }

    @Test
    public void diventaPT() {
        controllerIstruttore.diventaPT();
        assertEquals(istruttore.getGeneralita().getCf(),gp.ottieniPT(istruttore.getGeneralita().getCf()).getGeneralita().getCf());
    }
}