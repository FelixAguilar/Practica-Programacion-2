/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author abenn
 */
public class DivisionByZero extends Exception {
    
    public DivisionByZero(){
        super("No se puede dividir por cero(0)");
    }
}
