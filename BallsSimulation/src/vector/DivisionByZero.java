/**
 * @author Felix Lluis Aguilar Ferrer.
 * @author Adrián Bennasar Polzin.
 * 
 * enlace video: https://youtu.be/AwL6r1bCpRY
 */

package vector;

/**
 * Excepción División por cero. Llama al constructor de la clase padre para
 * informar del motivo del error.
 */
public class DivisionByZero extends Exception {
    
    public DivisionByZero(){
        super("No se puede dividir por cero(0).");
    }
}
