package Controller;

import Database.Dao_Corso;
import Database.Dao_Corso_Interface;
import Database.Dao_Istruttore;
import Database.Dao_Istruttore_Interface;
import Corso.Corso;

import java.util.ArrayList;

public class ControllerCorso {
    private  int anno;
    private Dao_Corso_Interface dao_corso= new Dao_Corso();
    private Dao_Istruttore_Interface dao_istruttore= new Dao_Istruttore();

    public ControllerCorso(int anno){
        this.anno=anno;
    }

    public void inserisciCorso(int mese, int giorno, Corso corso){
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
        System.out.println("Giorno "+giorno);
        for(Corso c:corsi){
            System.out.println(c.getNome());
            System.out.println(c.getOrarioInizio());
            System.out.println(c.getOrarioFine());
            System.out.println("Istruttore del corso è :");
            System.out.println(c.getNomeIstruttore()+"  "+c.getCognomeIstruttore());
            System.out.println("Numero di posti massimi:");
            System.out.println(c.getPostiDisponibili());
            System.out.println("Numero di prenotazioni:");
            System.out.println(c.getNumeroPrenotazioni());
        }
    }
    public void vediCorsiMensili(int mese){
        int[] duratamese={31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=1;i<=duratamese[mese-1];i++){
            vediCorsiGiornalieri(mese,i);
        }
    }
    public boolean prenotaCorso(int mese, int giorno, String nomeCorso){
        int id=dao_corso.getIdByNome(nomeCorso,mese,giorno);
        if(id==-1){
            System.out.println("Corso non trovato");
            return false;
        }else {
            dao_corso.addPrenotazione(id);
            return true;
        }
    }
    public boolean rimuoviPrenotazioneCorso(int mese,int giorno,String corso){
        int id=dao_corso.getIdByNome(corso,mese,giorno);
        if(id==-1){
            System.out.println("Corso non trovato");
            return false;
        }else {
            dao_corso.deletePrenotazione(id);
            return true;
        }
    }
    public void vediCalendario(){
        for (int i=1;i<=12;i++){
            System.out.println("Mese: "+i);
            vediCorsiMensili(i);
        }
    }
    public Boolean checkCorsiGiornalieri(int mese,int giorno, String nomeCorso){
        ArrayList<Corso> corsi=dao_corso.vediCorsiGiornalieri(mese,giorno);
        for(Corso c:corsi){
            if(c.getNome().equals(nomeCorso)){
                return true;
            }
        }
        return false;
    }
    public int getNumeroPrenotazioni(int mese,int giorno,String nomeCorso){
        int id=dao_corso.getIdByNome(nomeCorso,mese,giorno);
        int n= dao_corso.getNumeroPrenotazioni(id);
        if (n==-1){
            System.out.println("Corso non trovato");
            return -1;
        }else {
            return n;
        }
    }

}
