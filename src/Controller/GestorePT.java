package Controller;

import Controller.Calendario;
import Database.Dao_Istruttore;
import Database.Dao_Istruttore_Interface;
import Istruttore.Istruttore;

import java.util.ArrayList;
import java.util.Objects;

public class GestorePT {
    private ArrayList<Istruttore> allenatori;
    private final int maxAssistiti;
    private final Dao_Istruttore_Interface dao_istruttore=new Dao_Istruttore();

    public GestorePT(int maxAssistiti,Calendario c) {
        this.maxAssistiti = maxAssistiti;
        allenatori = dao_istruttore.getAllPT();
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
        int index=0;
        for (int i=0;i<allenatori.size();i++){
            if (allenatori.get(i).getGeneralita().getCf()==allenatore.getGeneralita().getCf())
                index=i;
        }
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
