/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

/**
 *
 * @author wan wai hoe
 */
public abstract class Package {
    Double Payment;
    
    public Double pay(double payment){
        Payment = payment;
        return Payment;
    }
}
