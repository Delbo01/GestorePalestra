package Istruttore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GestorePT {
    private List<Istruttore> allenatori = new ArrayList<>();
    private final int maxAssistiti;

    public GestorePT(int maxAssistiti) {
        this.maxAssistiti = maxAssistiti;
    }

    public void inserisciPT(Istruttore allenatore) {
        allenatori.add(allenatore);
    }

    private boolean controlloDisponibilita(Istruttore allenatore) {
        return allenatore.getNumeroAssistiti() < maxAssistiti;
    }
    public Istruttore ottieniPT() {
        for (Istruttore allenatore : allenatori) {
            if (controlloDisponibilita(allenatore)) {
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
}
