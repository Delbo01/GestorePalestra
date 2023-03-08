package IstruttoreCalendario;

import Allenamento.Esercizio;
import Allenamento.ProgrammaAllenamento;
import Allenamento.Scheda;
import Cliente.Cliente;
import Cliente.Generalita;
import GestioneRichieste.GestoreRichiestaScheda;
import GestioneRichieste.Richiesta;

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
        String durata = richiesta.getDurataProg();
        Scheda scheda = new Scheda(generalita.getNome(),ob);
        for(int i = 0; i < np; i++){
            ProgrammaAllenamento prog = new ProgrammaAllenamento(durata);
            System.out.println("Programma nr " + (i + 1));
            int end;
            do {
                System.out.println("Scegli l'esercizio per questo programma");
                String ne = sc.nextLine();
                System.out.println("Numero di serie");
                int ns = sc.nextInt();
                System.out.println("Numero di Ripetioni");
                int nr = sc.nextInt();
                System.out.println("Scegli il tempo di recupero in minuti");
                int tr = sc.nextInt();
                System.out.println("inserisci note aggiuntive");
                String note = sc.nextLine();
                Esercizio e = new Esercizio(ne, ns, nr, tr, note);
                prog.addEsercizio(e);
                System.out.println("Vuoi aggiungere un esercizio (1 si, 0 no)");
                end = sc.nextInt();
            }while (end == 1);
        }
        richiesta.getCliente().setScheda(scheda);
    }
    public void ottiniRichiestaSchedaPT(){
        Scanner sc = new Scanner(System.in);
        Richiesta richiesta = gestoreRichiestaSchedaPT.ottieniRichiesta();
        String ob = richiesta.getObbiettivo();
        int np = richiesta.getnProg();
        String durata = richiesta.getDurataProg();
        Scheda scheda = new Scheda(generalita.getNome(),ob);
        for(int i = 0; i < np; i++){
            ProgrammaAllenamento prog = new ProgrammaAllenamento(durata);
            System.out.println("Programma nr " + (i + 1));
            int end;
            do {
                System.out.println("Scegli l'esercizio per questo programma");
                String ne = sc.nextLine();
                System.out.println("Numero di serie");
                int ns = sc.nextInt();
                System.out.println("Numero di Ripetioni");
                int nr = sc.nextInt();
                System.out.println("Scegli il tempo di recupero in minuti");
                int tr = sc.nextInt();
                System.out.println("inserisci note aggiuntive");
                String note = sc.nextLine();
                Esercizio e = new Esercizio(ne, ns, nr, tr, note);
                prog.addEsercizio(e);
                System.out.println("Vuoi aggiungere un esercizio (1 si, 0 no)");
                end = sc.nextInt();
            }while (end == 1);
        }
        richiesta.getCliente().setScheda(scheda);
    }

    public GestoreRichiestaScheda getGestoreRichiestaSchedaPT() {
        return gestoreRichiestaSchedaPT;
    }
}
