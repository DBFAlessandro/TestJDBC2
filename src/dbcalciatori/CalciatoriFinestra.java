/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcalciatori;

import javax.swing.JFrame;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Corso
 */

public class CalciatoriFinestra extends JFrame
{
    private  JTextArea jta;
             
    public CalciatoriFinestra()
    {
       super("GESTIONE CALCIATORI");
       super.setPreferredSize(new Dimension(600,400));
       super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       super.setLayout(new BorderLayout(5,5));
       super.setResizable(false);
       //pannello centrale
       JPanel centerPanel = new JPanel();
       centerPanel.setLayout(new GridLayout(3,2,3,3));
       
       //LABEL !!!
       JLabel label1 = new JLabel("Il nome del calciatore");
       //campo testo calciatore
       JTextField nome = new JTextField();
       
       JLabel label2   = new JLabel("La squadra del calciatore è:");
       //campo testo squadra
       JTextField squadra = new JTextField();
       JLabel label3   = new JLabel("Il ruolo del calciatore è:");
       
       JTextField ruolo = new JTextField();
       
       centerPanel.add(label1);
       centerPanel.add(nome);
       centerPanel.add(label2);
       centerPanel.add(squadra);
       centerPanel.add(label3);
       centerPanel.add(ruolo);
       
       
       //pannello sotto
       JPanel southPanel    = new JPanel();
       southPanel.setLayout(new BorderLayout());
       jta = new JTextArea();
       jta.setEditable(false);
       
       JScrollPane scrollPane = new JScrollPane(jta);
       scrollPane.setPreferredSize(new Dimension(580,220));

      
       JButton jb = new JButton("Esegui");
       jb.setPreferredSize(new Dimension(100,30));
    
      
       
       JPanel  southSouthPanel = new JPanel();
       southSouthPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
       
       southSouthPanel.add(jb,BorderLayout.SOUTH);
       
       southPanel.add(scrollPane,BorderLayout.CENTER);
       southPanel.add(southSouthPanel,BorderLayout.SOUTH);
       
       super.add(centerPanel,BorderLayout.CENTER);
       super.add(southPanel,BorderLayout.SOUTH);
       
       super.pack();
       super.setVisible(true);
    }
    
    //TEST VIEW ON SCREEN
    public void visualizzaCalciatori(ArrayList<Calciatore> calciatori)
    {
       jta.setText("NUMERO RIGHE: " + calciatori.size());
       jta.append("\n"+Calciatore.getRowHeader());
       
       for(Calciatore c: calciatori)
       {
          jta.append("\n"+c.toRowString());
       }
    }
}
