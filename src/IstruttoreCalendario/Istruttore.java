package IstruttoreCalendario;

import Allenamento.Esercizio;
import Allenamento.ProgrammaAllenamento;
import Allenamento.Scheda;
import Cliente.Generalita;
import GestioneRichieste.GestoreRichiestaScheda;
import GestioneRichieste.Richiesta;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Istruttore {
    private Generalita generalita;
    private int numeroAssistiti = 0;
    private Calendario calendario;
    private GestorePT gestorePT;
    private GestoreRichiestaScheda gestoreRichiestaScheda;
    private GestoreRichiestaScheda gestoreRichiestaSchedaPT=null;


    public Istruttore(Generalita gen,Calendario calendario,GestorePT gestore,GestoreRichiestaScheda gestoreRichiestaScheda){
        generalita = gen;
        this.calendario = calendario;
        gestorePT = gestore;
        this.gestoreRichiestaScheda=gestoreRichiestaScheda;
    }
    public Generalita getGeneralita() {
        return generalita;
    }
    public void inserisciCorso(int mese,int giorno,Corso corso){
        calendario.inserisciCorso(mese,giorno,corso);
    }
    public void rimuoviCorso(int mese,int giorno,Corso corso){
        calendario.rimuoviCorso(mese,giorno,corso);
    }
    public int getNumeroAssistiti() {
        return numeroAssistiti;
    }
    public void diventaPT(){
        gestorePT.inserisciPT(this);
        gestoreRichiestaSchedaPT=new GestoreRichiestaScheda();
    }
    void incrementaAssistiti(){
        numeroAssistiti++;
    }
    void rimuoviAssistito(){
        numeroAssistiti--;
    }

    void ottieniRichiestaScheda(){
        Scanner sc = new Scanner(System.in);
        Richiesta richiesta = gestoreRichiestaScheda.ottieniRichiesta();
        String ob = richiesta.getObbiettivo();
        int np = richiesta.getnProg();
        String ne = null;
        int stop;
        int nr = 0;
        int tr = 0;
        int ns = 0;
        String durata = richiesta.getDurataProg();
        Scheda scheda = new Scheda(generalita.getNome(),ob);
        for(int i = 0; i < np; i++){
            ProgrammaAllenamento prog = new ProgrammaAllenamento(durata);
            System.out.println("Programma nr " + (i + 1));
            do {
                System.out.println("Scegli l'esercizio per questo programma");
                ne = sc.nextLine();
                System.out.println("Numero di serie");
                Boolean exit = false;
                while(!exit){
                    try {
                        ns = sc.nextInt();
                        exit = true;

                    }catch (InputMismatchException e){
                        System.out.println("INSERIRE NUMERO INTERO");
                        sc.nextLine();
                    }
                }
                exit = false;
                System.out.println("Numero di Ripetioni");
                while (!exit){
                    try {
                        nr = sc.nextInt();
                        exit = true;
                    }catch (InputMismatchException e){
                        System.out.println("INSERIRE NUMERO INTERO");
                        sc.nextLine();
                    }
                }
                exit = false;
                System.out.println("Scegli il tempo di recupero in minuti");
                while (!exit){
                    try {
                        tr = sc.nextInt();
                        exit = true;
                    }catch (InputMismatchException e){
                        System.out.println("INSERIRE NUMERO INTERO");
                        sc.nextLine();
                    }
                }
                System.out.println("inserisci note aggiuntive");
                String note = sc.nextLine();
                Esercizio e = new Esercizio(ne, ns, nr, tr, note);
                prog.addEsercizio(e);
                System.out.println("Vuoi aggiungere un esercizio (1 si, 0 no)");
                stop = sc.nextInt();
            }while (stop == 1);
        }
        sc.close();
        richiesta.getCliente().setScheda(scheda);
    }
    public void ottiniRichiestaSchedaPT(){
        Scanner sc = new Scanner(System.in);
        Richiesta richiesta = gestoreRichiestaSchedaPT.ottieniRichiesta();
        String ob = richiesta.getObbiettivo();
        int np = richiesta.getnProg();
        String ne = null;
        int stop;
        int nr = 0;
        int tr = 0;
        int ns = 0;
        String durata = richiesta.getDurataProg();
        Scheda scheda = new Scheda(generalita.getNome(),ob);
        for(int i = 0; i < np; i++){
            ProgrammaAllenamento prog = new ProgrammaAllenamento(durata);
            System.out.println("Programma nr " + (i + 1)+"\n");
            do {
                System.out.println("Scegli l'esercizio per questo programma");
                ne = sc.nextLine();
                System.out.println("Numero di serie\n");
                Boolean exit = false;
                while(!exit){
                    try {
                        ns = sc.nextInt();
                        exit = true;

                    }catch (InputMismatchException e){
                        System.out.println("INSERIRE NUMERO INTERO");
                        sc.nextLine();
                    }
                }
                exit = false;
                System.out.println("Numero di Ripetioni");
                while (!exit){
                    try {
                        nr = sc.nextInt();
                        exit = true;
                    }catch (InputMismatchException e){
                        System.out.println("INSERIRE NUMERO INTERO");
                        sc.nextLine();
                    }
                }
                exit = false;
                System.out.println("Scegli il tempo di recupero in minuti");
                while (!exit){
                    try {
                        tr = sc.nextInt();
                        exit = true;
                    }catch (InputMismatchException e){
                        System.out.println("INSERIRE NUMERO INTERO");
                        sc.nextLine();
                    }
                }
                System.out.println("inserisci note aggiuntive");
                String note = sc.nextLine();
                Esercizio e = new Esercizio(ne, ns, nr, tr, note);
                prog.addEsercizio(e);
                System.out.println("Vuoi aggiungere un esercizio (1 si, 0 no)");
                stop = sc.nextInt();
            }while (stop == 1);
        }
        sc.close();
        richiesta.getCliente().setScheda(scheda);

    }

    public GestoreRichiestaScheda getGestoreRichiestaSchedaPT() {
        return gestoreRichiestaSchedaPT;
    }
}
