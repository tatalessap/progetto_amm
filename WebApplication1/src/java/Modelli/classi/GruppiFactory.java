package Modelli.classi;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marta_nga0hmy
 */
public class GruppiFactory {
//    "fabbrica dei gruppo": classe di gestione e di implementazione della lista dei gruppi creati e dei metodi utili 

    private static GruppiFactory singleton;

    public static GruppiFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppiFactory();
        }
        return singleton;
    }

    private ArrayList<Gruppi> listaGruppi = new ArrayList<Gruppi>();

    private GruppiFactory() {
        //creazione gruppi

        //creazione Gruppo1
        Gruppi gruppo1 = new Gruppi();
        gruppo1.setId(1);
        gruppo1.setNomeG("Chi stava guardando la melevisione l'undici settembre");
        gruppo1.setType(Gruppi.TypeGroup.PUBBLICO);

        //creazione Gruppo2
        Gruppi gruppo2 = new Gruppi();
        gruppo2.setId(2);
        gruppo2.setNomeG("X chi vuole partire a Milano per Natale");
        gruppo2.setType(Gruppi.TypeGroup.PUBBLICO);

        //creazione Gruppo3
        Gruppi gruppo3 = new Gruppi();
        gruppo3.setId(3);
        gruppo3.setNomeG("SettePugnalate: il locale");
        gruppo3.setType(Gruppi.TypeGroup.PUBBLICO);

        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
        listaGruppi.add(gruppo3);
    }

    public Gruppi getGruppiById(int id) {
        for (Gruppi gruppo : this.listaGruppi) {
            if (gruppo.getId() == id) {
                return gruppo;
            }
        }
        return null;
    }

    public Gruppi getGruppiByNome(String nome) {
        for (Gruppi gruppo : this.listaGruppi) {
            if (gruppo.getNomeG() == nome) {
                return gruppo;
            }
        }
        return null;
    }

    public ArrayList<Gruppi> getGruppi() {
        return listaGruppi;
    }

}
