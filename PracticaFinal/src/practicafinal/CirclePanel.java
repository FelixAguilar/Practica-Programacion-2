/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicafinal;

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
    
    private Circle[] ballsCollection; //Deberia ser privado.
    private Dimension size;

    public CirclePanel() {
        
        size = this.getSize();
        ballsCollection = resize("1"); 
       
        
        // Declarar l'interés pels esdeveniments propis de la ratoli
       this.addMouseMotionListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);//Para evitar errores aleatorios.
        
        Graphics2D g2 = (Graphics2D) g;
        
        for(int i = 0; i < ballsCollection.length; i++){
            ballsCollection[i].paint(g2);
        }
        this.repaint();
    }
    
    public Circle[] resize (String s){
        
        int n = Integer.parseInt(s);
                
        Circle[] c = new Circle[n];
        Random rand = new Random();
        
        for(int i = n-1; i >= 0; i--){
            Vector v = new Vector (rand.nextDouble() * size.width, rand.nextDouble() * size.height);
            c[i] = new Circle(v,v,v);
        }
        
        return c;
    }
    
    public Dimension getsize() {
        return size;
    }

    public void setsize(Dimension size) {
        this.size = size;
    }

    public Circle[] getBallscollection() {
        return ballsCollection;
    }

    public void setBallscollection(Circle[] ballscollection) {
        this.ballsCollection = ballscollection;
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
