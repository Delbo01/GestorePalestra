package Controller;

import Abbonamento.*;
import Allenamento.*;
import Calendario.Calendario;
import Cliente.*;
import Database.*;
import Istruttore.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerCliente {
    private Cliente cliente;
    private Calendario calendario;
    private AbbonamentoMapper abbonamentoMapper;
    private SchedaMapper schedaMapper;
    private PersonalTrainerMapper personalTrainerMapper;
    private final GestoreAbbonamenti gestoreAbbonamenti;
    private final GestorePT gestorePT;

    private final Dao_Corso_Interface corsi = new Dao_Corso();
    private final Dao_Abbonamento_Interface dao_abbonamenti= new Dao_Abbonamento();
    private final Dao_Abbonamento_Cliente_Interface dao_abbonamento_cliente = new Dao_Abbonamento_Cliente();
    private final Dao_Cliente_Interface dao_cliente= new Dao_Cliente();
    private final Dao_Istruttore_Interface dao_istruttore= new Dao_Istruttore();
    private final Dao_PT_Cliente_Interface dao_pt_cliente= new Dao_PT_Cliente();
    private final Dao_Scheda_Cliente_Interface dao_scheda_cliente= new Dao_Scheda_Cliente();


    public ControllerCliente(Cliente cliente, GestoreAbbonamenti gestoreAbbonamenti, GestorePT gestorePT,Calendario calendario) {
        this.cliente = cliente;
        this.calendario=calendario;
        this.personalTrainerMapper = new PersonalTrainerMapper(cliente, null);
        System.out.println(cliente.getGeneralita().getCf());
        int idC=dao_cliente.getIdByCf(cliente.getGeneralita().getCf());
        this.schedaMapper = dao_scheda_cliente.getScheda_Cliente(idC);
        if(schedaMapper!= null)
            schedaMapper.getCliente().setCalendario(calendario);
        this.gestoreAbbonamenti = gestoreAbbonamenti;
        this.gestorePT = gestorePT;
        abbonamentoMapper=new AbbonamentoMapper(cliente, dao_abbonamento_cliente.getAbbonamento(dao_cliente.getIdByCf(cliente.getGeneralita().getCf())));
    }

    public void visualizzaScheda(Scanner sc) {
        if (schedaMapper.getScheda() != null)
            schedaMapper.getScheda().visualizzaScheda(sc);
        else System.out.println("Non hai una scheda");
    }

    public void vediAbbonamento(Scanner sc) {
        if (abbonamentoMapper.getAbbonamento() == null)
            System.out.println("Non hai un abbonamento");
        else abbonamentoMapper.getAbbonamento().visualizzaAbbonamento();

    }

    public void richiediScheda(Scanner sc) {
        if (abbonamentoMapper.getAbbonamento() == null)
            System.out.println("Non hai un abbonamneto attivo");
        else {
            System.out.println("Inserisci i seguenti parametri:");
            System.out.println("->obiettivo :");
            String obbiettivo = sc.nextLine();
            System.out.println("->numero programmi :");
            boolean fine = false;
            int nP = 0;
            while (!fine) {
                try {
                    nP = sc.nextInt();
                    sc.nextLine();
                    fine = true;
                } catch (InputMismatchException e) {
                    System.out.println(" per favore iniserisci un intero");
                    sc.nextLine();
                }
            }
            System.out.println("->durata programmi :");
            String durata = sc.nextLine();
            cliente.richiediScheda(obbiettivo, nP, durata, personalTrainerMapper.getPtMapper());
        }
    }


    public void ottieniAbbonamento(Scanner sc) {
        gestoreAbbonamenti.vediAbbonamenti();
        System.out.println("Quale abbonamento vuoi sottoscrivere ?");
        boolean fine = false;
        int i = 0;
        while (!fine) {
            try {
                i = sc.nextInt();
                sc.nextLine();
                fine = true;
            } catch (InputMismatchException e) {
                System.out.println("per favore inserire un intero");
                sc.nextLine();
            }
        }
        System.out.println("Vuoi poter frequentare i corsi ?");
        fine = false;
        boolean corsi = true;
        while (!fine) {
            try {
                corsi = sc.nextBoolean();
                sc.nextLine();
                fine = true;
            } catch (InputMismatchException e) {
                System.out.println("per favore inserisci un Boolean");
                sc.nextLine();
            }
        }
        int idCliente=dao_cliente.getIdByCf(cliente.getGeneralita().getCf());
        Abbonamento abbonamento=gestoreAbbonamenti.getAbbonamento(i-1,corsi);
        int idAb= dao_abbonamenti.getMaxId()+1;
        dao_abbonamenti.creaAbbonamento(idAb,abbonamento.getDurata(),abbonamento.getNome(),abbonamento.getPrezzo(),abbonamento.isCorsi(),abbonamento.getDataInizio(),abbonamento.getDataFine());
        int idAbb=dao_abbonamenti.getIdByNomeDurata(abbonamento.getDurata(),abbonamento.getNome());
        dao_abbonamento_cliente.creaAbbonamentoCliente(idCliente,idAbb);
        abbonamentoMapper=new AbbonamentoMapper(cliente,abbonamento);
    }

    public void richiediPersonalTrainer() {
        if (abbonamentoMapper.getAbbonamento() != null) {
            Istruttore pt = gestorePT.ottieniPT();
            if (pt != null) {
                int idCliente=dao_cliente.getIdByCf(cliente.getGeneralita().getCf());
                int idPt=dao_istruttore.getIdByNomeCognome(pt.getGeneralita().getNome(),pt.getGeneralita().getCognome());
                dao_pt_cliente.createPT_Cliente(idPt,idCliente);
                personalTrainerMapper.setPtMapper(pt);
                System.out.println("Il tuo personal trainer è " + pt.getGeneralita().getNome() + " " + pt.getGeneralita().getCognome());
            } else System.out.println("Non ci sono allenatori disponibili");
        }
    }

    public void richiediPersonalTrainer(Scanner sc) {
        if (abbonamentoMapper.getAbbonamento() != null) {
            System.out.println("Chi vorresti come PT ?");
            String nomePt = sc.nextLine();
            Istruttore pt = gestorePT.ottieniPT(nomePt);
            if (pt != null) {
                int idCliente=dao_cliente.getIdByCf(cliente.getGeneralita().getCf());
                int idPt=dao_istruttore.getIdByNomeCognome(pt.getGeneralita().getNome(),pt.getGeneralita().getCognome());
                dao_pt_cliente.createPT_Cliente(idPt,idCliente);
                personalTrainerMapper.setPtMapper(pt);
                System.out.println("Il tuo personal trainer è " + pt.getGeneralita().getNome() + " " + pt.getGeneralita().getCognome());
            } else System.out.println("Non ci sono allenatori disponibili");
        }
    }

    public void rimuoviPersonalTrainer() {
        if (abbonamentoMapper.getAbbonamento() != null) {
            if (personalTrainerMapper.getPtMapper() != null) {
                gestorePT.rimuoviAssistito(personalTrainerMapper.getPtMapper());
                int idCliente=dao_cliente.getIdByCf(cliente.getGeneralita().getCf());
                dao_pt_cliente.deletePT_Cliente(idCliente);
                personalTrainerMapper.setPtMapper(null);
            } else System.out.println("Non hai un personal trainer");
        }
    }

    private void vediCorsiGiornalieri(Scanner sc) {
        if (abbonamentoMapper.getAbbonamento() != null) {
            System.out.println("Inserisci il mese");
            int mese = 0;
            boolean fine = false;
            while (!fine) {
                try {
                    mese = sc.nextInt();
                    sc.nextLine();
                    fine = true;
                } catch (InputMismatchException e) {
                    System.out.println("per favore inserisci un intero");
                    sc.nextLine();
                }
            }
            fine = false;
            int giorno = 0;
            System.out.println("Inserisci il giorno");
            while (!fine) {
                try {
                    giorno = sc.nextInt();
                    sc.nextLine();
                    fine = true;
                } catch (InputMismatchException e) {
                    System.out.println("per favore inserisci un intero");
                    sc.nextLine();
                }
            }
            cliente.vediCorsiGiornalieri(mese, giorno);
        }
    }

    private void vediCorsiMensili(Scanner sc) {
        if (abbonamentoMapper.getAbbonamento() != null) {
            System.out.println("Inserisci il mese");
            int mese = 0;
            boolean fine = false;
            while (!fine) {
                try {
                    mese = sc.nextInt();
                    sc.nextLine();
                    fine = true;
                } catch (InputMismatchException e) {
                    System.out.println("per favore inserisci un intero");
                    sc.nextLine();
                }
            }
            cliente.vediCorsiMensili(mese);
        }
    }

    private void vediCalendario() {
        if (abbonamentoMapper.getAbbonamento() != null) {
            cliente.vediCalendario();
        }
    }

    private void prenotaCorso(Scanner sc) {
        if (abbonamentoMapper.getAbbonamento() != null & abbonamentoMapper.getAbbonamento().isCorsi() == true) {
            System.out.println("Inserisci il mese");
            int mese = 0;
            boolean fine = false;
            while (!fine) {
                try {
                    mese = sc.nextInt();
                    sc.nextLine();
                    fine = true;
                } catch (InputMismatchException e) {
                    System.out.println("per favore inserisci un intero");
                    sc.nextLine();
                }
            }
            fine = false;
            int giorno = 0;
            while (!fine) {
                try {
                    System.out.println("Inserisci il giorno");
                    giorno = sc.nextInt();
                    sc.nextLine();
                    fine = true;
                } catch (InputMismatchException e) {
                    System.out.println("per favore inserisci un intero");
                    sc.nextLine();
                }
            }
            System.out.println("Inserisci il nome del corso");
            String nomeCorso = sc.nextLine();
            cliente.prenotaCorso(mese, giorno, nomeCorso);
        } else
            System.out.println("Non hai un abbonamento attivo oppure non hai un abbonamneto con la possibilità di accedere ai corsi della palestra");
    }

    private void rimuoviPrenotazioneCorso(Scanner sc) {
        if (abbonamentoMapper.getAbbonamento() != null & abbonamentoMapper.getAbbonamento().isCorsi() == true) {
            System.out.println("Inserisci il mese");
            int mese = 0;
            boolean fine = false;
            while (!fine) {
                try {
                    mese = sc.nextInt();
                    sc.nextLine();
                    fine = true;
                } catch (InputMismatchException e) {
                    System.out.println("per favore inserisci un intero");
                    sc.nextLine();
                }
            }
            fine = false;
            int giorno = 0;
            while (!fine) {
                try {
                    System.out.println("Inserisci il giorno");
                    giorno = sc.nextInt();
                    sc.nextLine();
                    fine = true;
                } catch (InputMismatchException e) {
                    System.out.println("per favore inserisci un intero");
                    sc.nextLine();
                }
            }
            System.out.println("Inserisci il nome del corso");
            String nomeCorso = sc.nextLine();
            cliente.rimuoviPrenotazioneCorso(mese, giorno, nomeCorso);
        } else
            System.out.println("Non hai un abbonamneto attivo oppure non hai un abbonamneto con la possibilità di accedere ai corsi della palestra");
    }

    public void vediCorsiEPrenotaOCancella(Scanner sc) {
        System.out.println("Inserisre 1 per vedre i corsi dell'intero calendario, inserire 2 per vedere i corsi di un mese a scelta oppure inserire 3 per vedere i corsi di un giorno a scelta: ");
        int scelta = sc.nextInt();
        sc.nextLine();
        boolean rip;
        do {
            rip = false;
            if (scelta == 1) {
                vediCalendario();
            } else if (scelta == 2) {
                vediCorsiMensili(sc);
            } else if (scelta == 3) {
                vediCorsiGiornalieri(sc);
            } else {
                System.out.println("Scelta non valida");
                rip = true;
            }
        } while (rip);
        System.out.println("Vuoi prenotare un corso o vuoi cancellare la prenotazione da un corso? (1/2)");
        scelta = sc.nextInt();
        sc.nextLine();
        if (scelta == 1) {
            prenotaCorso(sc);
        } else if (scelta == 2) {
            rimuoviPrenotazioneCorso(sc);
        } else {
            System.out.println("Scelta non valida");
        }
    }
}

