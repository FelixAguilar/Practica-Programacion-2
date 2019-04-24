
package practicafinal;

/**
 *
 * @author Felix
 */
public class Vector {
    
    private double x; //Cordenada X del vector.
    private double y; //Cordenada Y del vector.

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    /**
     * Permite realizar la suma de dos vectores.
     *  
     * @param v 
     */
    public void add(Vector v){
        this.x = this.x + v.getX();
        this.y = this.y + v.getY();
    }
    
    /**
     * Permite realizar la resta de dos vectores.
     *  
     * @param v 
     */
    public void sub(Vector v){
        this.x = this.x - v.getX();
        this.y = this.y - v.getY();
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
     */
    public void div(double k){
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
     */
    public Vector uni(){
        Vector v = new Vector(this.x, this.y);
        double n = v.mod();
        v.setX(v.getX() / n);
        v.setY(v.getY() / n);
        return v;
    }
    
    /**
     * Impone el numero introducido a la magnitud del vector.
     * 
     * @param k 
     */
    public void lim(double k){//comparacion falta.
         Vector v = new Vector(this.x, this.y);
         v = v.uni();
         v.mult(k);
         this.x = v.getX();
         this.y = v.getY();
    }
}
