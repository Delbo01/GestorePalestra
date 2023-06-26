package Controller;

import Allenamento.Esercizio;
import Allenamento.ProgrammaAllenamento;
import Allenamento.Scheda;
import Database.*;
import GestioneRichieste.GestoreRichiestaScheda;
import GestioneRichieste.Richiesta;
import Istruttore.*;
import Calendario.Corso;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerIstruttore {
    private final Istruttore istruttore;
    private final Calendario calendario;
    private GestoreRichiestaScheda gestoreRichiestaScheda;

    private GestorePT gestorePT;
    private Dao_Scheda_Interface daoScheda = new Dao_Scheda();
    private Dao_Istruttore_Interface daoIstruttore = new Dao_Istruttore();
    private final Dao_PT_Cliente_Interface daoPT_Cliente = new Dao_PT_Cliente();
    private Dao_Programma_Interface daoProgramma = new Dao_Programma();
    private Dao_Esercizi_Interface daoEsercizio = new Dao_Esercizi();
    private Dao_Cliente_Interface daoCliente= new Dao_Cliente();
    private Dao_Scheda_Cliente_Interface daoScheda_Cliente = new Dao_Scheda_Cliente();
    final Pattern pattern = Pattern.compile("[0-9]+",Pattern.CASE_INSENSITIVE);


    public ControllerIstruttore(Istruttore istruttore,Calendario calendario,GestoreRichiestaScheda gr,GestorePT gestorePT){
        this.istruttore = istruttore;
        if (daoIstruttore.isPT(daoIstruttore.getIdByNomeCognome(istruttore.getGeneralita().getNome(),istruttore.getGeneralita().getCognome())))
            istruttore.diventaPT();
        this.calendario = calendario;
        gestoreRichiestaScheda = gr;
        this.gestorePT = gestorePT;
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
        Corso corso= new Corso(nomeCorso,posti,oraInizio,oraFine,istruttore.getGeneralita().getNome(),istruttore.getGeneralita().getCognome(),0);
        calendario.inserisciCorso(mese,giorno,corso);
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
        calendario.rimuoviCorso(mese, giorno, nomeCorso);
    }
    public void diventaPT(){
        gestorePT.inserisciPT(istruttore);
        int id=daoIstruttore.getIdByNomeCognome(istruttore.getGeneralita().getNome(),istruttore.getGeneralita().getCognome());
        daoIstruttore.setPt(id,true);
        istruttore.diventaPT();
    }
    public void ottieniRichiestaScheda(Scanner sc){
        Richiesta richiesta = gestoreRichiestaScheda.ottieniRichiesta();
        if (richiesta==null){
            System.out.println("Non ci sono richieste di scheda");
        }else {
            String ob = richiesta.getObbiettivo();
            int np = richiesta.getnProg();
            System.out.println("Obbiettivo: " + ob);
            System.out.println("Numero di programmi: " + np);
            String ne = null;
            boolean number = true;
            int stop;
            int nr = 0;
            int tr = 0;
            int ns = 0;
            String durata = richiesta.getDurataProg();
            Scheda scheda = new Scheda((istruttore.getGeneralita().getNome() + istruttore.getGeneralita().getCognome()),ob);
            int idIstruttore=daoIstruttore.getIdByNomeCognome(istruttore.getGeneralita().getNome(),istruttore.getGeneralita().getCognome());
            int idScheda=daoScheda.getMaxIdScheda()+1;
            daoScheda.createScheda(idIstruttore,idScheda,ob,np);
            for(int i = 0; i < np; i++){
                ProgrammaAllenamento prog = new ProgrammaAllenamento(durata);
                int idProgr=daoProgramma.getMaxIdProgramma()+1;
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
                    boolean exit = false;
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
                    System.out.println("Numero di Ripetizioni");
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
                int nes=prog.getnEsercizi();
                daoProgramma.creaProgramma(idProgr,idScheda,nes,durata);
                for (int j=0;j<nes;j++){
                    int idEsercizio=daoEsercizio.getMaxIdEsercizio()+1;
                    String nomeEsercizio=prog.getEsercizio(j).getNome();
                    int serie=prog.getEsercizio(j).getSerie();
                    int ripetizioni=prog.getEsercizio(j).getReps();
                    int tempoRecupero=prog.getEsercizio(j).getTempoRecupero();
                    String note=prog.getEsercizio(j).getNote();
                    int carico=prog.getEsercizio(j).getCarico();
                    daoEsercizio.createEsercizio(idEsercizio,idProgr,nomeEsercizio,serie,ripetizioni,tempoRecupero,carico,note);
                }
                scheda.addProgramma(prog);
            }
            int idC=daoCliente.getIdByCf(richiesta.getCliente().getGeneralita().getCf());
            if (daoScheda_Cliente.checkScheda_Cliente(idC))
                daoScheda_Cliente.updateScheda_Cliente(idC,idScheda);
            else
                daoScheda_Cliente.createScheda_Cliente(idC,idScheda);
        }
    }


    public void ottieniRichiestaSchedaPT(Scanner sc){
        if(istruttore.getGestoreRichiestaSchedaPT() == null){
            System.out.println("Non sei ancora un personal trainer");
        }
        else{
            Richiesta richiesta = istruttore.getGestoreRichiestaSchedaPT().ottieniRichiesta();
            if (richiesta == null){
                System.out.println("Non ci sono richieste di scheda");
            }
            else{
                String ob = richiesta.getObbiettivo();
                int np = richiesta.getnProg();
                System.out.println("Obbiettivo: " + ob);
                System.out.println("Numero di programmi: " + np);
                String ne = null;
                boolean number = true;
                int stop;
                int nr = 0;
                int tr = 0;
                int ns = 0;
                String durata = richiesta.getDurataProg();
                int idIstruttore=daoIstruttore.getIdByNomeCognome(istruttore.getGeneralita().getNome(),istruttore.getGeneralita().getCognome());
                int idScheda=daoScheda.getMaxIdScheda()+1;
                daoScheda.createScheda(idIstruttore,idScheda,ob,np);
                Scheda scheda = new Scheda((istruttore.getGeneralita().getNome() + istruttore.getGeneralita().getCognome()),ob);
                for(int i = 0; i < np; i++){
                    ProgrammaAllenamento prog = new ProgrammaAllenamento(durata);
                    int idProgr=daoProgramma.getMaxIdProgramma()+1;
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
                        boolean exit = false;
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
                        System.out.println("Vuoi aggiungere un esercizio? (1 si, 0 no)");
                        stop = sc.nextInt();
                        sc.nextLine();
                        number = true;
                    }while (stop == 1);
                    int nes=prog.getnEsercizi();
                    daoProgramma.creaProgramma(idProgr,idScheda,nes,durata);
                    for (int j=0;j<nes;j++){
                        int idEsercizio=daoEsercizio.getMaxIdEsercizio()+1;
                        String nomeEsercizio=prog.getEsercizio(j).getNome();
                        int serie=prog.getEsercizio(j).getSerie();
                        int ripetizioni=prog.getEsercizio(j).getReps();
                        int tempoRecupero=prog.getEsercizio(j).getTempoRecupero();
                        String note=prog.getEsercizio(j).getNote();
                        int carico=prog.getEsercizio(j).getCarico();
                        daoEsercizio.createEsercizio(idEsercizio,idProgr,nomeEsercizio,serie,ripetizioni,tempoRecupero,carico,note);
                    }
                    scheda.addProgramma(prog);
                }
                int idC=daoCliente.getIdByCf(richiesta.getCliente().getGeneralita().getCf());
                daoScheda_Cliente.createScheda_Cliente(idC,idScheda);
            }
        }
    }

}
