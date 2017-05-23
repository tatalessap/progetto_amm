package Modelli.classi;

/**
 *
 * @author marta_nga0hmy
 */
public class Post {

    public enum PostType {
        POST_TESTO, POST_IMMAGINE,
    };

    protected int id;
    protected UtentiRegistrati utente;
    private String content;
    private PostType postType;
    private int idUtenteBacheca;
    private String allegato;

    public Post() {
        id = 0;
        utente = null;
        content = "";
        postType = PostType.POST_TESTO;
        allegato = "";

    }

    public int getIdUtenteBacheca() {
        return idUtenteBacheca;
    }

    public void setIdUtenteBacheca(int idUtenteBacheca) {
        this.idUtenteBacheca = idUtenteBacheca;
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
    
    
    public String getAllegato() {
        return allegato;
    }

    public void setAllegato(String allegato) {
        this.allegato = allegato;
    }



    /**
     * @return utente
     */
    public UtentiRegistrati getUtente() {
        return utente;
    }

    /**
     * @param utente utente che scrive il post
     */
    public void setUtente(UtentiRegistrati utente) {
        this.utente = utente;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the postType
     */
    public PostType getPostType() {
        return postType;
    }

    /**
     * @param postType the postType to set
     */
    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public int getIdUtenteCreatore() {
        return this.utente.getPersonalID();
    }

}
