/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcalciatori;

public class Calciatore 
{
    
    private int ID;
    private String name;
    private String squadra;
    private String ruolo;

    public Calciatore(int ID, String name, String squadra, String ruolo) 
    {
        
        
        setID(ID);
        setName(name);
        setSquadra(squadra);
        setRuolo(ruolo);
    }
    
    
    
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSquadra() {
        return squadra;
    }

    public String getRuolo() {
        return ruolo;
    }

    private void setID(int ID) 
    {
        this.ID = ID;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setSquadra(String squadra) {
        this.squadra = squadra;
    }

    private void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String toString()
    {
      return "ID: "+ ID +",Nome: " + name + ",Squadra: " + squadra + ",Ruolo: " + ruolo;
    }
     public String toRowString()
    {
      return "" + ID + "\t" + name + "\t" + squadra + "\t" + ruolo;
    }
     public static String getRowHeader()
     {
         return "ID\tNOME\tSQUADRA\tRUOLO";
     }
}
