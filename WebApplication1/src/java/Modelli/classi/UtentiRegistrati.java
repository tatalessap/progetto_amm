package Modelli.classi;

/**
 *
 * @author marta_nga0hmy
 */
public class UtentiRegistrati {

    private int personalID;
    String nomeUtente;
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
    public int getpersonalID() {
        return personalID;
    }

    /**
     * @param ID the id to set
     */
    public void setID(int ID) {
        this.personalID = ID;
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
    public void setNome(String nomeUtente) {
        this.nomeUtente = nomeUtente;
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
    public void setCognome(String cognomeUtente) {
        this.cognomeUtente = cognomeUtente;
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
    public String getPassw() {
        return password;
    }

    /**
     * @param password pass profilo
     */
    public void setPassw(String password) {
        this.password = password;
    }

    public boolean controlloprofilo(UtentiRegistrati utente) {
        if (utente.getNome().equals("") || utente.getCognome().equals("") || utente.getDataNascita().equals("")
                || utente.getUrl().equals("") || utente.getBiografia().equals("")) {
            return false;
        } else {
            return true;
        }

    }

}
