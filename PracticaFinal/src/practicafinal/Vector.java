/**
 * @author Felix Lluis Aguilar Ferrer.
 * @author Adrián Bennasar Polzin.
 *
 * enlace video:
 */

package practicafinal;

import exceptions.DivisionByZero;

/**
 * Clase Vector. Permite la creación de vectores y las operaciones con ellos.
 */
public class Vector {
    
    public double x; //Cordenada X del vector.
    public double y; //Cordenada Y del vector.

    /**
     * Constructor.
     * 
     * @param x
     * @param y 
     */
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Método que realiza la suma de dos vectores.
     *  
     * @param v 
     */
    public void add(Vector v){
        this.x = this.x + v.x;
        this.y = this.y + v.y;
    }
    
    /**
     * Método que realiza la resta de dos vectores.
     *  
     * @param v 
     */
    public void sub(Vector v){
        this.x = this.x - v.x;
        this.y = this.y - v.y;
    }
    
    /**
     * Método que realiza la multiplicación del vector por un escalar.
     *  
     * @param k 
     */
    public void mult(double k){
        this.x = this.x * k;
        this.y = this.y * k;
    }
    
    /**
     * Método que realiza la división del vector por un escalar.
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
     * Método que devuelve el módulo (magnitud) del vector.
     * 
     * @return 
     */
    public double mod(){
        return Math.sqrt((Math.pow(this.x, 2) + Math.pow(this.y, 2)));
        
    }
    
    /**
     * Método que devuelve el vector unitario del vector.
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
     * Método que impone el número introducido a la magnitud del vector.
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
