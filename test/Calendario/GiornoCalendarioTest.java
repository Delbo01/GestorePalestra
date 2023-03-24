package Calendario;
import org.junit.Test;

import static org.junit.Assert.*;

public class GiornoCalendarioTest {

    @Test
    public void inserisciCorso() {
        Corso co = new Corso("prova",2,"10","12","Carlo");
        GiornoCalendario gc = new GiornoCalendario(12);
        gc.inserisciCorso(co);

        assertEquals(true,gc.checkCorsiGiornalieri(co.getNome()));
    }

    @Test
    public void rimuoviCorso() {
        Corso co = new Corso("prova",2,"10","12","Carlo");
        GiornoCalendario gc = new GiornoCalendario(12);
        gc.inserisciCorso(co);
        assertEquals(true,gc.checkCorsiGiornalieri(co.getNome()));

        gc.rimuoviCorso(co.getNome());
        assertEquals(false,gc.checkCorsiGiornalieri(co.getNome()));

    }

    @Test
    public void rimuoviTuttiCorsi() {
        Corso co = new Corso("prova1",2,"10","12","Carlo");
        Corso co1 = new Corso("prova2",2,"10","12","Carlo");
        Corso co2 = new Corso("prova3",2,"10","12","Carlo");

        GiornoCalendario gc = new GiornoCalendario(12);
        gc.inserisciCorso(co);
        gc.inserisciCorso(co1);
        gc.inserisciCorso(co2);

        assertEquals(true,gc.checkCorsiGiornalieri(co.getNome()));
        assertEquals(true,gc.checkCorsiGiornalieri(co1.getNome()));
        assertEquals(true,gc.checkCorsiGiornalieri(co2.getNome()));

        gc.rimuoviTuttiCorsi();

        assertEquals(false,gc.checkCorsiGiornalieri(co.getNome()));
        assertEquals(false,gc.checkCorsiGiornalieri(co1.getNome()));
        assertEquals(false,gc.checkCorsiGiornalieri(co2.getNome()));
    }

    @Test
    public void checkCorsiGiornalieri() {
        Corso co = new Corso("prova",2,"10","12","Carlo");
        GiornoCalendario gc = new GiornoCalendario(12);
        assertEquals(false,gc.checkCorsiGiornalieri(co.getNome()));
        gc.inserisciCorso(co);
        assertEquals(true,gc.checkCorsiGiornalieri(co.getNome()));
    }

    @Test
    public void getNumeroPrenotazioni() {
        Corso co = new Corso("prova",2,"10","12","Carlo");
        GiornoCalendario gc = new GiornoCalendario(12);
        gc.inserisciCorso(co);
        assertEquals(0,gc.getNumeroPrenotazioni(co.getNome()));
        gc.prenotaCorso("prova");
        assertEquals(1,gc.getNumeroPrenotazioni(co.getNome()));
    }

    @Test
    public void prenotaCorso() {
        Corso co = new Corso("prova",2,"10","12","Carlo");
        GiornoCalendario gc = new GiornoCalendario(12);
        gc.inserisciCorso(co);
        assertEquals(0,gc.getNumeroPrenotazioni(co.getNome()));
        gc.prenotaCorso("prova");
        assertEquals(1,gc.getNumeroPrenotazioni(co.getNome()));
    }

    @Test
    public void rimuoviPrenotazione() {
        Corso co = new Corso("prova",2,"10","12","Carlo");
        GiornoCalendario gc = new GiornoCalendario(12);
        gc.inserisciCorso(co);
        assertEquals(0,gc.getNumeroPrenotazioni(co.getNome()));
        gc.prenotaCorso("prova");
        assertEquals(1,gc.getNumeroPrenotazioni(co.getNome()));
        gc.rimuoviPrenotazione("prova");
        assertEquals(0,gc.getNumeroPrenotazioni(co.getNome()));
    }
}