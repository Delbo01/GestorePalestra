package Controller;

import Cliente.Cliente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerCliente {
    Cliente cliente;
    public ControllerCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void vediAbbonamenti(){
        cliente.vediAbbonamneti();
    }

    public void visualizzaScheda(Scanner sc){
        cliente.visualizzaScheda(sc);
    }

    public void vediAbbonamento(Scanner sc){
        cliente.visualizzaScheda(sc);
    }

    public void richiediScheda(Scanner sc){
        System.out.println("Inserisci i seguenti parametri:");
        System.out.println("->obiettivo :");
        String obbiettivo=sc.nextLine();
        System.out.println("->numero programmi :");
        boolean fine=false;
        int nP=0;
        while(!fine){
            try {
                nP = sc.nextInt();
                sc.nextLine();
                fine=true;
            }catch (InputMismatchException e){
                System.out.println(" per favore iniserisci un intero");
                sc.nextLine();
            }
        }
        System.out.println("->durata programmi :");
        String durata= sc.nextLine();
        cliente.richiediScheda(obbiettivo,nP,durata);
    }

    public void vediAbbonamneti(){
        cliente.vediAbbonamneti();
    }

    public void ottieniAbbonamento(Scanner sc){
        System.out.println("Quale abbonamento vuoi sottoscrivere ?");
        boolean fine=false;
        int i=0;
        while (!fine){
            try{
                i= sc.nextInt();
                sc.nextLine();
                fine=true;
            }catch (InputMismatchException e){
                System.out.println("per favore inserire un intero");
                sc.nextLine();
            }
        }
        System.out.println("Vuoi poter frequentare i corsi ?");
        fine=false;
        boolean corsi=true;
        while(!fine){
            try {
                corsi=sc.nextBoolean();
                sc.nextLine();
                fine=true;
            }catch (InputMismatchException e){
                System.out.println("per favore inserisci un Boolean");
                sc.nextLine();
            }
        }
        cliente.ottieniAbbonamento(i-1,corsi);
    }
    public void richiediPersonalTrainer(){
        cliente.richiediPersonalTrainer();
    }
    public void richiediPersonalTrainer(Scanner sc){
        System.out.println("Chi vorresti come PT ?");
        String pt =sc.nextLine();
        cliente.richiediPersonalTrainer(pt);
    }
    public void rimuoviPersonalTrainer(){
        cliente.rimuoviPersonalTrainer();
    }

    public void vediCorsiGiornalieri(Scanner sc){
        System.out.println("Inserisci il mese");
        int mese=0;
        boolean fine=false;
        while(!fine){
            try {
                mese=sc.nextInt();
                sc.nextLine();
                fine=true;
            }catch (InputMismatchException e){
                System.out.println("per favore inserisci un intero");
                sc.nextLine();
            }
        }
        fine=false;
        int giorno=0;
        while(!fine){
            try {
                giorno=sc.nextInt();
                sc.nextLine();
                fine=true;
            }catch (InputMismatchException e){
                System.out.println("per favore inserisci un intero");
                sc.nextLine();
            }
        }
        cliente.vediCorsiGiornalieri(mese,giorno);
    }

    public void vediCorsiMensili(Scanner sc){
        System.out.println("Inserisci il mese");
        int mese=0;
        boolean fine=false;
        while(!fine){
            try {
                mese=sc.nextInt();
                sc.nextLine();
                fine=true;
            }catch (InputMismatchException e){
                System.out.println("per favore inserisci un intero");
                sc.nextLine();
            }
        }
        cliente.vediCorsiMensili(mese);
    }

    public void vediCalendario(){
        cliente.vediCalendario();
    }
    public void prenotaCorso(Scanner sc){
        System.out.println("Inserisci il mese");
        int mese=0;
        boolean fine=false;
        while(!fine){
            try {
                mese=sc.nextInt();
                sc.nextLine();
                fine=true;
            }catch (InputMismatchException e){
                System.out.println("per favore inserisci un intero");
                sc.nextLine();
            }
        }
        fine=false;
        int giorno=0;
        while(!fine){
            try {
                System.out.println("Inserisci il giorno");
                giorno=sc.nextInt();
                sc.nextLine();
                fine=true;
            }catch (InputMismatchException e){
                System.out.println("per favore inserisci un intero");
                sc.nextLine();
            }
        }
        System.out.println("Inserisci il nome del corso");
        String nomeCorso=sc.nextLine();
        cliente.prenotaCorso(mese,giorno,nomeCorso);
    }
    public void rimuoviPrenotazioneCorso(Scanner sc){
        System.out.println("Inserisci il mese");
        int mese=0;
        boolean fine=false;
        while(!fine){
            try {
                mese=sc.nextInt();
                sc.nextLine();
                fine=true;
            }catch (InputMismatchException e){
                System.out.println("per favore inserisci un intero");
                sc.nextLine();
            }
        }
        fine=false;
        int giorno=0;
        while(!fine){
            try {
                System.out.println("Inserisci il giorno");
                giorno=sc.nextInt();
                sc.nextLine();
                fine=true;
            }catch (InputMismatchException e){
                System.out.println("per favore inserisci un intero");
                sc.nextLine();
            }
        }
        System.out.println("Inserisci il nome del corso");
        String nomeCorso=sc.nextLine();
        cliente.rimuoviPrenotazioneCorso(mese,giorno,nomeCorso);
    }
    public void vediCorsiEPrenotaOCancella(Scanner sc){
        System.out.println("Inserisre 1 per vedre i corsi dell'intero calendario, inserire 2 per vedere i cordi di un mese a scelta oppure inserire 3 per vedere i corsi di un giorno a scelta: ");
        int scelta=sc.nextInt();
        sc.nextLine();
        boolean rip;
        do{
            rip=false;
            if (scelta==1) {
            vediCalendario();
            }else if (scelta==2){
            vediCorsiMensili(sc);}
            else if (scelta==3){
            vediCorsiGiornalieri(sc);
            }else {
            System.out.println("Scelta non valida");
            rip=true;
        }
        }while (rip);
        System.out.println("Vuoi prenotare un corso o vuoi cancellare la prenotazione da un corso? (1/2)");
        scelta=sc.nextInt();
        sc.nextLine();
        if (scelta==1){
            prenotaCorso(sc);}
        else if (scelta==2){
            rimuoviPrenotazioneCorso(sc);
        }
        else {
            System.out.println("Scelta non valida");
        }
    }
}

