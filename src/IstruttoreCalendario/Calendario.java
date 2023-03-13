package IstruttoreCalendario;

import java.util.ArrayList;

public class Calendario {
    private int anno;
    private ArrayList<MeseCalendario> calendario = new ArrayList<>();

    public Calendario(int anno){
        this.anno = anno;
        for(int i = 0; i < 12;i++){
            calendario.add(new MeseCalendario(30,"Gennaio",i));
        }
    }

    void inserisciCorso(int mese,int giorno,Corso corso){
        calendario.get((mese - 1)).inserisciCorso(giorno - 1,corso);
    }
    void rimuoviCorso(int mese,int giorno,String corso){
        calendario.get(mese - 1).rimuoviCorso(giorno - 1,corso);
    }
    public void vediCorsiGiornalieri(int mese,int giorno){
        calendario.get(mese - 1).vediCorsiGiornalieri(giorno - 1);
    }
    public void vediCorsiMensili(int mese){
        calendario.get(mese - 1).vediCorsiMensili();
    }
    public boolean prenotaCorso(int mese,int giorno,Corso corso){
        return calendario.get(mese - 1).prenotaCorso(giorno - 1,corso);
    }
    public boolean rimuoviPrenotazioneCorso(int mese,int giorno,Corso corso){
        return calendario.get(mese - 1).rimuoviPrenotazioneCorso(giorno - 1,corso);
    }

}
