package CSC4380Hnguyen154Assignment4;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Line2D;

public class Panel extends JPanel
{
    Random rand = new Random();
    private List<Object> shapes = new ArrayList<>();
    
    public Panel (){
        
    }
    
    public void addLine(int x1, int y1,int x2,int y2) {
        shapes.add(new Line(x1,y1,x2,y2));
        repaint();
    }

    public void addRect(int x1, int y1,int x2,int y2) {
        shapes.add(new Rect(x1,y1,x2,y2));
        repaint();
    }
    
      
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setBackground(Color.ORANGE);
        
        for (Object s : shapes) {
            if (s instanceof Line) {
                ((Line) s).draw(g);
            } 
            if (s instanceof Rect) {
                ((Rect) s).draw(g);
            }    
        }
        
    }
}
