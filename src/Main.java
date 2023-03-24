import Calendario.Calendario;
import Cliente.*;
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
        gestoreAbbonamenti.addAbbonamneti(1,"mensile",60);
        gestoreAbbonamenti.addAbbonamneti(3,"trimestrale",180);
        gestoreAbbonamenti.addAbbonamneti(6,"semestrale",360);
        gestoreAbbonamenti.addAbbonamneti(12,"annuale",720);
        GestoreRichiestaScheda gestoreRichiestaScheda = new GestoreRichiestaScheda();
        ListaCredenzialiCliente listaCredenzialiCliente = new ListaCredenzialiCliente();
        ListaCredenzialiIstruttore listaCredenzialiIstruttore = new ListaCredenzialiIstruttore();
        GestoreLogin gestoreLogin = new GestoreLogin(listaCredenzialiCliente, listaCredenzialiIstruttore);


        Scanner sc = new Scanner(System.in);


        ControllerLogin controllerlogin = new ControllerLogin(gestoreLogin, gestoreAbbonamenti, gestoreRichiestaScheda, gestorePT, calendario);

        controllerlogin.registraCliente(sc);

        Cliente c=controllerlogin.loginCliente(sc);
        ControllerCliente controllerCliente= new ControllerCliente(c);


        controllerCliente.richiediScheda(sc);

        controllerlogin.registraIstruttore(sc);
        Istruttore i=controllerlogin.loginIstruttore(sc);

        ControllerIstruttore controllerIstruttore= new ControllerIstruttore(i,calendario);
        controllerIstruttore.ottieniRichiestaScheda(sc);

        controllerCliente.visualizzaScheda(sc);
        sc.close();

    }
}