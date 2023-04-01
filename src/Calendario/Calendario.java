package Calendario;

import java.util.ArrayList;

public class Calendario {
    private  int anno;
    private ArrayList<MeseCalendario> calendario = new ArrayList<>();

    public Calendario(int anno){
        this.anno = anno;
        String[] mesi = {"Gennaio","Febbraio","Marzo","Aprile","Maggio","Giugno","Luglio","Agosto","Settembre","Ottobre","Novembre","Dicembre"};
        int[] giorni = {31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i = 0; i < 12;i++){
            calendario.add(new MeseCalendario(giorni[i],mesi[i],i));
        }
    }

    public void inserisciCorso(int mese,int giorno,Corso corso){
        calendario.get((mese - 1)).inserisciCorso(giorno - 1,corso);
    }
    public boolean rimuoviCorso(int mese,int giorno,String corso){
        return calendario.get(mese - 1).rimuoviCorso(giorno - 1,corso);
    }
    public void vediCorsiGiornalieri(int mese,int giorno){
        calendario.get(mese - 1).vediCorsiGiornalieri(giorno - 1);
    }
    public void vediCorsiMensili(int mese){
        calendario.get(mese - 1).vediCorsiMensili();
    }
    public boolean prenotaCorso(int mese, int giorno, String nomeCorso){
        return calendario.get(mese - 1).prenotaCorso(giorno - 1, nomeCorso);
    }
    public boolean rimuoviPrenotazioneCorso(int mese,int giorno,String corso){
        return calendario.get(mese - 1).rimuoviPrenotazioneCorso(giorno - 1,corso);
    }
    public void vediCalendario(){
        for(MeseCalendario mese : calendario){
            mese.vediCorsiMensili();
        }
    }
    public Boolean checkCorsiGiornalieri(int mese,int giorno, String nomeCorso){
        return calendario.get(mese - 1).checkCorsiGiornalieri(giorno - 1,nomeCorso);
    }
    public int getNumeroPrenotazioni(int mese,int giorno,String nomeCorso){
        return calendario.get(mese - 1).getNumeroPrenotazioni(giorno - 1,nomeCorso);
    }

}
