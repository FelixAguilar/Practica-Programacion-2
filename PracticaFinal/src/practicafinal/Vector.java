
package practicafinal;

import exceptions.DivisionByZero;

/**
 * Clase Vector, permite la creacion de vectores y las operaciones con ellos.
 * 
 * @author Felix Lluis Aguilar Ferrer
 * @author Adrián Bennasar Polzin
 */
public class Vector {
    
    public double x; //Cordenada X del vector.
    public double y; //Cordenada Y del vector.

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Permite realizar la suma de dos vectores.
     *  
     * @param v 
     */
    public void add(Vector v){
        this.x = this.x + v.x;
        this.y = this.y + v.y;
    }
    
    /**
     * Permite realizar la resta de dos vectores.
     *  
     * @param v 
     */
    public void sub(Vector v){
        this.x = this.x - v.x;
        this.y = this.y - v.y;
    }
    
    /**
     * Permite multiplicar el vector por un escalar.
     *  
     * @param k 
     */
    public void mult(double k){
        this.x = this.x * k;
        this.y = this.y * k;
    }
    
    /**
     * Permite dividir el vector por un escalar.
     *  
     * @param k 
     * @throws exceptions.DivisionByZero 
     */
    public void div(double k) throws DivisionByZero { 
        if (k == 0) {
            throw new DivisionByZero();
        }
        this.x = this.x / k;
        this.y = this.y / k;
    }
    
    /**
     * Devuelve el modulo (magnitud) del vector.
     * 
     * @return 
     */
    public double mod(){
        return Math.sqrt((Math.pow(this.x, 2) + Math.pow(this.y, 2)));
        
    }
    
    /**
     * Devuelve el vector unitario del vector.
     * 
     * @return 
     * @throws exceptions.DivisionByZero 
     */
    public Vector uni() throws DivisionByZero{
        Vector v = new Vector(this.x, this.y);
        double n = v.mod();
        v.div(n);
        return v;
    }
    
    /**
     * Impone el numero introducido a la magnitud del vector.
     * 
     * @param k 
     * @throws exceptions.DivisionByZero 
     */
    public void lim(double k) throws DivisionByZero{
        Vector v = new Vector(this.x, this.y);
        if(v.mod() > k){
            v = v.uni();
            v.mult(k);
            this.x = v.x;
            this.y = v.y;
        }
    }
}
