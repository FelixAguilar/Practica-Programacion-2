/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicafinal;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 *
 * @author Felix
 */
public class Circle {
    
    private final Double diameter = 50.0;
    private Shape shape;
    private Color color;
    private Vector position;
    private Vector speed;
    private Vector acceleration;

    public Circle(CirclePanel cp) {
       
        //Generacion del color al azar.
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        this.color = new Color(r, g ,b);
        
        this.position = new Vector(rand.nextDouble() * cp.getSize().width, rand.nextDouble() * cp.getSize().height);
        this.speed = new Vector(0,0);
        this.acceleration = new Vector(0,0);
        
        //Forma del circulo.
        this.shape = new Ellipse2D.Double(position.x, position.y, this.diameter, this.diameter);
        
        
    }
    
    public void paint(Graphics2D g2){
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(rh);
        this.shape = new Ellipse2D.Double(position.x, position.y, this.diameter, this.diameter);
        g2.draw(this.shape);
        g2.setPaint(this.color);
        g2.fill(this.shape); 
       
    }
    
    public void reposition(Dimension size, boolean x, boolean y){
        if (position.x > size.width) {
            position.x = -diameter;
        }
        if (position.y > size.height) {
            position.y = -diameter; 
        }
        if (position.x < -diameter) {
            position.x = size.width;
        }
        if (position.y < -diameter) {
            position.y = size.height; 
        }
   
        if (x) {
            if (y) {
                
            }else{
                
            }
        }else{
            if (y) {
                
            }else{
                position.add(speed);
            }
        }
   }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getSpeed() {
        return speed;
    }

    public void setSpeed(Vector speed) {
        this.speed = speed;
    }

    public Vector getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector acceleration) {
        this.acceleration = acceleration;
    }   
}
