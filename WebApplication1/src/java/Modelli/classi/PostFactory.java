package Modelli.classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    private PostFactory() {
    }
    ;

    private ArrayList<Post> listaPost = new ArrayList<Post>();

    public Post getPostById(int id) {

        UtentiRegistratiFactory utentiFactory = UtentiRegistratiFactory.getInstance();

        try {
            Connection conn = DriverManager.getConnection(connectionString, "tata", "tata"); //username e password del database

            String query
                    = " select * from Posts " //lasciare uno spazio tra la fine dell'ultima per la concatenazione
                    + " join postType on Posts.postType = postType.id_postType "
                    + " where id_post = ? ";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("id_post"));
                //imposto id dell'utente su cui è pubblicata la bacheca
                current.setIdUtenteBacheca(res.getInt("idUtenteBacheca"));
                //impost il contenuto del post
                current.setContent(res.getString("content"));
                //imposto l'allegato
                current.setAllegato(res.getString("allegato"));
                //imposto il tipo del post
                current.setPostType(this.postTypeFromString(res.getString("postType")));
                //imposto l'autore del post
                UtentiRegistrati autore = utentiFactory.getUtentiRegistratiById(res.getInt("utente"));
                current.setUtente(autore);

                stmt.close();
                conn.close();
                return current;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List getPostList(UtentiRegistrati utente) {

        try {

            Connection conn = DriverManager.getConnection(connectionString, "tata", "tata"); //username e password del database

            String query
                    = "select * from Posts "
                    + " join postType on Posts.postType = postType.id_postType "
                    + "where utente = ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, utente.getPersonalID());

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Post current = new Post();

                current.setId(res.getInt("id_post"));

                current.setContent(res.getString("content"));

                current.setAllegato(res.getString("allegato"));

                current.setPostType(this.postTypeFromString(res.getString("postType")));

                current.setUtente(utente);

                listaPost.add(current);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;
    }

    public List getPostListByIdUtente(int id) {
        List<Post> listaPost = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(connectionString, "tata", "tata"); //username e password del database

            String query
                    = "select * from Posts "
                    + "join postType on Posts.postType = postType.id_postType "
                    + "where utente = ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Post current = new Post();

                current.setId(res.getInt("id_post"));

                current.setContent(res.getString("content"));

                current.setAllegato(res.getString("allegato"));

                current.setPostType(this.postTypeFromString(res.getString("postType")));

                current.setUtente(UtentiRegistratiFactory.getInstance().getUtentiRegistratiById(res.getInt("utente")));

                listaPost.add(current);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;

    }

    private String connectionString;

    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

    private Post.PostType getPostType(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Post.PostType postTypeFromString(String type) {

        if (type.equals("POST_IMMAGINE")) {
            return Post.PostType.POST_IMMAGINE;
        }

        return Post.PostType.POST_TESTO;
    }

    private int postTypeFromEnum(Post.PostType type) {
        //È realizzabile in modo più robusto rispetto all'hardcoding degli indici
        if (type == Post.PostType.POST_TESTO) {
            return 1;
        } else {
            return 2;
        }
    }
    
        public void addNewPost(Post post){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "tata", "tata");
            
            String query = 
                      "insert into posts (id_post, content, postType , utente, idUtenteBacheca) "
                    + "values (default, ? , ? , ?, ?)";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, post.getContent());

            stmt.setInt(2, this.postTypeFromEnum(post.getPostType()));
            
            stmt.setInt(3, post.getUtente().getPersonalID());
            
            stmt.setInt(4, post.getUtente().getPersonalID());
            
            // Esecuzione query
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
        
        public void deletePostsBacheca(int id) {
            List<Post> listaPost = PostFactory.getInstance().getPostListByIdUtente(id);
            String query;

        for (Post post : listaPost) {

            try {

                Connection conn = DriverManager.getConnection(connectionString, "tata", "tata");
                query
                        = "delete from posts "
                        + "where id_post = ? ";

                PreparedStatement stmt = conn.prepareStatement(query);

     
                stmt.setInt(1, post.getId());


                stmt.executeUpdate();
                stmt.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
            
     }

}
