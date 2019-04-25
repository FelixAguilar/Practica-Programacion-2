/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicafinal;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author Felix
 */
public class CirclePanel extends JPanel implements MouseMotionListener {
    
    public Circle[] ballscollection; //Deberia ser privado.

    public CirclePanel() {
        
        
        
       // Declarar l'interés pels esdeveniments propis de la ratoli
       this.addMouseMotionListener(this);
    }
    
    public Circle[] resize (String s){
        
        int n = Integer.parseInt(s);
                
        Circle[] c = new Circle[n];
        
        Vector v = new Vector (0,0);
        
        for(int i = n; i > 0; i--){
            c[i] = new Circle(v,v,v);
        }
        
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
