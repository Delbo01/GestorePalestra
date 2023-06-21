package Database;

import Allenamento.Esercizio;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class Dao_EserciziTest {

    static Dao_Esercizi dao_esercizi= new Dao_Esercizi();
    Esercizio esercizio = new Esercizio("Panca piana",3, 3, 10, "");
    @Test
    public void createEsercizio() {
        int id=dao_esercizi.getMaxIdEsercizio() + 1;
        dao_esercizi.createEsercizio(id,1,esercizio.getNome(),esercizio.getSerie(),esercizio.getReps(),esercizio.getCarico(),esercizio.getTempoRecupero(),esercizio.getNote());
        assertEquals("Panca Piana", dao_esercizi.getEsercizo(dao_esercizi.getMaxIdEsercizio()).getNome());
    }
    @Test
    public void deleteEsercizio() {
        int id=dao_esercizi.getMaxIdEsercizio() + 1;
        dao_esercizi.createEsercizio(id,1,esercizio.getNome(),esercizio.getSerie(),esercizio.getReps(),esercizio.getCarico(),esercizio.getTempoRecupero(),esercizio.getNote());
        dao_esercizi.deleteEsercizio(id);
        assertEquals(id - 1,dao_esercizi.getMaxIdEsercizio());

    }
    @Test
    public void updateCarico() {
        int id=dao_esercizi.getMaxIdEsercizio() + 1;
        dao_esercizi.createEsercizio(id,1,esercizio.getNome(),esercizio.getSerie(),esercizio.getReps(),esercizio.getCarico(),esercizio.getTempoRecupero(),esercizio.getNote());
        dao_esercizi.updateCarico(id, 100);
        assertEquals(100,dao_esercizi.getEsercizo(id).getCarico());
    }
    @Test
    public void getEsercizo() {
        int id=dao_esercizi.getMaxIdEsercizio() + 1;
        dao_esercizi.createEsercizio(id,1,esercizio.getNome(),esercizio.getSerie(),esercizio.getReps(),esercizio.getCarico(),esercizio.getTempoRecupero(),esercizio.getNote());
        assertEquals("Panca Piana",dao_esercizi.getEsercizo(id).getNome());
    }
    @After
    public void deleteEsercizioAfter(){
        dao_esercizi.deleteEsercizio(dao_esercizi.getMaxIdEsercizio());
    }
}