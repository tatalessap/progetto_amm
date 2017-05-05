package Modelli.classi;

import java.util.ArrayList;

/**
 *
 * @author marta_nga0hmy
 */
public class UtentiRegistratiFactory {

    //Pattern Design Singleton
    private static UtentiRegistratiFactory singleton;

    public static UtentiRegistratiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiRegistratiFactory();
        }
        return singleton;
    }

    private ArrayList<UtentiRegistrati> listaUtenti = new ArrayList<UtentiRegistrati>();

    private UtentiRegistratiFactory() {

        //creazione utenti
        //creazione utente incompleto
        UtentiRegistrati utente0 = new UtentiRegistrati();
        utente0.setPersonalID(0);
        utente0.setNomeUtente("Incompleto");
        utente0.setPassword("q");

        //creazione Mark Zuckerberg
        UtentiRegistrati utente1 = new UtentiRegistrati();
        utente1.setPersonalID(1);
        utente1.setNomeUtente("Mark");
        utente1.setCognomeUtente("Zuckerberg");
        utente1.setBiografia("fondatore");
        utente1.setDataNascita("00/00/00");
        utente1.setUrl("img/Mark.jpg");
        utente1.setPassword("q");

        //creazione Hack Rino
        UtentiRegistrati utente2 = new UtentiRegistrati();
        utente2.setPersonalID(2);
        utente2.setNomeUtente("Hack");
        utente2.setCognomeUtente("Rino");
        utente2.setBiografia("Hacker di fama mondiale");
        utente2.setDataNascita("00/00/00");
        utente2.setUrl("img/picHacherino.jpg");
        utente2.setPassword("q");

        //creazione Jon Sudano
        UtentiRegistrati utente3 = new UtentiRegistrati();
        utente3.setPersonalID(3);
        utente3.setNomeUtente("Jon");
        utente3.setCognomeUtente("Sudano");
        utente3.setBiografia("cantante");
        utente3.setDataNascita("00/00/00");
        utente3.setUrl("img/jonsudano.jpg");
        utente3.setPassword("q");

        listaUtenti.add(utente0);
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);

    }

    public UtentiRegistrati getUtentiRegistratiById(int id) {
        for (UtentiRegistrati utente : this.listaUtenti) {
            if (utente.getPersonalID() == id) {
                return utente;
            }
        }
        return null;
    }

    public UtentiRegistrati getUtentiRegistratiByNome(String nome) {
        for (UtentiRegistrati utente : this.listaUtenti) {
            if (utente.getNomeUtente() == nome) {
                return utente;
            }
        }
        return null;
    }

    public UtentiRegistrati getUtentiRegistratiByCognome(String cognome) {
        for (UtentiRegistrati utente : this.listaUtenti) {
            if (utente.getCognomeUtente() == cognome) {
                return utente;
            }
        }
        return null;
    }

    public int getIdByUserAndPassword(String user, String password) {
        for (UtentiRegistrati utente : this.listaUtenti) {
            if (utente.getNomeUtente().equals(user) && utente.getPassword().equals(password)) {
                return utente.getPersonalID();
            }
        }
        return -1;
    }

    public boolean controlloprofilo(int loggedUserID) {

        for (UtentiRegistrati utente : this.listaUtenti) {
            if (utente.getPersonalID() == loggedUserID) {
                if (utente.controlloprofilo(utente) == true) {
                    return true;
                }

            }

        }

        return false;

    }

    public ArrayList<UtentiRegistrati> getUtenti(UtentiRegistrati utenteloggato) {
        ArrayList<UtentiRegistrati> nuovalista = new ArrayList<UtentiRegistrati>();
        for (UtentiRegistrati utente : this.listaUtenti) {
            if (!(utente.equals(utenteloggato))) {
                nuovalista.add(utente);
            }
        }
        return nuovalista;
    }

    public ArrayList<UtentiRegistrati> getUtenti() {

        return this.listaUtenti;
    }

}
