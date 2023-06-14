import Abbonamento.GestoreAbbonamenti;
import Calendario.Calendario;
import Database.*;
import Istruttore.*;
import GestioneRichieste.*;
import GestoreLogin.*;
import Controller.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Calendario calendario = new Calendario(2023);
        GestorePT gestorePT = new GestorePT(10,calendario);
        GestoreAbbonamenti gestoreAbbonamenti = new GestoreAbbonamenti();
        gestoreAbbonamenti.addAbbonamenti(1,"mensile",60,"14/06/2023");
        gestoreAbbonamenti.addAbbonamenti(3,"trimestrale",180,"14/06/2023");
        gestoreAbbonamenti.addAbbonamenti(6,"semestrale",360,"14/06/2023");
        gestoreAbbonamenti.addAbbonamenti(12,"annuale",720,"14/06/2023");
        GestoreRichiestaScheda gestoreRichiestaScheda = new GestoreRichiestaScheda();
        ListaCredenzialiCliente listaCredenzialiCliente = new ListaCredenzialiCliente();
        ListaCredenzialiIstruttore listaCredenzialiIstruttore = new ListaCredenzialiIstruttore();
        GestoreLogin gestoreLogin = new GestoreLogin(listaCredenzialiCliente, listaCredenzialiIstruttore);


        Scanner sc = new Scanner(System.in);
        ControllerLogin controllerLogin= new ControllerLogin(gestoreLogin,gestoreAbbonamenti,gestoreRichiestaScheda,gestorePT,calendario);
        ControllerCliente cliente=new ControllerCliente(controllerLogin.loginCliente(sc),gestoreAbbonamenti,gestorePT,calendario);
        ControllerIstruttore istruttore=new ControllerIstruttore(controllerLogin.loginIstruttore(sc),calendario,gestoreRichiestaScheda,gestorePT);
        cliente.ottieniAbbonamento(sc);
        cliente.richiediScheda(sc);
        istruttore.ottieniRichiestaScheda(sc);
        sc.close();

    }
}