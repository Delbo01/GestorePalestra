package Database;

import Allenamento.Esercizio;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class Dao_EserciziTest {

    static Dao_Esercizi dao_esercizi= new Dao_Esercizi();
    static Dao_Programma dao_programma = new Dao_Programma();
    static Dao_Scheda daoScheda= new Dao_Scheda();
    Esercizio esercizio = new Esercizio("Panca piana",3, 3, 10, "");
    @Test
    public void createEsercizio() {
        int id=dao_esercizi.getMaxIdEsercizio() + 1;
        int idS=daoScheda.getMaxIdScheda()+1;
        int idP=dao_programma.getMaxIdProgramma()+1;
        daoScheda.createScheda(1,idS,"prova",1);
        dao_programma.creaProgramma(idP,idS,1,"1:00");
        dao_esercizi.createEsercizio(id,idP,esercizio.getNome(),esercizio.getSerie(),esercizio.getReps(),esercizio.getCarico(),esercizio.getTempoRecupero(),esercizio.getNote());
        assertEquals("Panca piana", dao_esercizi.getEsercizo(id).getNome());
        dao_esercizi.deleteEsercizio(id);
        dao_programma.deleteProgramma(idP);
        daoScheda.deleteScheda(idS);
    }
    @Test
    public void deleteEsercizio() {
        int id=dao_esercizi.getMaxIdEsercizio() + 1;
        int idS=daoScheda.getMaxIdScheda()+1;
        int idP=dao_programma.getMaxIdProgramma()+1;
        daoScheda.createScheda(1,idS,"prova",1);
        dao_programma.creaProgramma(idP,idS,1,"1:00");
        dao_esercizi.createEsercizio(id,idP,esercizio.getNome(),esercizio.getSerie(),esercizio.getReps(),esercizio.getCarico(),esercizio.getTempoRecupero(),esercizio.getNote());
        dao_esercizi.deleteEsercizio(id);
        assertEquals(id - 1,dao_esercizi.getMaxIdEsercizio());
        dao_programma.deleteProgramma(idP);
        daoScheda.deleteScheda(idS);

    }
    @Test
    public void updateCarico() {
        int id=dao_esercizi.getMaxIdEsercizio() + 1;
        int idS=daoScheda.getMaxIdScheda()+1;
        int idP=dao_programma.getMaxIdProgramma()+1;
        daoScheda.createScheda(1,idS,"prova",1);
        dao_programma.creaProgramma(idP,idS,1,"1:00");
        dao_esercizi.createEsercizio(id,idP,esercizio.getNome(),esercizio.getSerie(),esercizio.getReps(),esercizio.getCarico(),esercizio.getTempoRecupero(),esercizio.getNote());
        dao_esercizi.updateCarico(id, 100);
        assertEquals(100,dao_esercizi.getEsercizo(id).getCarico());
        dao_esercizi.deleteEsercizio(id);
        dao_programma.deleteProgramma(idP);
        daoScheda.deleteScheda(idS);
    }
    @Test
    public void getEsercizo() {
        int id=dao_esercizi.getMaxIdEsercizio() + 1;
        int idS=daoScheda.getMaxIdScheda()+1;
        int idP=dao_programma.getMaxIdProgramma()+1;
        daoScheda.createScheda(1,idS,"prova",1);
        dao_programma.creaProgramma(idP,idS,1,"1:00");
        dao_esercizi.createEsercizio(id,idP,esercizio.getNome(),esercizio.getSerie(),esercizio.getReps(),esercizio.getCarico(),esercizio.getTempoRecupero(),esercizio.getNote());
        assertEquals("Panca piana",dao_esercizi.getEsercizo(id).getNome());
        dao_esercizi.deleteEsercizio(id);
        dao_programma.deleteProgramma(idP);
        daoScheda.deleteScheda(idS);
    }
}