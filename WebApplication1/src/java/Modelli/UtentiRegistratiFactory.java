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
    
    private UtentiRegistratiFactory () {
    
        //creazione utenti
        
        //creazione Mark Zuckerberg
        UtentiRegistrati utente1 = new UtentiRegistrati();
        utente1.setID(0);
        utente1.setNome("Mark");
        utente1.setCognome("Zuckerberg");
        utente1.setBiografia("fondatore di Facebook");
        utente1.setDataNascita("00/00/00");
        utente1.setUrl("img/Mark");
        utente1.setPassw("password");
        
        //creazione Hack Rino
        UtentiRegistrati utente2 = new UtentiRegistrati();
        utente2.setID(0);
        utente2.setNome("Hack");
        utente2.setCognome("Rino");
        utente2.setBiografia("Hacker di fama mondiale");
        utente2.setDataNascita("00/00/00");
        utente2.setUrl("img/picHacherino");
        utente2.setPassw("stacchah");
        
        //creazione Jon Sudano
        UtentiRegistrati utente3 = new UtentiRegistrati();
        utente3.setID(0);
        utente3.setNome("Jon");
        utente3.setCognome("Sudano");
        utente3.setBiografia("cantante");
        utente3.setDataNascita("00/00/00");
        utente3.setUrl("img/jonsudano");
        utente3.setPassw("AllStarsomebaaadyy");
        
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

    
}
