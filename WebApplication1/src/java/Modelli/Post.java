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
public class Post {
    
    public enum Type {
        POST_TESTO, POST_IMMAGINE,
    };
    
    protected int id;
    protected UtentiRegistrati utente;
    private String content;
    private Type postType;
    private String image; 
    
    public Post() {
        id = 0;
        utente = null;
        content = "";
        postType = Type.POST_TESTO;
        image = "";
        
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
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
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
    public Type getPostType() {
        return postType;
    }

    /**
     * @param postType the postType to set
     */
    public void setPostType(Type postType) {
        this.postType = postType;
    }
    
    
}
