package Istruttore;

import Calendario.Calendario;
import Database.Dao_Istruttore;
import Database.Dao_Istruttore_Interface;

import java.util.ArrayList;
import java.util.Objects;

public class GestorePT {
    private final Calendario calendario;
    private ArrayList<Istruttore> allenatori;
    private final int maxAssistiti;
    private final Dao_Istruttore_Interface dao_istruttore=new Dao_Istruttore();

    public GestorePT(int maxAssistiti,Calendario c) {
        this.maxAssistiti = maxAssistiti;
        this.calendario=c;
        allenatori = dao_istruttore.getAllPT();
        for (int i=0;i<allenatori.size();i++){
            allenatori.get(i).setCalendario(calendario);
        }
    }

    public void inserisciPT(Istruttore allenatore) {
        allenatori.add(allenatore);
    }

    public boolean controlloDisponibilita(Istruttore allenatore) {
        return allenatore.getNumeroAssistiti() < maxAssistiti;
    }
    public Istruttore ottieniPT() {
        for (Istruttore allenatore : allenatori) {
            if (controlloDisponibilita(allenatore)) {
                dao_istruttore.incrementaAssistiti(dao_istruttore.getIdByNomeCognome(allenatore.getGeneralita().getNome(),allenatore.getGeneralita().getCognome()));
                allenatore.incrementaAssistiti();
                return allenatore;
            }
        }
        return null;
    }
    public Istruttore ottieniPT(String cf){
        for(Istruttore allenatore : allenatori){
            if(Objects.equals(allenatore.getGeneralita().getCf(), cf)){
                if (controlloDisponibilita(allenatore)){
                    dao_istruttore.incrementaAssistiti(dao_istruttore.getIdByNomeCognome(allenatore.getGeneralita().getNome(),allenatore.getGeneralita().getCognome()));
                    allenatore.incrementaAssistiti();
                    return allenatore;
                }else
                    return null;
            }
        }
        return null;
    }
    public void rimuoviAssistito(Istruttore allenatore){
        int index = allenatori.indexOf(allenatore);
        dao_istruttore.decrementaAssistiti(dao_istruttore.getIdByNomeCognome(allenatore.getGeneralita().getNome(),allenatore.getGeneralita().getCognome()));
        allenatori.get(index).rimuoviAssistito();
    }

    public Istruttore getPtbyCF(String cf){
        if (cf==null)
            return null;
        for(Istruttore allenatore : allenatori){
            if(Objects.equals(allenatore.getGeneralita().getCf(), cf)){
                return allenatore;
            }
        }
        return null;
    }

    public ArrayList<Istruttore> getAllenatori() {
        return allenatori;
    }
}
