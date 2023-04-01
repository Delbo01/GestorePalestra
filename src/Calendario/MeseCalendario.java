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
        if (mese.get(giorno) == null)
            return false;
        else
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
        if (mese.get(giorno) != null)
            mese.get(giorno).rimuoviTuttiCorsi();
    }

    void rimuoviCorsiMensili(){
        for(GiornoCalendario giorno : mese){
            giorno.rimuoviTuttiCorsi();
        }
    }
    boolean prenotaCorso(int giorno,String corso){
        if (mese.get(giorno) == null)
            return false;
        else
            return mese.get(giorno).prenotaCorso(corso);
    }
    boolean rimuoviPrenotazioneCorso(int giorno,String corso){
        if (mese.get(giorno) == null)
            return false;
        else
            return mese.get(giorno).rimuoviPrenotazione(corso);
    }
    public boolean checkCorsiGiornalieri(int giorno,String nomeCorso){
        if (mese.get(giorno) == null)
            return false;
        else return mese.get(giorno).checkCorsiGiornalieri(nomeCorso);
    }
    public int getNumeroPrenotazioni(int giorno,String nomeCorso){
        if (mese.get(giorno) == null)
            return 0;
        else
            return mese.get(giorno).getNumeroPrenotazioni(nomeCorso);
    }
}
