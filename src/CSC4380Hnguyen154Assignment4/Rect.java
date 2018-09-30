/* Name: Hao Nguyen
 * Class: CSC 4380
 * Title: Assignment 4 - Graphic GUI
 * Date: September 30, 2018
 * Campus ID: hnguyen154
 */

package CSC4380Hnguyen154Assignment4;

import java.util.*;
import java.awt.*;

public class Rect {
    int x1 , y1, x2, y2;
  
    public Rect (){
        
    }
            
    public Rect(int x1, int y1,int x2,int y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(13, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND);
        g2.setStroke(bs);
        g2.setColor(Color.BLUE);
        g2.drawRect(x1,y1,x2,y2);
        
        
    }
    
}
