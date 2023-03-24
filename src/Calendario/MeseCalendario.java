package Calendario;

import java.util.ArrayList;

public class MeseCalendario {
    private ArrayList<GiornoCalendario> mese = new ArrayList<>();
    private final int nGiorni;
    private final String nomeMese;
    private final int nMese;

    public MeseCalendario(int nGiorni, String nomeMese, int nMese) {
        this.nGiorni = nGiorni;
        this.nomeMese = nomeMese;
        this.nMese = nMese;
        for(int i = 0; i < nGiorni;i++){
            mese.add(new GiornoCalendario(i));
        }
    }

    void inserisciCorso(int giorno,Corso corso){
        mese.get(giorno).inserisciCorso(corso);
    }
    boolean rimuoviCorso(int giorno,String corso){
        return mese.get(giorno).rimuoviCorso(corso);
    }
    void vediCorsiGiornalieri(int giorno){
        GiornoCalendario corsi = mese.get(giorno );
        corsi.vediTuttiCorsi();
    }

    void vediCorsiMensili(){
        for(GiornoCalendario giorno : mese){
            giorno.vediTuttiCorsi();
        }
    }
    void rimuoviCorsiGiornalieri(int giorno){
        mese.get(giorno).rimuoviTuttiCorsi();
    }

    void rimuoviCorsiMensili(){
        mese.clear();
    }
    boolean prenotaCorso(int giorno,String corso){
        return mese.get(giorno - 1).prenotaCorso(corso);
    }
    boolean rimuoviPrenotazioneCorso(int giorno,String corso){
        return mese.get(giorno - 1).rimuoviPrenotazione(corso);
    }
    public boolean checkCorsiGiornalieri(int giorno,String nomeCorso){
        return mese.get(giorno - 1).checkCorsiGiornalieri(nomeCorso);
    }
    public int getNumeroPrenotazioni(int giorno,String nomeCorso){
        return mese.get(giorno - 1).getNumeroPrenotazioni(nomeCorso);
    }
}
