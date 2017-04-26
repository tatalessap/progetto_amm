/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelli;

import Modelli.Post.Type;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author marta_nga0hmy
 */
public class PostFactory {
    
    private static PostFactory singlepost;
    
    public static PostFactory getInstance() {
        if (singlepost == null) {
            singlepost = new PostFactory();
        }
        return singlepost;
    }
    
    private ArrayList<Post> listaPost = new ArrayList<Post>();
    
    private PostFactory() {
        
        UtentiRegistratiFactory utentiFactory = UtentiRegistratiFactory.getInstance();
        
        //Creazione Post 1
        Post post1 = new Post();
        post1.setContent("Fiamma! Oggi prima lezione diPR1. Solo bomba! Mi piace troppo! Int i, int i=0, printf('Già sesi acconciu);");
        post1.setId(1);
        post1.setUtente(utentiFactory.getUtentiRegistratiById(0));
        post1.setPostType(Post.Type.POST_TESTO);
        
        //Creazione Post 2
        Post post2 = new Post();
        post2.setContent("img/imhacherino.jpg Ci stanno tracciando, staccaaaaaaaa");
        post2.setId(2);
        post2.setUtente(utentiFactory.getUtentiRegistratiById(1));
        post2.setPostType(Post.Type.POST_IMMAGINE);
        
        //Creazione Post 3
        Post post3 = new Post();
        post3.setContent("Follow me and see a https://www.youtube.com/watch?v=gTwxtYin1p0 on Youtube");
        post3.setId(3);
        post3.setUtente(utentiFactory.getUtentiRegistratiById(2));
        post3.setPostType(Post.Type.POST_TESTO);
        
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        
    
    }
    
        public Post getPostById(int id) {
            for (Post post : this.listaPost) {
                if (post.getId() == id) {
                 return post;
                }
            }
            return null;
        }
        
        public List getPostList(UtentiRegistratiFactory utente) {

        for (Post post : this.listaPost) {
            if (post.getUtente().equals(utente)) {
                listaPost.add(post);
            }
        }
         return listaPost;
        }
        
        public List getPostbyTyoe(Type tipo) {

        for (Post post : this.listaPost) {
            if (post.getPostType().equals(tipo)) {
                listaPost.add(post);
            }
        }
         return listaPost;
        }
          
    
}
