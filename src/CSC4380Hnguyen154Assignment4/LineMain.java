/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC4380Hnguyen154Assignment4;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author honghao97
 */
public class LineMain extends JFrame {
    
    public LineMain(){
        JPanel panel=new JPanel();
        getContentPane().add(panel);
        setSize(1000,1000);
        
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screen.getWidth() - getWidth()) /2);
        int y = (int) ((screen.getHeight() -getHeight()) /2);
        setLocation(x, y); 
    }
     public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(100, 100, 250, 260);
        g2.draw(lin);
    }

    public static void main(String []args){
        LineMain s=new LineMain();
        s.setVisible(true);
    }
}