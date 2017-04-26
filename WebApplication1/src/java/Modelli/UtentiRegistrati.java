/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelli;

/**
 *
 * @author marta_nga0hmy
 */

public class UtentiRegistrati {
    private int personalID;
    String nomeUtente;
    private String cognomeUtente;
    private String urlFotoProfilo;
    private String biografia;
    private String dataNascita; 
    private String password;
    
    public UtentiRegistrati (){
        this.personalID=0;
        this.nomeUtente=" ";
        this.cognomeUtente=" ";
        this.urlFotoProfilo=" ";
        this.biografia=" ";
        this.dataNascita=" ";
        this.password=" ";
       }
    
    /**
     * @return the personalID
     */
    public int getpersonalID (){
        return personalID;
        }
    
    /**
     * @param ID the id to set
     */
    public void setID (int ID) {
        this.personalID=ID;
    }
    
    
    /**
     * @return the nomeUtente
     */
    public String getNome() {
        return nomeUtente;
        }
    
    /**
     * @param nomeUtente the nome to set
     */
    public void setNome(String nomeUtente){
        this.nomeUtente=nomeUtente;
    }
    
    
    /**
     * @return the cognomeUtente
     */
    public String getCognome() {
        return cognomeUtente;
        }
    
    /**
     * @param cognomeUtente cognome
     */
    public void setCognome (String cognomeUtente) {
        this.cognomeUtente=cognomeUtente;
    }
   
    
    /**
     * @return the urlFotoProfilo
     */
    public String getUrl() {
        return urlFotoProfilo;
        }
    
    /**
     * @param urlFotoProfilo immagine profilo
     */
    public void setUrl(String urlFotoProfilo) {
        this.urlFotoProfilo=urlFotoProfilo;
    }
    
    
    /**
     * @return the biografia
     */
    public String getBiografia() {
        return biografia;
        }
    
    /**
     * @param biografia biografia profilo
     */
    public void setBiografia (String biografia) {
        this.biografia=biografia;
    }
    
    
    /**
     * @return dataNascita
     */
    public String getDataNascita () {
        return dataNascita;
    }
    
    /**
     * @param data data profilo
     */
    public void setDataNascita (String data) {
        this.dataNascita=data;
    }
    
    
    /**
     * @return password
     */
    public String getPassw () {
        return password;
    }
    
    /**
     * @param password pass profilo
     */
    public void setPassw (String password){
        this.password=password;
    }

    
    
}
