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
public class NormalPackage extends Package{
    
    NormalPackage(){
        this.Payment = 29.90;
    }
    
    public String Pay(double amt){
        return String.format("Pay Amount: RM%.2f",amt);
    }
    
    public Double getPayAmount(){
        return Payment;
    }
}
