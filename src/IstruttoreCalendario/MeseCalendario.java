package IstruttoreCalendario;

import java.util.ArrayList;

public class MeseCalendario {
    private ArrayList<GiornoCalendario> mese = new ArrayList<>();
    private int nGiorni;
    private String nomeMese;
    private int nMese;

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
    void rimuoviCorso(int giorno,Corso corso){
        mese.get(giorno).rimuoviCorso(corso);
    }
    void vediCorsiGiornalieri(int giorno){
        GiornoCalendario corsi = mese.get(giorno);
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
    boolean prenotaCorso(int giorno,Corso corso){
        return mese.get(giorno).prenotaCorso(corso);
    }
    boolean rimuoviPrenotazioneCorso(int giorno,Corso corso){
        return mese.get(giorno).rimuoviPrenotazione(corso);
    }
}
