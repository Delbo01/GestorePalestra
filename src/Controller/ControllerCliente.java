package Controller;

import Allenamento.Scheda;
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

    public void visualizzaScheda(){
        cliente.visualizzaScheda();
    }

    public void vediAbbonamento(){
        cliente.visualizzaScheda();
    }

    public void richiediScheda(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Inserisci i seguenti parametri:");
        System.out.println("->obiettivo :");
        String obbiettivo=sc.nextLine();
        System.out.println("->numero programmi :");
        Boolean fine=false;
        int nP=0;
        while(!fine){
            try {
                nP = sc.nextInt();
                fine=true;
            }catch (InputMismatchException e){
                System.out.println(" per favore iniserisci un intero");
                sc.nextLine();
            }
        }
        System.out.println("->durata programmi :");
        String durata= sc.nextLine();
        sc.close();
        cliente.richiediScheda(obbiettivo,nP,durata);
    }

    public void vediAbbonamneti(){
        cliente.vediAbbonamneti();
    }

    public void ottieniAbbonamento(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Quale abbonamneti vuoi sottoscrivere ?");
        Boolean fine=false;
        int i=0;
        while (!fine){
            try{
                i= sc.nextInt();
                fine=true;
            }catch (InputMismatchException e){
                System.out.println("per favore inserire un intero");
                sc.nextLine();
            }
        }
        System.out.println("Vuoi poter frequentare i corsi ?");
        fine=false;
        Boolean corsi=true;
        while(!fine){
            try {
                corsi=sc.nextBoolean();
                fine=true;
            }catch (InputMismatchException e){
                System.out.println("per favore inserisci un Boolean");
                sc.nextLine();
            }
        }
        cliente.ottieniAbbonamento(i,corsi);
    }
    public void richiediPersonalTrainer(){
        cliente.richiediPersonalTrainer();
    }
    public void richiediPersonalTrainer(String allenatore){
        Scanner sc = new Scanner(System.in);
        System.out.println("Chi vorresti come PT ?");
        String pt =sc.nextLine();
        cliente.richiediPersonalTrainer(pt);
    }
    public void rimuoviPersonalTrainer(){
        cliente.rimuoviPersonalTrainer();
    }
}
