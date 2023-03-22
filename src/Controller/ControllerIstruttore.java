package Controller;

import Calendario.Calendario;
import Istruttore.*;
import Calendario.Corso;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerIstruttore {
    private final Istruttore istruttore;
    private final Calendario calendario;

    public ControllerIstruttore(Istruttore istruttore,Calendario calendario){
        this.istruttore=istruttore;
        this.calendario=calendario;
    }

    public void inserisciCorso(Scanner sc){
        int mese=0;
        int giorno=0;
        String nomeCorso;
        boolean rip;
        do{
        System.out.println("Scegli il mese del corso (inserisci il numero del mese, per esmpio 9 per indicare Settembre): ");
        boolean fine=false;
        while (!fine){
            try{
                mese= sc.nextInt();
                sc.nextLine();
                fine=true;
            }catch (InputMismatchException e){
                System.out.println("per favore inserire un intero");
                sc.nextLine();
            }
        }
        System.out.println("Scegli il giorno del corso");
        fine=false;
        while (!fine){
            try{
                giorno= sc.nextInt();
                sc.nextLine();
                fine=true;
            }catch (InputMismatchException e){
                System.out.println("per favore inserire un intero");
                sc.nextLine();
            }
        }
        System.out.println("Inserisci il nome del corso");
        nomeCorso=sc.nextLine();
        rip=calendario.checkCorsiGiornalieri(mese,giorno,nomeCorso);
        if (rip)
            System.out.println("Il corso è già presente in questo giorno, scegliere un altro giorno o un altro nome per il corso");
        }while(rip);

        System.out.println("Inserisci il numero di posti disponibili");
        int posti=0;
        boolean fine=false;
        while (!fine){
            try{
                posti= sc.nextInt();
                sc.nextLine();
                fine=true;
            }catch (InputMismatchException e){
                System.out.println("per favore inserire un intero");
                sc.nextLine();
            }
        }
        System.out.println("Inserisci l'ora di inizio del corso");
        String oraInizio=sc.nextLine();
        System.out.println("Inserisci l'ora di fine del corso");
        String oraFine=sc.nextLine();
        System.out.println("Inserisci il nome dell'istruttore del corso");
        String nomeIstruttore=sc.nextLine();
        Corso corso= new Corso(nomeCorso,posti,oraInizio,oraFine,nomeIstruttore);
        istruttore.inserisciCorso(mese,giorno,corso);
    }

    public void rimuoviCorso(Scanner sc) {
        System.out.println("Scegli il mese del corso (inserisci il numero del mese, per esempio 9 per indicare Settembre): ");
        int mese = 0;
        boolean fine = false;
        while (!fine) {
            try {
                mese = sc.nextInt();
                sc.nextLine();
                fine = true;
            } catch (InputMismatchException e) {
                System.out.println("per favore inserire un intero");
                sc.nextLine();
            }
        }
        System.out.println("Scegli il giorno del corso");
        int giorno = 0;
        fine = false;
        while (!fine) {
            try {
                giorno = sc.nextInt();
                sc.nextLine();
                fine = true;
            } catch (InputMismatchException e) {
                System.out.println("per favore inserire un intero");
                sc.nextLine();
            }
        }
        System.out.println("Inserisci il nome del corso");
        String nomeCorso = sc.nextLine();
        istruttore.rimuoviCorso(mese, giorno, nomeCorso);
    }
    public void diventaPT(){
        istruttore.diventaPT();
    }

    public void ottieniRichiestaScheda(Scanner sc){
        istruttore.ottieniRichiestaScheda(sc);
    }

    public void ottieniRichiestaSchedaPT(Scanner sc){
        istruttore.ottieniRichiestaSchedaPT(sc);
    }
}
