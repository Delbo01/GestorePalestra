import Cliente.Cliente;
import GestoreLogin.GestoreLogin;
import GestoreLogin.ListaCredenzialiIstruttore;
import GestoreLogin.ListaCredenzialiCliente;
import Cliente.Generalita;
import Allenamento.ProgrammaAllenamento;
import Allenamento.Esercizio;
import Allenamento.Scheda;
import IstruttoreCalendario.Calendario;
import IstruttoreCalendario.Corso;
import IstruttoreCalendario.GestorePT;
import IstruttoreCalendario.Istruttore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Calendario ca = new Calendario(2022);
        GestorePT personalTrainers = new GestorePT(1);
        ListaCredenzialiCliente listaCredenziali = new ListaCredenzialiCliente();
        ListaCredenzialiIstruttore listaCredenzialiIstruttore = new ListaCredenzialiIstruttore();

        GestoreLogin gestoreLogin = new GestoreLogin(listaCredenziali, listaCredenzialiIstruttore);

        Generalita g = new Generalita("dlblrd01p27g999r", "Leonardo", "Del Bene");
        Cliente cliente = new Cliente(g, 186, 87, personalTrainers);
        gestoreLogin.registraCliente("Leonardo", "Abcjh4_20", cliente);

        Generalita gi = new Generalita("nrdcrt00p02d612f", "Cristiano", "Narducci");
        Istruttore istruttore = new Istruttore(gi, ca, personalTrainers);
        gestoreLogin.registraIstruttore("narducci", "qwerty", istruttore);

        Cliente c = gestoreLogin.loginCliente("Leonardo", "Abcjh4_20");
        Istruttore i = gestoreLogin.loginIstruttore("narducci", "qwerty");


        Esercizio e1 = new Esercizio("panca piana", 4, 10, 90, null);
        Esercizio e2 = new Esercizio("distensioni con manubri su panca inclinata", 4, 8, 90, "panca inclinata a 45 gradi");
        Esercizio e3 = new Esercizio("croci ai cavi", 3, 12, 60, null);
        Esercizio e4 = new Esercizio("french press", 4, 8, 90, "da eseguire con una fase eccentrica controllata e una concentrica esplosiva");

        ProgrammaAllenamento programmaAllenamento1 = new ProgrammaAllenamento("1 ora");
        programmaAllenamento1.addEsercizio(e1);
        programmaAllenamento1.addEsercizio(e2);
        programmaAllenamento1.addEsercizio(e3);
        programmaAllenamento1.addEsercizio(e4);

        Esercizio ee1 = new Esercizio("squat", 5, 8, 120, null);
        Esercizio ee2 = new Esercizio("leg exstension", 4, 12, 60, "prime sei reps da eseguire con fermo in isometria di 2 secondi");
        Esercizio ee3 = new Esercizio("leg curl", 4, 10, 60, null);
        Esercizio ee4 = new Esercizio("affondi bulgari", 3, 12, 2, null);

        ProgrammaAllenamento programmaAllenamento2 = new ProgrammaAllenamento("1 ora");
        programmaAllenamento2.addEsercizio(e1);
        programmaAllenamento2.addEsercizio(ee1);
        programmaAllenamento2.addEsercizio(ee2);
        programmaAllenamento2.addEsercizio(ee3);
        programmaAllenamento2.addEsercizio(ee4);
        programmaAllenamento2.removeEsercizio(e1);

        Scheda scheda = new Scheda("io", "ipertrofia");
        scheda.addProgramma(programmaAllenamento1);
        scheda.addProgramma(programmaAllenamento2);

        //scheda.visualizzaScheda();
        //scheda.setCarico(0,1,40);
        //scheda.visualizzaProgramma(0);
        //scheda.startTimer(0,1);


        cliente.setScheda(scheda);
        cliente.creaAbbonamento(3, "trimestrale", 180, "1/1/2023", "1/4/2023", true);
        cliente.visualizzaScheda();
        cliente.vediAbbonamento();


        Generalita is = new Generalita("djefjndsfjk", "luigi", "rossi");
        Istruttore lio = new Istruttore(is, ca, personalTrainers);
        Corso co = new Corso("Cardio", 10, "22:00", "05:00", lio.getGeneralita().getNome());
        lio.inserisciCorso(1, 22, co);
        ca.vediCorsiMensili(1);
        lio.diventaPT();
        cliente.richiediPersonalTrainer();

        cliente.richiediPersonalTrainer(); //NON ANDRà A BUON FINE


    }

}