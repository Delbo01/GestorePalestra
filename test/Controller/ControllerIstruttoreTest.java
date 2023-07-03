package Controller;

import Cliente.*;
import Corso.Corso;
import GestioneRichieste.GestoreRichiestaScheda;
import Istruttore.Istruttore;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class ControllerIstruttoreTest {
    static Scanner sc;
    static ControllerIstruttore controllerIstruttore;
    static ControllerCorso ca= new ControllerCorso(2022);
    static GestorePT gp = new GestorePT(10,ca);
    static GestoreRichiestaScheda grs = new GestoreRichiestaScheda();
    static Istruttore istruttore;
    @BeforeClass
    public static void setUp() {
        sc = new Scanner(System.in);
        Generalita ge = new Generalita("lcurss95d12d612u","luca","rossi");
        istruttore = new Istruttore(ge);
        controllerIstruttore = new ControllerIstruttore(istruttore,ca,grs,gp);
    }
    @Test
    public void diventaPT() {
        controllerIstruttore.diventaPT();
        assertEquals(istruttore.getGeneralita().getCf(),gp.ottieniPT(istruttore.getGeneralita().getCf()).getGeneralita().getCf());
    }

    public static class ControllerCorsoTest {
        @Test
        public void inserisciCorso() {
            Corso co = new Corso("prova", 2, "10", "12", "luca","rossi",0);
            ControllerCorso cal = new ControllerCorso(2023);
            cal.inserisciCorso(1,12,co);
            assertEquals(true, cal.checkCorsiGiornalieri(1,12, co.getNome()));
            cal.rimuoviCorso(1,12, co.getNome());
        }

        @Test
        public void rimuoviCorso() {
            Corso co = new Corso("prova", 2, "10", "12", "luca","rossi",0);
            ControllerCorso cal = new ControllerCorso(2023);
            cal.inserisciCorso(1,12,co);
            assertEquals(true, cal.checkCorsiGiornalieri(1,12, co.getNome()));

            cal.rimuoviCorso(1,12, co.getNome());
            assertEquals(false, cal.checkCorsiGiornalieri(1,12, co.getNome()));
        }

        @Test
        public void checkCorsiGiornalieri() {
            Corso co = new Corso("prova", 2, "10", "12", "luca","rossi",0);
            ControllerCorso cal = new ControllerCorso(2023);
            assertEquals(false, cal.checkCorsiGiornalieri(1,12, co.getNome()));
            cal.inserisciCorso(1,12,co);
            assertEquals(true, cal.checkCorsiGiornalieri(1,12, co.getNome()));
            cal.rimuoviCorso(1,12, co.getNome());
        }

        @Test
        public void prenotaCorso() {
            Corso co = new Corso("prova", 2, "10", "12", "luca","rossi",0);
            ControllerCorso cal = new ControllerCorso(2023);
            cal.inserisciCorso(1,12,co);
            assertEquals(true, cal.prenotaCorso(1,12, co.getNome()));
            assertEquals(1, cal.getNumeroPrenotazioni(1,12, co.getNome()));
            assertEquals(true, cal.prenotaCorso(1,12, co.getNome()));
            assertEquals(2, cal.getNumeroPrenotazioni(1,12, co.getNome()));
            cal.rimuoviCorso(1,12, co.getNome());
        }

        @Test
        public void rimuoviPrenotazioneCorso() {
            Corso co = new Corso("prova", 2, "10", "12", "luca","rossi",0);
            ControllerCorso cal = new ControllerCorso(2023);
            cal.inserisciCorso(1,12,co);
            assertTrue(cal.prenotaCorso(1, 12, co.getNome()));
            assertEquals(1, cal.getNumeroPrenotazioni(1,12, co.getNome()));
            assertTrue(cal.prenotaCorso(1, 12, co.getNome()));
            assertEquals(2, cal.getNumeroPrenotazioni(1,12, co.getNome()));

            assertTrue(cal.rimuoviPrenotazioneCorso(1, 12, co.getNome()));
            assertEquals(1, cal.getNumeroPrenotazioni(1,12, co.getNome()));
            assertTrue(cal.rimuoviPrenotazioneCorso(1, 12, co.getNome()));
            assertEquals(0, cal.getNumeroPrenotazioni(1,12, co.getNome()));

            cal.rimuoviCorso(1,12, co.getNome());
        }

        @Test
        public void getNumeroPrenotazioni() {
            Corso co = new Corso("prova", 2, "10", "12", "luca","rossi",0);
            ControllerCorso cal = new ControllerCorso(2023);
            cal.inserisciCorso(1,12,co);
            assertTrue(cal.prenotaCorso(1, 12, co.getNome()));
            assertEquals(1, cal.getNumeroPrenotazioni(1,12, co.getNome()));
            assertTrue(cal.prenotaCorso(1, 12, co.getNome()));
            assertEquals(2, cal.getNumeroPrenotazioni(1,12, co.getNome()));
            cal.rimuoviCorso(1,12, co.getNome());
        }
    }
}