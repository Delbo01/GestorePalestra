package Controller;

import Abbonamento.*;
import Cliente.*;
import Database.*;
import GestioneRichieste.GestoreRichiestaScheda;
import GestoreLogin.GestoreLogin;
import Calendario.Calendario;
import Istruttore.GestorePT;
import Istruttore.Istruttore;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerLogin {
    private final GestoreLogin gestoreLogin;
    private final GestoreAbbonamenti gestoreAbbonamenti;
    private final GestoreRichiestaScheda gestoreRichiestaScheda;
    private final GestorePT gestorePT;
    private final Calendario calendario;
    private final Dao_Cliente_Interface dao_cliente= new Dao_Cliente();
    private final Dao_Istruttore_Interface dao_istruttore= new Dao_Istruttore();
    private final Dao_CredenzialiCliente_Interface dao_credenzialiCliente= new Dao_CredenzialiCliente();
    private final Dao_CredenzialiIstruttore_Interface dao_credenzialiIstruttore= new Dao_CredenzialiIstruttore();

    public ControllerLogin(GestoreLogin gestoreLogin, GestoreAbbonamenti gestoreAbbonamenti, GestoreRichiestaScheda gestoreRichiestaScheda, GestorePT gestorePT,Calendario calendario) {
        this.gestoreLogin = gestoreLogin;
        this.gestoreAbbonamenti = gestoreAbbonamenti;
        this.gestoreRichiestaScheda = gestoreRichiestaScheda;
        this.gestorePT = gestorePT;
        this.calendario = calendario;
    }
    public Cliente loginCliente(Scanner sc){
        System.out.println("Login Cliente in corso...");
        Cliente c=null;
        int i=0;
        while (c==null & i<3){
            System.out.println("Inserisci username:");
            String username=sc.nextLine();
            System.out.println("Inserisci password:");
            String password=sc.nextLine();
            c=dao_credenzialiCliente.search(username,password);
            c.setCalendario(calendario);
            c.setGestoreRichiestaScheda(gestoreRichiestaScheda);
            i++;
        }
        return c;
    }

    public void registraCliente(Scanner sc) {
        int id=dao_cliente.getMaxId()+1;
        System.out.println("Registarzione Cliente in corso...");
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
        boolean fine = false;
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
        Cliente cliente = new Cliente(generalita, altezza, peso, gestoreRichiestaScheda, calendario);
        /*cliente.vediAbbonamneti();
        System.out.println("Quale abbonamento vuoi sottoscrivere ?");
        fine=false;
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
        Abbonamento abbonamento=gestoreAbbonamenti.getAbbonamneto(i-1,corsi);
        AbbonamentoMapper abbonamentoMapper=new AbbonamentoMapper(cliente,abbonamento);*/
        dao_cliente.createCliente(id,nome,cognome,codiceFiscale,altezza,peso);
        dao_credenzialiCliente.createCredenziali(username,password,id);
        gestoreLogin.registraCliente(username, password, cliente);
     }
    public void removeCredenzialiCliente(Scanner sc){
        System.out.println("Inserisci username:");
        String username=sc.nextLine();
        System.out.println("Inserisci password:");
        String password=sc.nextLine();
        dao_credenzialiCliente.deleteCredenziali(username,password);
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
        System.out.println("Login Istruttore in corso...");
        Istruttore is=null;
        int i=0;
        while (is==null & i<3){
            System.out.println("Inserisci username:");
            String username=sc.nextLine();
            System.out.println("Inserisci password:");
            String password=sc.nextLine();
            is=dao_credenzialiIstruttore.search(username,password);
            is.setCalendario(calendario);
            i++;
        }
        return is;
    }
    public void registraIstruttore(Scanner sc){

        System.out.println("Registrazione Istruttore in corso...");
        int id=dao_istruttore.getMaxId()+1;
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
        Istruttore istruttore = new Istruttore(generalita,calendario);
        dao_istruttore.createIstruttore(id, nome,cognome,codiceFiscale,false,0);
        dao_credenzialiIstruttore.createCredenziali(username,password,id);
        gestoreLogin.registraIstruttore(username,password,istruttore);
    }
}
