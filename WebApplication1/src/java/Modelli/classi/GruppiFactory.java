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
public class GruppiFactory {
//    "fabbrica dei gruppo": classe di gestione e di implementazione della lista dei gruppi creati e dei metodi utili 

    private static GruppiFactory singleton;

    public static GruppiFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppiFactory();
        }
        return singleton;
    }

   // private ArrayList<Gruppi> listaGruppi = new ArrayList<Gruppi>();
    
    private String connectionString;
    
    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

    private GruppiFactory() {
    }

    public Gruppi getGruppiById(int id) {
        //ripescaggio Gruppi
        try {
            Connection conn = DriverManager.getConnection(connectionString, "tata", "tata"); //username e password del database

            String query
                    = " select * from gruppi " //lasciare uno spazio tra la fine dell'ultima per la concatenazione
                    + " where id_gruppi = ? ";
            String query2
                    = "select * from listaUtentiGroup" +
                    "join id_listaUtenti on listaUtentiGroup.id_listaUtenti=id_gruppi "
                    + " where id_listaUtenti = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            PreparedStatement stmt2 = conn.prepareStatement(query2);

            stmt.setInt(1, id);
            stmt2.setInt(2, id);
           
            ResultSet res = stmt.executeQuery();
            ResultSet res2 = stmt2.executeQuery();

            if (res.next()) {
                Gruppi current = new Gruppi();
                
                current.setId(res.getInt("id_gruppi"));
                current.setIdUtenteProprietario(res.getInt("idUtenteProprietario"));
                current.setNameGroup(res.getString("nomeGroup"));
                
                current.setId(res2.getInt("id_listaUtenti"));
                
                
                stmt.close();
                conn.close();
                stmt2.close();
                conn.close();
                return current;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    
    public Gruppi getGruppiByNome(String nome) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "tata", "tata"); //username e password del database

            String query
                    = " select * from gruppi " //lasciare uno spazio tra la fine dell'ultima per la concatenazione
                    + " where nomeGroup = ? ";
            String query2
                    = "select * from listaUtentiGroup " +
                    "join id_listaUtenti on listaUtentiGroup.id_listaUtenti=id_gruppi " 
                    + " where id_listaUtenti = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            PreparedStatement stmt2 = conn.prepareStatement(query2);

            stmt.setString(1, nome);
            stmt2.setString(2, nome);
           
            ResultSet res = stmt.executeQuery();
            ResultSet res2 = stmt2.executeQuery();

            if (res.next()) {
                Gruppi current = new Gruppi();
                
                current.setId(res.getInt("id_gruppi"));
                current.setIdUtenteProprietario(res.getInt("idUtenteProprietario"));
                current.setNameGroup(res.getString("nomeGroup"));
                
                current.setId(res2.getInt("id_listaUtenti"));
                
                
                stmt.close();
                conn.close();
                stmt2.close();
                conn.close();
                
                return current;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
        
    }

    public ArrayList<Gruppi> getGruppi() {
        
       ArrayList<Gruppi> listaGruppi = new ArrayList<>();
            try {
            Connection conn = DriverManager.getConnection(connectionString, "tata", "tata"); //username e password del database

           String query
                    = " select * from gruppi " ; //lasciare uno spazio tra la fine dell'ultima per la concatenazione

            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                
                Gruppi current = new Gruppi();
                
                current.setId(res.getInt("id_gruppi"));
                current.setIdUtenteProprietario(res.getInt("idUtenteProprietario"));
                current.setNameGroup(res.getString("nomeGroup"));

                listaGruppi.add(current);
                
            }
            
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
            
            return listaGruppi;


    }
    
    
    
}
