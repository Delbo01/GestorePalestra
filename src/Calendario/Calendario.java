package Calendario;

import Database.Dao_Corso;
import Database.Dao_Corso_Interface;
import Database.Dao_Istruttore;
import Database.Dao_Istruttore_Interface;

import java.util.ArrayList;

public class Calendario {
    private  int anno;
    private Dao_Corso_Interface dao_corso= new Dao_Corso();
    private Dao_Istruttore_Interface dao_istruttore= new Dao_Istruttore();

    public Calendario(int anno){
        this.anno=anno;
    }

    public void inserisciCorso(int mese,int giorno,Corso corso){
       int id=dao_corso.getMaxId()+1;
       String nomeIstruttore=corso.getNomeIstruttore();
       String cogonmeIstruttore=corso.getCognomeIstruttore();
       int idIstruttore=dao_istruttore.getIdByNomeCognome(nomeIstruttore,cogonmeIstruttore);
       dao_corso.createCorso(id,corso.getNome(),corso.getPostiDisponibili(),corso.getOrarioInizio(),corso.getOrarioFine(),idIstruttore, corso.getNumeroPrenotazioni(),mese,giorno);
    }
    public boolean rimuoviCorso(int mese,int giorno,String corso){
        int id =dao_corso.getIdByNome(corso,mese,giorno);
        if(id==-1){
            System.out.println("Corso non trovato");
            return false;
        }else {
            dao_corso.removeCorso(id);
            return true;
        }
    }
    public void vediCorsiGiornalieri(int mese,int giorno){
        ArrayList<Corso> corsi=dao_corso.vediCorsiGiornalieri(mese,giorno);
        for(Corso c:corsi){
            System.out.println(c.getNome());
            System.out.println(c.getOrarioInizio());
            System.out.println(c.getOrarioFine());
            System.out.println("Istruttore del corso è :");
            System.out.println(c.getNomeIstruttore()+"  "+c.getCognomeIstruttore());
            System.out.println("Numero di posti disponibili:");
            System.out.println(c.getPostiDisponibili());
            System.out.println("Numero di prenotazioni:");
            System.out.println(c.getNumeroPrenotazioni());
        }
    }
    public void vediCorsiMensili(int mese){

    }
    public boolean prenotaCorso(int mese, int giorno, String nomeCorso){

    }
    public boolean rimuoviPrenotazioneCorso(int mese,int giorno,String corso){

    }
    public void vediCalendario(){

    }
    public Boolean checkCorsiGiornalieri(int mese,int giorno, String nomeCorso){

    }
    public int getNumeroPrenotazioni(int mese,int giorno,String nomeCorso){

    }

}
