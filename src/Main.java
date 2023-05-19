import Abbonamento.GestoreAbbonamenti;
import Calendario.Calendario;
import Database.Base_Dao;
import Database.Dao_Cliente;
import Istruttore.*;
import GestioneRichieste.*;
import GestoreLogin.*;
import Controller.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InterruptedException{
       Dao_Cliente dao_cliente = new Dao_Cliente();
        dao_cliente.createCliente(2,"Mario","Rossi","MRORSS00A00A000A",180,75);
        /*Calendario calendario = new Calendario(2023);
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
        sc.close();*/

    }
}