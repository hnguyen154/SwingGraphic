package CSC4380Hnguyen154Assignment4;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author honghao97
 */
class Frame extends JFrame {
    private JMenuBar menuBar;
    private JMenu file, help;
    private JMenuItem exit, about;
    private JPanel contentPane;
    private Panel imageContent;
    private JButton source;
    ButtonGroup group;
    JRadioButton line, rect;
    int coor1, coor2, coor3, coor4;
    
    
    public static void main (String[]args){
        EventQueue.invokeLater(new Runnable(){
            public void run ()
            {
                try{
                    Frame f = new Frame();
                    f.setVisible(true);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    
    public Frame()
    {
        //Set Frame
        setTitle("Graphics GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,600,500);
        
        //Set Menu Bar
        menuBar = new JMenuBar();
        //Build File Menu
        file = new JMenu ("File");
        exit = new JMenuItem ("Exit");
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        file.add(exit);
        
        //Build Help Menu
        help = new JMenu ("Help");
        about = new JMenuItem("About");
        about.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(about,
                    "<html><center><font size='10'>"
                            + "Welcome to the Graphic GUI. "
                            + "<br> You can draw a rectangle or a line by simply selecting the corresonding radio button and click \"Go\". "
                            + "<br> You can reposition the shape with the new coordinates (Numbers ONLY)."
                            + "<br> After inputting the coordinates, click redraw to change the position.</font></html> ");
            }
        });
        help.add(about);
        
        menuBar.add(file);
        menuBar.add(help);
        setJMenuBar(menuBar);
        
        //mainPanel can break down to imagePanel and controlPanel       
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);
        centerWindow(this);
        
        //Panel for Image
        imageContent = new Panel();
        contentPane.add(imageContent, BorderLayout.CENTER); 
        
        //Create control panel
        JPanel controlContent = createControlPanel();
        contentPane.add(controlContent, BorderLayout.SOUTH);
        
        
        
    }

    private JPanel createControlPanel() {
        //Panel for control
        JPanel controlContent = new JPanel();
        
        //TextField for coordinates
        JTextField x1 = new JTextField("x1");
        controlContent.add(x1);
        JTextField y1 = new JTextField("y1");
        controlContent.add(y1);
        JTextField x2 = new JTextField("x2");
        controlContent.add(x2);
        JTextField y2 = new JTextField("y2");
        controlContent.add(y2);
       
        //Group of radio buttons for line or rectangle
       group = new ButtonGroup();
       line = new JRadioButton("Line");
       rect = new JRadioButton("Rectangle");
       line.setSelected(true);
       group.add(line);
       group.add(rect);
       controlContent.add(line);
       controlContent.add(rect);
        
        //Button for drawing
        JButton goButton = new JButton("Go");
        controlContent.add(goButton);
        //Run the image after Radio Button is being selected
        goButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                Random r = new Random();
                //Random coordinate for Line            
                int a = r.nextInt(600-0+1)+0;
                int b = r.nextInt(300-0+1)+0;
                int c = r.nextInt(300-0+1)+0;
                int d = r.nextInt(600-0+1)+0;
                
                if(line.isSelected()){
                    imageContent.addLine(a,b,c,d);
                    //goButton.setEnabled(false);
                    //goButton.setBackground(Color.RED);
                }
                
                //Random coordinate for Rectangle  
                Dimension size = getSize();
                Insets insets = getInsets();
                int w = size.width - insets.left - insets.right;
                int h = size.height - insets.top - insets.bottom;
                int x = Math.abs(r.nextInt()) % w;
                int y = Math.abs(r.nextInt()) % h;
                
                if(rect.isSelected()){
                    imageContent.addRect(x,y,x,y);
                    //goButton.setEnabled(false);
                    //goButton.setBackground(Color.RED);
                }
           }
           
        });
        
        
        JButton redrawButton = new JButton("Redraw");
        controlContent.add(redrawButton);
        redrawButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                //User's input for coordinates for Line or Rectangle             
                
                try{
                    coor1 = Integer.parseInt(x1.getText());
                    coor2 = Integer.parseInt(y1.getText());
                    coor3 = Integer.parseInt(x2.getText());
                    coor4 = Integer.parseInt(y2.getText());
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(redrawButton,"Please only input numbers!","Invalid Input", JOptionPane.INFORMATION_MESSAGE);
                }
                if(line.isSelected()){
                        imageContent.addLine(coor1,coor2,coor3,coor4); 
                }
                    
                if(rect.isSelected()){
                        imageContent.addRect(coor1,coor2,coor3,coor4);
                }
           }
           
        });     
        
        JButton clearButton = new JButton("Clear");
        controlContent.add(clearButton);
        clearButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               if ( JOptionPane.showConfirmDialog(null, "Are you sure you want to clear all?") == JOptionPane.YES_OPTION )
               {
                    imageContent.removeAll();
                    imageContent.revalidate();
                    imageContent.repaint();
                    
               }
           }
        }); 
        
        
        return controlContent;
    }
    
   
    private void centerWindow(Frame f){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screen.getWidth() - getWidth()) /2);
        int y = (int) ((screen.getHeight() -getHeight()) /2);
        setLocation(x, y); 
    }
}
