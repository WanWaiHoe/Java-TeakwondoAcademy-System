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
public class VVIPPackage extends VIPPackage{
    
    String Instructor;
    
    public VVIPPackage(){
        this.Payment = 49.90;
    }
    
    @Override
    public String Pay(double amt){
        return String.format("Pay Amount: RM%2f",amt);
    }
    
    @Override
    public Double getPayAmount(){
        return Payment;
    }
    
    @Override
    public void setAppointment(double Appointment){
        this.Appointment = Appointment;
    }
    
    @Override
    public String checkAppointmenr(){
        return String.format("Appointment time at: %",Appointment);
    }
    
    public void chooseInstructor(String Instructor){
        this.Instructor = Instructor;
    }
    
    public String checkInstructor(){
        return String.format("Your Instructoe is: %",Instructor);
    }
}
