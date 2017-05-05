package Modelli.classi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marta_nga0hmy
 */
public class Gruppi {


    public enum TypeGroup {
        SEGRETO, PUBBLICO;
    };

    private int id;
    private String nameGroup;
    private List<UtentiRegistrati> listaUtenti = new ArrayList<>();
    private TypeGroup tipoG;

    public Gruppi() {
        id = 0;
        nameGroup ="";
        tipoG = TypeGroup.PUBBLICO;
    }
    
        /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nameGroup
     */
    public String getNameGroup() {
        return nameGroup;
    }

    /**
     * @param nameGroup the nameGroup to set
     */
    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    /**
     * @return the listaUtenti
     */
    public List<UtentiRegistrati> getListaUtenti() {
        return listaUtenti;
    }

    /**
     * @param listaUtenti the listaUtenti to set
     */
    public void setListaUtenti(List<UtentiRegistrati> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }

    /**
     * @return the tipoG
     */
    public TypeGroup getTipoG() {
        return tipoG;
    }

    /**
     * @param tipoG the tipoG to set
     */
    public void setTipoG(TypeGroup tipoG) {
        this.tipoG = tipoG;
    }

    

    public void stampaListaUt() {
        this.getListaUtenti().forEach((i) -> {
            System.out.println(i.getNomeUtente());
        });
    }

    /**
     *
     * @param utenti
     */
    public void aggiungi(UtentiRegistrati utenti) {

        this.getListaUtenti().add(utenti);

    }

    public void aggiungi(List<UtentiRegistrati> lista) {
        lista.forEach((i) -> {
            this.getListaUtenti().add(i);
        });
    }

}
