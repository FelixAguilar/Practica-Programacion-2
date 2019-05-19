/**
 * @author Felix Lluis Aguilar Ferrer.
 * @author Adrián Bennasar Polzin.
 * 
 * enlace video:
 */

package window;

import vector.DivisionByZero;
import vector.Vector;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 * Concepto panel de círculos. Contiene los atributos que definen a un panel de 
 * círculos, junto a los métodos que definen su comportamiento.
 */
public class CirclePanel extends JPanel implements MouseMotionListener {
    
    //Atributos del concepto.
    private Circle[] ballsCollection;
    private Vector mousePosition;
    private boolean walls;
    private boolean follow;

    /**
     * Constructor.
     */
    public CirclePanel() {
        
        //Añadimos el escuchador del ratón al panel.
        this.addMouseMotionListener(this);
        mousePosition = new Vector(0,0);
    }
    
    /**
     * Método para dibujar los elementos del panel.
     * 
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g){
        
        /*Instrucción que invoca a las operaciones del paintComponent 
        proporcionado por Oracle.*/
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        for(int i = 0; i < ballsCollection.length; i++){
            ballsCollection[i].paint(g2);
        }
        
        //Llama al método paintComponent.
        this.repaint();
    }
    
    /**
     * Método bucle infinito. Realiza los cálculos para el reposicionamiento de
     * los círculos dentro del panel teniendo en cuenta los valores de los
     * atributos boolean correspondientes.
     * 
     * @throws InterruptedException
     * @throws DivisionByZero 
     */
    public void infiniteLoop() throws InterruptedException, DivisionByZero{
        while(true){
            
            /*Recorrido del array de círculos, actualizando el círculo al que
            corresponde el indice de cada iteración.*/
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
            
            //Pone el hilo actual en espera.
            Thread.sleep(10);
        }
    }
    
    /**
     * Método para redimensionar el array de círculos. Además sobreescribe los
     * círculos que habia antes de su ejecución.
     * 
     * @param n
     */
    public void resizeBallsCollection(int n){       
        Circle[] c = new Circle[n];
        for(int i = n-1; i >= 0; i--){
            c[i] = new Circle(getSize());
        }
        this.ballsCollection = c;
    }
    
    /**
     * Método para obtener la posición del ratón. Se ejecuta cuando el usuario
     * arrastra el ratón a la vez que mantiene un botón de este.
     * 
     * @param mouse 
     */
    @Override
    public void mouseDragged(MouseEvent mouse) {
        mousePosition.x = mouse.getX();
        mousePosition.y = mouse.getY();
    }

    /**
     * Método para obtener la posición del ratón. Se ejecuta cuando el usuario
     * mueve el ratón.
     * 
     * @param mouse 
     */
    @Override
    public void mouseMoved(MouseEvent mouse) {
        mousePosition.x = mouse.getX();
        mousePosition.y = mouse.getY();
    }

    public void setWalls(boolean walls) {
        this.walls = walls;
    }

    public void setFollow(boolean follow) {
        this.follow = follow;
    }  
}
