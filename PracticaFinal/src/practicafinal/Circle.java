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
    
    private final Double Diameter = 50.0;
    private Shape shape;
    private Color color;
    private Vector position;
    private Vector speed;
    private Vector acceleration;

    public Circle(Vector position, Vector speed, Vector acceleration) {
        
        //Generacion del color al azar.
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        this.color = new Color(r, g ,b);

        //Forma del circulo.
        this.shape = new Ellipse2D.Double(position.getX(), position.getY(), this.Diameter, this.Diameter);
        
        this.position = position;
        this.speed = speed;
        this.acceleration = acceleration;
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
    
    
    /*
    public void updfall(){//Modeificar!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        
        if ((acceleration.getY() + position.getY()) > Window.sizey){
            acceleration.setY(0);
        }else{
            acceleration.setY(50);
        }
        
        if((acceleration.getX() + position.getX()) > Window.sizex){
            acceleration.setX(0);
        }else{
            acceleration.setX(10);
        }
        
    }
    */
    
    public void updfollowmouse(){
        
    }
    
    
    
    
    
}
