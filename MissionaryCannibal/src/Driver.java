
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TASNEEA
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BFS bfs = new BFS();
        bfs.start(new State());
        bfs.printPath();
        System.out.println("Done!");
        
///user interface
        
     /*   JLabel lab = new JLabel("Do you want to see the visual representation of the solution?");
        JFrame f = new JFrame("MISSIONARY CANNIBAL");
        f.add(lab);
        lab.setFont(new Font("", Font.CENTER_BASELINE, 18));
        f.pack();
        f.setVisible(true);
        f.setSize(600, 400);
        f.setBackground(Color.CYAN);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //
        
        
        //

        JPanel p = new JPanel(new GridBagLayout());

        JButton b1 = new JButton("NO ");

        JButton b2 = new JButton("YES");
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

              JFrame J =  new JFrame("Solutions of Missionary-Cannibal");
              f.setVisible(false);


J.setResizable(true);
J.pack();
J.setVisible(true);

            }
        });
           b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
f.dispose();
            }
        });
        GridBagConstraints c = new GridBagConstraints();

        p.setBackground(Color.BLACK);
        c.insets = new Insets(10, 10, 10, 10);
        p.add(b1);
        p.add(b2);
        c.gridx = 1;
        c.gridy = 0;
        p.add(b1, c);
        c.gridx = 2;
        c.gridy = 0;

        f.add(p, BorderLayout.SOUTH);*/
    

    }

}
//}