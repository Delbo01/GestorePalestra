package IstruttoreCalendario;

import Cliente.Generalita;

import java.util.ArrayList;
import java.util.List;

public class GiornoCalendario {
    private ArrayList<Corso> corsi = new ArrayList<>();
    private int giorno;
    public GiornoCalendario(int giorno) {
        this.giorno = giorno;
    }

    void inserisciCorso(Corso corso){
        corsi.add(corso);
    }
    boolean rimuoviCorso(String corso){
        for(Corso c : corsi){
            if(c.getNome().equals(corso)){
                return corsi.remove(c);
            }
        }
        System.out.println("Corso non presente");
        return false;
    }

    boolean rimuoviPrenotazione(String corso){
        for (Corso c : corsi){
            if(c.getNome().equals(corso)){
                return c.rimuoviPrenotazione();
            }
        }
        System.out.println("Corso non presente");
        return false;
    }
    void vediCorso(Corso corso){
        int index = corsi.indexOf(corso);
        if(index == -1){
            System.out.println("Corso non presente\n");
        }else {
            String istruttore = corso.getIstruttore();
            System.out.println("Corso: " + corso.getNome());
            System.out.println("Istruttore: " + istruttore + "\n");
            System.out.println("Inizio: " + corso.getOrarioInizio() + "\n");
            System.out.println("Fine: " + corso.getOrarioFine() + "\n");
        }
    }

    void vediTuttiCorsi(){
        for(Corso corso : corsi){
            String istruttore = corso.getIstruttore();
            System.out.println("Corso: " + corso.getNome());
            System.out.println("Istruttore: " + istruttore + "\n");
            System.out.println("Inizio: " + corso.getOrarioInizio() + "\n");
            System.out.println("Fine: " + corso.getOrarioFine() + "\n");
        }
    }

    boolean prenotaCorso(String corso){
        for (Corso c : corsi){
            if(c.getNome().equals(corso)){
                return c.prenota();
            }
        }
        System.out.println("Corso non presente");
        return false;
    }
    void rimuoviTuttiCorsi(){
        corsi.clear();
    }

    public boolean checkCorsiGiornalieri(String nomeCorso){
        for(Corso c : corsi){
            if(c.getNome().equals(nomeCorso)){
                return true;
            }
        }
        return false;
    }

}
