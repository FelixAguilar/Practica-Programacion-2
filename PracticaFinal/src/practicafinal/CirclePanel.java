/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicafinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Felix
 */
public class CirclePanel extends JPanel implements MouseMotionListener {
    
    private Circle[] ballscollection; //Deberia ser privado.
    private Dimension size;

    public Dimension getsize() {
        return size;
    }

    public void setsize(Dimension size) {
        this.size = size;
    }

    public Circle[] getBallscollection() {
        return ballscollection;
    }

    public void setBallscollection(Circle[] ballscollection) {
        this.ballscollection = ballscollection;
    }

    public CirclePanel() {
        
        
       ballscollection = resize("4"); 
       
        
       // Declarar l'interés pels esdeveniments propis de la ratoli
       this.addMouseMotionListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);//Para evitar errores aleatorios.
        
        Graphics2D g2 = (Graphics2D) g;
        
        for(int i = 0; i < ballscollection.length; i++){
            g2.draw(ballscollection[i].getShape());
            g2.setPaint(ballscollection[i].getColor());
            g2.fill(ballscollection[i].getShape()); 
        }
        this.repaint();
    }
    
    public Circle[] resize (String s){
        
        int n = Integer.parseInt(s);
                
        Circle[] c = new Circle[n];
        Random rand = new Random();
        Vector v = new Vector (rand.nextDouble((double) size.width), rand.nextDouble((double) size.height)); //error revisr randoms.
        
//        Vector w = new Vector (60,60);
        
        for(int i = n-1; i >= 0; i--){
            c[i] = new Circle(v,v,v);
        }
//        c[0] = new Circle(v,v,v);
//        c[1] = new Circle(w,v,v);
        
        return c;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
