package Modelli.classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marta_nga0hmy
 */
public class UtentiRegistratiFactory {

    //Pattern Design Singleton
    private static UtentiRegistratiFactory singleton;

    public static UtentiRegistratiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiRegistratiFactory();
        }
        return singleton;
    }
    
    private String connectionString;

    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

    private ArrayList<UtentiRegistrati> listaUtenti = new ArrayList<UtentiRegistrati>();

    private UtentiRegistratiFactory() {
    }

    ;
    
    public UtentiRegistrati getUtentiRegistratiById(int id) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "tata", "tata"); //username e password del database

            String query
                    = "select * from utentiRegistrati " //lasciare uno spazio tra la fine dell'ultima per la concatenazione
                    + "where personalID = ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                UtentiRegistrati current = new UtentiRegistrati();

                current.setPersonalID(res.getInt("personalID"));
                current.setNomeUtente(res.getString("nomeUtente"));
                current.setCognomeUtente(res.getString("cognomeUtente"));
                current.setUrl(res.getString("url"));
                current.setBiografia(res.getString("biografia"));
                current.setDataNascita(res.getString("dataNascita"));
                current.setPassword(res.getString("password"));

                stmt.close();
                conn.close();

                return current;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int getIdByUserAndPassword(String user, String password) {

        try {
            Connection conn = DriverManager.getConnection(connectionString, "tata", "tata"); //username e password del database

            String query
                    = "select * from utentiRegistrati " //lasciare uno spazio tra la fine dell'ultima per la concatenazione
                    + "where nomeUtente = ? and password = ? ";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, user);
            stmt.setString(2, password);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                int id = res.getInt("personalID");

                stmt.close();
                conn.close();
                return id;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    
    public boolean controlloprofilo(int loggerUserID) {
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "tata", "tata"); //username e password del database

            String query
                    = "select * from utentiRegistrati " //lasciare uno spazio tra la fine dell'ultima per la concatenazione
                    + "where personalID= ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, loggerUserID);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                if(loggerUserID==res.getInt("personalID"));

                stmt.close();
                conn.close();
                return true;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }

    public ArrayList<UtentiRegistrati> getUtenti() {
                
       ArrayList<UtentiRegistrati> listaUtenti = new ArrayList<>();
            try {
            Connection conn = DriverManager.getConnection(connectionString, "tata", "tata"); //username e password del database

           String query
                    = " select * from utentiRegistrati " ; //lasciare uno spazio tra la fine dell'ultima per la concatenazione

            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                
                UtentiRegistrati current = new UtentiRegistrati();
                
                current.setPersonalID(res.getInt("personalID"));
                current.setNomeUtente(res.getString("nomeUtente"));
                current.setCognomeUtente(res.getString("cognomeUtente"));
                current.setUrl(res.getString("url"));
                current.setBiografia(res.getString("biografia"));
                current.setDataNascita(res.getString("dataNascita"));
                current.setPassword(res.getString("password"));
                
                listaUtenti.add(current);
                
            }
            
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
            
        return listaUtenti;
    }
    
    public void deleteUtente (UtentiRegistrati utente) {
        
        String query;
        PreparedStatement stmt;
        Connection conn;
        

            try {
                
            conn = DriverManager.getConnection(connectionString, "tata", "tata");
                     
            query = " delete from utentiRegistrati " + " where personalID = ? ";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, utente.getPersonalID());
            stmt.executeUpdate();
            


            stmt.close();
            conn.close();

            } catch (SQLException e) {
                e.printStackTrace();

            }
    }
    
    public ArrayList<UtentiRegistrati> listaLatoSx(String nome) {
        
        ArrayList<UtentiRegistrati> listaUtenti = new ArrayList<UtentiRegistrati>();
        
        try {

            Connection conn = DriverManager.getConnection(connectionString, "tata", "tata");
            String query = "select * from utentiRegistrati where nomeUtente like ? ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + nome + "%");
            ResultSet res = stmt.executeQuery();
            
            while (res.next()) {

                UtentiRegistrati current = new UtentiRegistrati();
                current.setPersonalID(res.getInt("personalID"));
                current.setNomeUtente(res.getString("nomeUtente"));
                current.setCognomeUtente(res.getString("cognomeUtente"));
                current.setPassword(res.getString("password"));
                current.setDataNascita(res.getString("dataNascita"));
                current.setBiografia(res.getString("biografia"));
                current.setUrl(res.getString("url"));

                listaUtenti.add(0, current);

            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaUtenti;
    
    }



}
