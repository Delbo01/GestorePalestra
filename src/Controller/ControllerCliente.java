package Controller;

import Allenamento.Scheda;
import Cliente.Cliente;

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
        int nProg=sc.nextInt();
        System.out.println("->durata programmi :");
        String durata= sc.nextLine();
        sc.close();
        cliente.richiediScheda(obbiettivo,nProg,durata);
    }

    public void vediAbbonamneti(){
        cliente.vediAbbonamneti();
    }


}
