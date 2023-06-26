import Abbonamento.GestoreAbbonamenti;
import Controller.Calendario;
import GestioneRichieste.*;
import GestoreLogin.*;
import Controller.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Calendario calendario = new Calendario(2023);
        GestorePT gestorePT = new GestorePT(10,calendario);
        GestoreAbbonamenti gestoreAbbonamenti = new GestoreAbbonamenti();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateString = currentDate.format(formatter);
        gestoreAbbonamenti.addAbbonamenti(1,"mensile",60, dateString);
        gestoreAbbonamenti.addAbbonamenti(3,"trimestrale",180,dateString);
        gestoreAbbonamenti.addAbbonamenti(6,"semestrale",360,dateString);
        gestoreAbbonamenti.addAbbonamenti(12,"annuale",720,dateString);
        GestoreRichiestaScheda gestoreRichiestaScheda = new GestoreRichiestaScheda();

        Scanner sc = new Scanner(System.in);
        ControllerLogin controllerLogin= new ControllerLogin(gestoreAbbonamenti,gestoreRichiestaScheda,gestorePT,calendario);
        ControllerCliente cliente=new ControllerCliente(controllerLogin.loginCliente(sc),gestoreAbbonamenti,gestorePT,calendario);
        ControllerIstruttore istruttore=new ControllerIstruttore(controllerLogin.loginIstruttore(sc),calendario,gestoreRichiestaScheda,gestorePT);


        cliente.prenotaCorso(sc);
        cliente.vediCorsiMensili(sc);

        sc.close();

    }
}