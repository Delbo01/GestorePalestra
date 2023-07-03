package Controller;

import Corso.Corso;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerCorsoTest {
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
