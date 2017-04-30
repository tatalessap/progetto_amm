/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelli;

import static com.oracle.webservices.api.databinding.DatabindingModeFeature.ID;
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
        utente0.setID(0);
        utente0.setNome("Incompleto");
        utente0.setPassw("q");

        //creazione Mark Zuckerberg
        UtentiRegistrati utente1 = new UtentiRegistrati();
        utente1.setID(1);
        utente1.setNome("Mark");
        utente1.setCognome("Zuckerberg");
        utente1.setBiografia("fondatore");
        utente1.setDataNascita("00/00/00");
        utente1.setUrl("img/Mark.jpg");
        utente1.setPassw("q");

        //creazione Hack Rino
        UtentiRegistrati utente2 = new UtentiRegistrati();
        utente2.setID(2);
        utente2.setNome("Hack");
        utente2.setCognome("Rino");
        utente2.setBiografia("Hacker di fama mondiale");
        utente2.setDataNascita("00/00/00");
        utente2.setUrl("img/picHacherino.jpg");
        utente2.setPassw("q");

        //creazione Jon Sudano
        UtentiRegistrati utente3 = new UtentiRegistrati();
        utente3.setID(3);
        utente3.setNome("Jon");
        utente3.setCognome("Sudano");
        utente3.setBiografia("cantante");
        utente3.setDataNascita("00/00/00");
        utente3.setUrl("img/jonsudano.jpg");
        utente3.setPassw("q");

        listaUtenti.add(utente0);
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);

    }

    public UtentiRegistrati getUtentiRegistratiById(int id) {
        for (UtentiRegistrati utente : this.listaUtenti) {
            if (utente.getpersonalID() == id) {
                return utente;
            }
        }
        return null;
    }

    public UtentiRegistrati getUtentiRegistratiByNome(String nome) {
        for (UtentiRegistrati utente : this.listaUtenti) {
            if (utente.getNome() == nome) {
                return utente;
            }
        }
        return null;
    }

    public UtentiRegistrati getUtentiRegistratiByCognome(String cognome) {
        for (UtentiRegistrati utente : this.listaUtenti) {
            if (utente.getCognome() == cognome) {
                return utente;
            }
        }
        return null;
    }

    public int getIdByUserAndPassword(String user, String password) {
        for (UtentiRegistrati utente : this.listaUtenti) {
            if (utente.getNome().equals(user) && utente.getPassw().equals(password)) {
                return utente.getpersonalID();
            }
        }
        return -1;
    }

    public boolean controlloprofilo(int loggedUserID) {

        for (UtentiRegistrati utente : this.listaUtenti) {
            if (utente.getpersonalID() == loggedUserID) {
                if (utente.controlloprofilo(utente) == true) {
                    return true;
                }

            }

        }

        return false;

    }
}