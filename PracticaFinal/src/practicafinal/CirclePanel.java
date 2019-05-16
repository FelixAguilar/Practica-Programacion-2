package practicafinal;

import exceptions.DivisionByZero;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author Felix Lluis Aguilar Ferrer
 * @author Adrián Bennasar Polzin
 */
public class CirclePanel extends JPanel implements MouseMotionListener {
    
    private Circle[] ballsCollection;
    private Vector mousePosition;
    private boolean walls;
    private boolean follow;

    public CirclePanel() {
       mousePosition = new Vector(0,0);
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
    
    public void infiniteLoop() throws InterruptedException, DivisionByZero{
        
        boolean end = false;
        while(!end){
         
            for (int i = 0; i < ballsCollection.length; i++) {
                ballsCollection[i].movement();
                if (walls){
                    ballsCollection[i].interactionWithWalls(getSize());
                }else{
                    ballsCollection[i].interactionWithoutWalls(getSize());
                }
                if (follow){
                    ballsCollection[i].mouseAcceleration(mousePosition);
                }else{
                    ballsCollection[i].fallingAcceleration();
                }
                
            }
            this.repaint();
            Thread.sleep(10);
        }
    }
    
    public Circle[] resize (String s){
        
        int n = Integer.parseInt(s);
                
        Circle[] c = new Circle[n];

        for(int i = n-1; i >= 0; i--){
            c[i] = new Circle(getSize());
        }
        
        return c;
    }

    public Circle[] getBallscollection() {
        return ballsCollection;
    }

    public void setBallscollection(Circle[] ballscollection) {
        this.ballsCollection = ballscollection;
    }

    public boolean isWalls() {
        return walls;
    }

    public void setWalls(boolean walls) {
        this.walls = walls;
    }

    public boolean isFollow() {
        return follow;
    }

    public void setFollow(boolean follow) {
        this.follow = follow;
    }
    
    

    @Override
    public void mouseDragged(MouseEvent mouse) {
        mousePosition.x = mouse.getX();
        mousePosition.y = mouse.getY();
    }

    @Override
    public void mouseMoved(MouseEvent mouse) {
        mousePosition.x = mouse.getX();
        mousePosition.y = mouse.getY();
    }
    
}
