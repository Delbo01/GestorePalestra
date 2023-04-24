import Abbonamento.GestoreAbbonamenti;
import Calendario.Calendario;
import Istruttore.*;
import GestioneRichieste.*;
import GestoreLogin.*;
import Controller.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InterruptedException{
        Calendario calendario = new Calendario(2023);
        GestorePT gestorePT = new GestorePT(10);
        GestoreAbbonamenti gestoreAbbonamenti = new GestoreAbbonamenti();
        gestoreAbbonamenti.addAbbonamenti(1,"mensile",60);
        gestoreAbbonamenti.addAbbonamenti(3,"trimestrale",180);
        gestoreAbbonamenti.addAbbonamenti(6,"semestrale",360);
        gestoreAbbonamenti.addAbbonamenti(12,"annuale",720);
        GestoreRichiestaScheda gestoreRichiestaScheda = new GestoreRichiestaScheda();
        ListaCredenzialiCliente listaCredenzialiCliente = new ListaCredenzialiCliente();
        ListaCredenzialiIstruttore listaCredenzialiIstruttore = new ListaCredenzialiIstruttore();
        GestoreLogin gestoreLogin = new GestoreLogin(listaCredenzialiCliente, listaCredenzialiIstruttore);


        Scanner sc = new Scanner(System.in);
        ControllerLogin controllerLogin= new ControllerLogin(gestoreLogin,gestoreAbbonamenti,gestoreRichiestaScheda,gestorePT,calendario);
        controllerLogin.registraCliente(sc);
        ControllerCliente cliente=new ControllerCliente(controllerLogin.loginCliente(sc),gestoreAbbonamenti,gestorePT);
        cliente.ottieniAbbonamento(sc);
        sc.close();

    }
}