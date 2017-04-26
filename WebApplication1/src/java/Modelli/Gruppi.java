/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
* and open the template in the editor./*
*/
package Modelli;
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

    protected int id;
    protected String nameGroup;
    protected List<UtentiRegistrati> listaUtenti = new ArrayList<>();
    protected TypeGroup tipoG;
    
    public Gruppi() {
        id = 0;
        nameGroup = " ";
        
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
    public String getNomeG() {
        return nameGroup;
        }
    
    /**
     * @param nameGroup nome del gruppo
     */
    public void setNomeG(String nameGroup){
        this.nameGroup=nameGroup;
    }
    
    public TypeGroup getType() {
        return tipoG;
    }
    
    public void setType(TypeGroup tipoG){
        this.tipoG=tipoG;
    }
    

    
    public void stampaListaUt (){
        this.listaUtenti.forEach((i) -> {
            System.out.println(i.nomeUtente);
        });
    }
    
    /**
     *
     * @param utenti
     */
    public void aggiungi(UtentiRegistrati utenti){

        this.listaUtenti.add(utenti);

    }
    
    public void aggiungi(List<UtentiRegistrati> lista){
        lista.forEach((i) -> {
            this.listaUtenti.add(i);
        });
    }
    
    
}
