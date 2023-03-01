package IstruttoreCalendario;

import java.util.ArrayList;
import java.util.List;

public class GestorePT {
    private List<Istruttore> allenatori = new ArrayList<>();
    private int maxAssistiti;

    public GestorePT(int maxAssistiti) {
        this.maxAssistiti = maxAssistiti;
    }

    public void inserisciPT(Istruttore allenatore) {
        allenatori.add(allenatore);
    }

    private boolean controlloDisponibilita(Istruttore allenatore) {
        if (allenatore.getNumeroAssistiti() < maxAssistiti) {
            return true;
        }
        return false;
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
    public Istruttore ottieniPT(String nome){
        for(Istruttore allenatore : allenatori){
            if(allenatore.getGeneralita().getNome() == nome){
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
}
