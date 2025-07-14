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
public class VIPPackage extends NormalPackage {
    
    double Appointment;
    
    public VIPPackage(){
        this.Payment = 39.90;
    }
    
    @Override
    public String Pay(double amt){
        return String.format("Pay Amount: RM%2f",amt);
    }
    
    @Override
    public Double getPayAmount(){
        return Payment;
    }
    
    public void setAppointment(double Appointment){
        this.Appointment = Appointment;
    }
    
    public String checkAppointmenr(){
        return String.format("Appointment time at: %",Appointment);
    }
}
