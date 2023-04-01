package Calendario;
import org.junit.Test;

import static org.junit.Assert.*;


public class MeseCalendarioTest {

    @Test
    public void checkCorsiGiornalieri() {
        Corso co = new Corso("prova", 2, "10", "12", "Carlo");
        MeseCalendario mc = new MeseCalendario(31, "Gennaio", 1);
        assertEquals(false, mc.checkCorsiGiornalieri(12, co.getNome()));
        mc.inserisciCorso(12, co);
        assertEquals(true, mc.checkCorsiGiornalieri(12, co.getNome()));
    }

    @Test
    public void inserisciCorso() {
        Corso co = new Corso("prova", 2, "10", "12", "Carlo");
        MeseCalendario mc = new MeseCalendario(31, "Gennaio", 1);
        mc.inserisciCorso(12, co);

        assertEquals(true, mc.checkCorsiGiornalieri(12, co.getNome()));
    }

    @Test
    public void rimuoviCorso() {
        Corso co = new Corso("prova", 2, "10", "12", "Carlo");
        MeseCalendario mc = new MeseCalendario(31, "Gennaio", 1);
        mc.inserisciCorso(12, co);
        assertEquals(true, mc.checkCorsiGiornalieri(12, co.getNome()));

        mc.rimuoviCorso(12, co.getNome());
        assertEquals(false, mc.checkCorsiGiornalieri(12, co.getNome()));

    }

    @Test
    public void rimuoviCorsiGiornalieri() {
        Corso co = new Corso("prova1", 2, "10", "12", "Carlo");
        Corso co1 = new Corso("prova2", 2, "10", "12", "Carlo");
        Corso co2 = new Corso("prova3", 2, "10", "12", "Carlo");

        MeseCalendario mc = new MeseCalendario(31, "Gennaio", 1);
        mc.inserisciCorso(12, co);
        mc.inserisciCorso(12, co1);
        mc.inserisciCorso(12, co2);

        assertEquals(true, mc.checkCorsiGiornalieri(12, co.getNome()));
        assertEquals(true, mc.checkCorsiGiornalieri(12, co1.getNome()));
        assertEquals(true, mc.checkCorsiGiornalieri(12, co2.getNome()));

        mc.rimuoviCorsiGiornalieri(12);

        assertEquals(false, mc.checkCorsiGiornalieri(12, co.getNome()));
        assertEquals(false, mc.checkCorsiGiornalieri(12, co1.getNome()));
        assertEquals(false, mc.checkCorsiGiornalieri(12, co2.getNome()));
    }

    @Test
    public void prenotaCorso() {
        Corso co = new Corso("prova", 2, "10", "12", "Carlo");
        MeseCalendario mc = new MeseCalendario(31, "Gennaio", 1);
        mc.inserisciCorso(12, co);
        assertEquals(true, mc.prenotaCorso(12, co.getNome()));
        assertEquals(true, mc.prenotaCorso(12, co.getNome()));
        assertEquals(false, mc.prenotaCorso(12, co.getNome()));
    }

    @Test
    public void rimuoviPrenotazioneCorso() {
        Corso co = new Corso("prova", 2, "10", "12", "Carlo");
        MeseCalendario mc = new MeseCalendario(31, "Gennaio", 1);
        mc.inserisciCorso(12, co);
        assertEquals(true, mc.prenotaCorso(12, co.getNome()));
        assertEquals(true, mc.rimuoviPrenotazioneCorso(12, co.getNome()));
        assertEquals(false, mc.rimuoviPrenotazioneCorso(12, co.getNome()));
    }

    @Test
    public void getNumeroPrenotazioni() {
        Corso co = new Corso("prova", 2, "10", "12", "Carlo");
        MeseCalendario mc = new MeseCalendario(31, "Gennaio", 1);
        mc.inserisciCorso(12, co);
        assertEquals(0, mc.getNumeroPrenotazioni(12, co.getNome()));
        mc.prenotaCorso(12, co.getNome());
        assertEquals(1, mc.getNumeroPrenotazioni(12, co.getNome()));
        mc.prenotaCorso(12, co.getNome());
        assertEquals(2, mc.getNumeroPrenotazioni(12, co.getNome()));
        mc.rimuoviPrenotazioneCorso(12, co.getNome());
        assertEquals(1, mc.getNumeroPrenotazioni(12, co.getNome()));
    }

    @Test
    public void rimuoviCorsiMensili() {
        Corso co = new Corso("prova1", 2, "10", "12", "Carlo");
        Corso co1 = new Corso("prova2", 2, "10", "12", "Carlo");
        Corso co2 = new Corso("prova3", 2, "10", "12", "Carlo");

        MeseCalendario mc = new MeseCalendario(31, "Gennaio", 1);
        mc.inserisciCorso(12, co);
        mc.inserisciCorso(12, co1);
        mc.inserisciCorso(12, co2);

        assertEquals(true, mc.checkCorsiGiornalieri(12, co.getNome()));
        assertEquals(true, mc.checkCorsiGiornalieri(12, co1.getNome()));
        assertEquals(true, mc.checkCorsiGiornalieri(12, co2.getNome()));

        mc.rimuoviCorsiMensili();

        assertEquals(false, mc.checkCorsiGiornalieri(12, co.getNome()));
        assertEquals(false, mc.checkCorsiGiornalieri(12, co1.getNome()));
        assertEquals(false, mc.checkCorsiGiornalieri(12, co2.getNome()));
    }
}

