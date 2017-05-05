package Modelli.classi;

/**
 *
 * @author marta_nga0hmy
 */
public class UtentiRegistrati {

    private int personalID;
    private String nomeUtente;
    private String cognomeUtente;
    private String url;
    private String biografia;
    private String dataNascita;
    private String password;

    public UtentiRegistrati() {
        this.personalID = -1;
        this.nomeUtente = "";
        this.cognomeUtente = "";
        this.url = "";
        this.biografia = "";
        this.dataNascita = "";
        this.password = "";
    }

    /**
     * @return the personalID
     */
    public int getPersonalID() {
        return personalID;
    }

    /**
     * @param ID the id to set
     */
    public void setPersonalID(int ID) {
        this.personalID = ID;
    }

    /**
     * @return the urlFotoProfilo
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url immagine profilo
     */
    public void setUrl(String url) {
        this.url = url;
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
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    /**
     * @return dataNascita
     */
    public String getDataNascita() {
        return dataNascita;
    }

    /**
     * @param data data profilo
     */
    public void setDataNascita(String data) {
        this.dataNascita = data;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password pass profilo
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    

    /**
     * @return the nomeUtente
     */
    public String getNomeUtente() {
        return nomeUtente;
    }

    /**
     * @param nomeUtente the nomeUtente to set
     */
    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    /**
     * @return the cognomeUtente
     */
    public String getCognomeUtente() {
        return cognomeUtente;
    }

    /**
     * @param cognomeUtente the cognomeUtente to set
     */
    public void setCognomeUtente(String cognomeUtente) {
        this.cognomeUtente = cognomeUtente;
    }

    public boolean controlloprofilo(UtentiRegistrati utente) {
        if (utente.getNomeUtente().equals("") || utente.getCognomeUtente().equals("") || utente.getDataNascita().equals("")
                || utente.getUrl().equals("") || utente.getBiografia().equals("")) {
            return false;
        } else {
            return true;
        }

    }

}
