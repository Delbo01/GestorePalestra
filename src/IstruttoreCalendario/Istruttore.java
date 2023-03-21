package IstruttoreCalendario;

import Allenamento.Esercizio;
import Allenamento.ProgrammaAllenamento;
import Allenamento.Scheda;
import Calendario.Calendario;
import Cliente.Generalita;
import GestioneRichieste.GestoreRichiestaScheda;
import GestioneRichieste.Richiesta;
import Calendario.Corso;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Istruttore {
    private Generalita generalita;
    private int numeroAssistiti = 0;
    private Calendario calendario;
    private GestorePT gestorePT;
    private GestoreRichiestaScheda gestoreRichiestaScheda;
    private GestoreRichiestaScheda gestoreRichiestaSchedaPT=null;

    final Pattern pattern = Pattern.compile("[0-9]+",Pattern.CASE_INSENSITIVE);


    public Istruttore(Generalita gen,Calendario calendario,GestorePT gestore,GestoreRichiestaScheda gestoreRichiestaScheda){
        generalita = gen;
        this.calendario = calendario;
        gestorePT = gestore;
        this.gestoreRichiestaScheda=gestoreRichiestaScheda;
    }
    public Generalita getGeneralita() {
        return generalita;
    }
    public void inserisciCorso(int mese, int giorno, Corso corso){
        calendario.inserisciCorso(mese,giorno,corso);
    }
    public boolean rimuoviCorso(int mese,int giorno,String corso){
        if(calendario.rimuoviCorso(mese,giorno,corso)){
            System.out.println("Corso rimosso");
            return true;
        }
        return false;
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

    public void ottieniRichiestaScheda(Scanner sc){
        Richiesta richiesta = gestoreRichiestaScheda.ottieniRichiesta();
        String ob = richiesta.getObbiettivo();
        int np = richiesta.getnProg();
        String ne = null;
        boolean number = true;
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
                while (number) {
                    System.out.println("Scegli l'esercizio per questo programma");
                    ne = sc.nextLine();
                    Matcher matcher = pattern.matcher(ne);
                    number = matcher.find();
                    if(number){
                        System.out.println("Il nome dell'esercizio non puo' contenere numeri!");
                    }

                }
                System.out.println("Numero di serie");
                Boolean exit = false;
                while(!exit){
                    try {
                        ns = sc.nextInt();
                        sc.nextLine();
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
                        sc.nextLine();
                        exit = true;
                    }catch (InputMismatchException e){
                        System.out.println("INSERIRE NUMERO INTERO");
                        sc.nextLine();
                    }
                }
                exit = false;
                System.out.println("Scegli il tempo di recupero in secondi");
                while (!exit){
                    try {
                        tr = sc.nextInt();
                        sc.nextLine();
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
                sc.nextLine();
                number = true;
            }while (stop == 1);
        }
        richiesta.getCliente().setScheda(scheda);
    }
    public void ottieniRichiestaSchedaPT(Scanner sc){
        Richiesta richiesta = gestoreRichiestaSchedaPT.ottieniRichiesta();
        String ob = richiesta.getObbiettivo();
        int np = richiesta.getnProg();
        String ne = null;
        boolean number = true;
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
                while (number) {
                    System.out.println("Scegli l'esercizio per questo programma");
                    ne = sc.nextLine();
                    Matcher matcher = pattern.matcher(ne);
                    number = matcher.find();
                    if(number) {
                        System.out.println("Il nome dell'esercizio non puo' contenere numeri!");
                    }
                }
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
                sc.nextLine();
                number = true;
            }while (stop == 1);
        }
        richiesta.getCliente().setScheda(scheda);

    }
    public GestoreRichiestaScheda getGestoreRichiestaSchedaPT() {
        return gestoreRichiestaSchedaPT;
    }
}
