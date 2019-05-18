/**
 * @author Felix Lluis Aguilar Ferrer.
 * @author Adrián Bennasar Polzin.
 * 
 * enlace video:
 */

package practicafinal;

import vector.DivisionByZero;
import vector.Vector;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * Concepto círculo. Contiene la definicion de que es un círculo, aparte de los
 * métodos que representan su comportamiento.
 */
public class Circle {
    
    //Constantes.
    private final Double DIAMETER = 50.0;
    private final int MAXSPEED = 5;
    private final Vector FALLACCELERATION = new Vector(0, 0.05);
    private final Double MOUSEACCELERATION = 0.12;
    
    //Atributos del concepto.
    private Shape shape;
    private Color color;
    private Vector position;
    private Vector speed;
    private Vector acceleration;

    /**
     * Constructor. Requiere el tamaño del panel donde se representará el
     * concepto.
     * 
     * @param panelSize
     */
    public Circle(Dimension panelSize) {
       
        //Genera el color del circulo al azar.
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        color = new Color(r, g ,b);
        
        /*Genera la posición inicial del círculo dentro de los limites del panel
        al azar. Si la posición del círculo es critica (parte del círculo se 
        dibuja fuera del panel), entonces se reajusta su posición restándole el 
        diàmetro del círculo.*/
        this.position = new Vector(rand.nextDouble() * panelSize.width,
                rand.nextDouble() * panelSize.height);
        if(position.x > (double) panelSize.width - DIAMETER){
            position.x = position.x - DIAMETER;
        }
        if(position.y > (double) panelSize.height - DIAMETER){
            position.y = position.y - DIAMETER;
        }
        
        /*Genera una velocidad inicial al azar dentro del limite de velocidad 
        impuesto por la constante. Además se multiplica esa velocidad por (-1)^n 
        donde n puede ser 0 o 1 al azar.*/
        speed = new Vector(rand.nextDouble() * MAXSPEED * 
                Math.pow(-1,rand.nextInt(2)), rand.nextDouble() * MAXSPEED * 
                Math.pow(-1, rand.nextInt(2)));
        
        //No hay aceleración inicial.
        acceleration = new Vector(0,0);
        
        //Genera la forma inicial del círculo junto con su posición inicial.
        shape = new Ellipse2D.Double(position.x,position.y,DIAMETER,DIAMETER);
    }
    
    /**
     * Método para pintar un círculo.
     * 
     * @param g2 
     */
    public void paint(Graphics2D g2){
        
        /*Utilización de la clase RenderingHints para mejorar la calidad del 
        renderizado del dibujo mediante el antialiasing.*/
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(rh);
        
        /*Impone el color del círculo actual y se dibuja y rellena utilizando
        este color.*/
        g2.setPaint(this.color);
        g2.draw(this.shape);
        g2.fill(this.shape); 
    }
    
    /**
     * Método para realizar el movimiento del círculo. Realiza un cambio en la 
     * velocidad del círculo en función de la aceleración actual y a partir de 
     * esta nueva velocidad realiza un avance en la posición.
     * 
     * @throws exceptions.DivisionByZero
     */
    public void movement() throws DivisionByZero{
        
        speed.add(acceleration);
        position.add(speed);
        
        //Se limita la velocidad máxima a la indicada por la constante.
        speed.lim(MAXSPEED);
        
        //Se actualiza el objeto Shape con el vector posición.
        shape = new Ellipse2D.Double(position.x,position.y,DIAMETER,DIAMETER);
    }
    
    /**
     * Método de aceleración en caida. Impone la aceleración del círculo con la 
     * constante.
     */
    public void fallingAcceleration(){
        acceleration.x = FALLACCELERATION.x;
        acceleration.y = FALLACCELERATION.y;
    }
    
    /**
     * Método de aceleración con ratón. Se actualiza la aceleracion dependiendo 
     * de la posicion del círculo respecto al ratón.
     * 
     * @param mouse
     * @throws DivisionByZero 
     */
    public void mouseAcceleration(Vector mouse) throws DivisionByZero{
        
        /*Se generan dos vectores que representan las coordenadas del ratón y 
        del círculo, a este último se le suma el radio para obtener las 
        coordenadas de éste desde el centro.*/
        Vector i = new Vector(mouse.x, mouse.y);
        Vector j = new Vector(position.x, position.y);
        j.x = j.x + DIAMETER/2;
        j.y = j.y + DIAMETER/2;
        
        /*Se obtiene el vector distancia entre ratón y círculo, a continuación 
        se normaliza y después es multiplicado por una constante.*/
        i.sub(j);
        i = i.uni();
        i.mult(MOUSEACCELERATION);
        
        //Se actualiza la aceleración del círculo.
        acceleration.x = i.x;
        acceleration.y = i.y;
    }
    
    /**
     * Método de interacción con bordes. En este caso, hay límites que impiden 
     * al círculo salir del panel por lo que al interactuar con uno de estos, 
     * cambiará el signo de su velocidad en el eje indicado.
     * 
     * @param size 
     */
    public void interactionWithWalls(Dimension size){
        if (position.y + DIAMETER > size.height){
            speed.y = -speed.y; 
        }
        if (position.y < 0){
            speed.y = -speed.y; 
        }
        if (position.x + DIAMETER > size.width){
            speed.x = -speed.x;
        }
        if (position.x < 0){
            speed.x = -speed.x;
        }
    }
    
    /**
     * Método de interacción sin paredes. En este caso, no hay límites que 
     * impiden al círculo salir del panel por lo que al interactuar con uno de 
     * estos, cambiará la posición en el eje de manera que saldrá por el borde 
     * opuesto.
     * 
     * @param size 
     */
    public void interactionWithoutWalls(Dimension size){
        if (position.x > size.width){
            position.x = -DIAMETER;
        }
        if (position.y > size.height){
            position.y = -DIAMETER; 
        }
        if (position.x < -DIAMETER){
            position.x = size.width;
        }
        if (position.y < -DIAMETER){
            position.y = size.height; 
        }
    }   
}
