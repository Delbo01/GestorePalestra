package Controller;

import Cliente.*;
import GestioneRichieste.GestoreRichiestaScheda;
import GestoreLogin.GestoreLogin;
import IstruttoreCalendario.Calendario;
import IstruttoreCalendario.GestorePT;
import IstruttoreCalendario.Istruttore;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerLogin {
    private GestoreLogin gestoreLogin;
    private GestoreAbbonamenti gestoreAbbonamenti;
    private GestoreRichiestaScheda gestoreRichiestaScheda;
    private GestorePT gestorePT;
    private Calendario calendario;

    public ControllerLogin(GestoreLogin gestoreLogin, GestoreAbbonamenti gestoreAbbonamenti, GestoreRichiestaScheda gestoreRichiestaScheda, GestorePT gestorePT,Calendario calendario) {
        this.gestoreLogin = gestoreLogin;
        this.gestoreAbbonamenti = gestoreAbbonamenti;
        this.gestoreRichiestaScheda = gestoreRichiestaScheda;
        this.gestorePT = gestorePT;
        this.calendario = calendario;
    }
    public Cliente loginCliente(Scanner sc){
        Cliente c=null;
        int i=0;
        while (c==null & i<3){
            System.out.println("Inserisci username:");
            String username=sc.nextLine();
            System.out.println("Inserisci password:");
            String password=sc.nextLine();
            c=gestoreLogin.loginCliente(username,password);
            i++;
        }
        return c;
    }

    public void registraCliente(Scanner sc) {
        System.out.println("Inserisci username:");
        String username = sc.nextLine();
        System.out.println("Inserisci password:");
        String password = sc.nextLine();
        System.out.println("Inserisci nome:");
        String nome = sc.nextLine();
        System.out.println("Inserisci cognome:");
        String cognome = sc.nextLine();
        System.out.println("Inserisci codice fiscale:");
        String codiceFiscale = sc.nextLine();
        Generalita generalita = new Generalita(codiceFiscale, nome, cognome);
        System.out.println("Inserisci altezza (in cm) :");
        Boolean fine = false;
        float altezza = 0;
        while (!fine) {
            try {
                altezza = sc.nextFloat();
                sc.nextLine();
                fine = true;
            } catch (InputMismatchException e) {
                System.out.println("Inserisci un numero");
                sc.nextLine();
            }
        }
        System.out.println("Inserisci peso:");
        fine = false;
        float peso = 0;
        while (!fine) {
            try {
                peso = sc.nextFloat();
                sc.nextLine();
                fine = true;
            } catch (InputMismatchException e) {
                System.out.println("Inserisci un numero");
                sc.nextLine();
            }
        }
        Cliente cliente = new Cliente(generalita, altezza, peso, gestoreRichiestaScheda, gestoreAbbonamenti, gestorePT);
        gestoreLogin.registraCliente(username, password, cliente);
     }
    public void removeCredenzialiCliente(Scanner sc){
        System.out.println("Inserisci username:");
        String username=sc.nextLine();
        System.out.println("Inserisci password:");
        String password=sc.nextLine();

        gestoreLogin.removeCredenzialiCliente(username,password);
    }
    public void removeCredenzialiIstruttore(Scanner sc){
        System.out.println("Inserisci username:");
        String username=sc.nextLine();
        System.out.println("Inserisci password:");
        String password=sc.nextLine();
        gestoreLogin.removeCredenzialiIstruttore(username,password);
    }
    public Istruttore loginIstruttore(Scanner sc){
        System.out.println("Inserisci username:");
        String username=sc.nextLine();
        System.out.println("Inserisci password:");
        String password=sc.nextLine();
        return gestoreLogin.loginIstruttore(username,password);
    }
    public void registraIstruttore(Scanner sc){
        System.out.println("Inserisci username:");
        String username=sc.nextLine();
        System.out.println("Inserisci password:");
        String password=sc.nextLine();
        System.out.println("Inserisci nome:");
        String nome=sc.nextLine();
        System.out.println("Inserisci cognome:");
        String cognome=sc.nextLine();
        System.out.println("Inserisci codice fiscale:");
        String codiceFiscale=sc.nextLine();
        Generalita generalita = new Generalita(codiceFiscale,nome,cognome);
        Istruttore istruttore = new Istruttore(generalita,calendario,gestorePT,gestoreRichiestaScheda);
        gestoreLogin.registraIstruttore(username,password,istruttore);
    }
}
