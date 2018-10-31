
package dbcalciatori;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainDbCalciatori 

{
    public static void main(String[] args)
    {
        System.out.println("Connecting database...");
        
        Connection con = null;
        
        String url = "jdbc:mysql://localhost:3306/test?"
                    +"zeroDateTimeBehavior = convertToNull"
                    +"&serverTimezone = UTC"; 
        try 
        {
            //se uso questo non occore linkare la libreria, secondo me si,
            //userà il primo driver conforme alle specifiche
            //e lo usa per stabilire una connessione!!!
            con = DriverManager.getConnection( url, "root", "root");
            System.out.println("Database connected!");
        } 
        catch (SQLException ex)
        {
            System.out.println("SQLException: "               + ex.getMessage());
            System.out.println("SQLState: "                   + ex.getSQLState());
            System.out.println("VendorError: "                + ex.getErrorCode());
            System.out.println("Cannot connect the database!" + ex);
        }

         // inserisciCalciatore(con,"Antonio2","Inter");    
         visualizzaCalciatori(con);  
         if(inserisciCalciatore(con,"Antonio2","Inter"))
         {
          visualizzaCalciatori(con); 
          cancellaCalciatore(con,"Antonio2");
         }
         
         visualizzaCalciatori(con);    
         
         ArrayList<Calciatore> listaDiCalciatori = new ArrayList<Calciatore>();
         CalciatoriFinestra finestra = new CalciatoriFinestra();
         
         //ADD SAME DATA MORE TIMES
         selezionaCalciatori(con,listaDiCalciatori);
         selezionaCalciatori(con,listaDiCalciatori);
         selezionaCalciatori(con,listaDiCalciatori);  
         selezionaCalciatori(con,listaDiCalciatori);
         selezionaCalciatori(con,listaDiCalciatori);  
         selezionaCalciatori(con,listaDiCalciatori);       
         
         finestra.visualizzaCalciatori(listaDiCalciatori);

        
    }
    
    static boolean cancellaCalciatore(Connection con,String nome)
    {
        
        int rows   = 0;
        Statement statement = null;
        String SQL = "DELETE FROM Calciatori WHERE name='"+nome+"';";
        
        try
        {
            statement = con.createStatement();
            System.out.println(SQL);
            //EXECUTE THE ACTION
            rows = statement.executeUpdate(SQL);
          } catch (SQLException ex)
        {
          
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            System.out.println("Cannot delete data!"+ex);
            return false;
        }
        
        System.out.println("CANCELLATE " + rows + " RIGHE");
        return true;
    }
    static boolean inserisciCalciatore(Connection con,String nomeCalciatore,String nomeSquadra) 
    {
       Statement stmt;
        try {
          
            stmt = con.createStatement();
            String stringSQL = "INSERT INTO Calciatori (name,squadra) values ('" +nomeCalciatore+"','"+nomeSquadra+"')";
            //LOG THE ACTION
            System.out.println(stringSQL);
            //EXECUTE THE ACTION
            int inserted = stmt.executeUpdate(stringSQL);
            System.out.println("INSERITE " + inserted + " RIGHE");
            
        } catch (SQLException ex)
        {
          
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            System.out.println("Cannot insert data!"+ex);
            return false;
        }
        
        return true;
    }
      //DEVO MODIFICARE LA FUNZIONE, la faccio specifica
      static void visualizzaCalciatori(Connection con)
      {
          Statement stmt;
          ResultSet resSet;
          String stringSQL = "SELECT * FROM calciatori;";
          
          //LOG THE ACTION
          System.out.println(stringSQL);
          
        try 
        {
          stmt = con.createStatement();
          //EXECUTE THE ACTION
          resSet = stmt.executeQuery(stringSQL);
          
//          //POTREI USARE QUESTO
//          int col = resSet.getMetaData().getColumnCount();
//          
          while(resSet.next())
          {
             String nome    = resSet.getString("name");
             String squadra = resSet.getString("squadra");
             
             System.out.println(nome + "  \t" +squadra);
          }
        }
        catch (SQLException ex)
        {
          
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            System.out.println("Cannot get data!"+ex);
        }
      }
      
     static void selezionaCalciatori(Connection con,ArrayList<Calciatore> calciatori)
      {
          Statement stmt;
          ResultSet resSet;
          String stringSQL = "SELECT * FROM calciatori;";
          
          //LOG THE ACTION
          System.out.println(stringSQL);
          
        try 
        {
          stmt = con.createStatement();
          //EXECUTE THE ACTION
          resSet = stmt.executeQuery(stringSQL);
          
//          //POTREI USARE QUESTO
 //         int col = resSet.getMetaData().getColumnCount();
//          
     
          while(resSet.next())
          {
             calciatori.add(new Calciatore(resSet.getInt("ID"),resSet.getString("name"),resSet.getString("squadra"),resSet.getString("ruolo")));
           
          }
        }
        catch (SQLException ex)
        {
          
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            System.out.println("Cannot get data!"+ex);
        }
      }

}
