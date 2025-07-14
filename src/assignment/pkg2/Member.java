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
public class Member {
    private String FirstName;
    private String LastName;
    private String Gender;
    private String Race;
    private String Area;
    private String Contact;
    private String Email;
    private String Type;
    private String Renew_Payment;
    private String ExpireDate;
    
    public void Register(String FirstName, String LastName, String Gender, String Race, String Area, String Contact, String Email, String Type, String Renew_Payment, String ExpireDate){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Gender = Gender;
        this.Race = Race;
        this.Area = Area;
        this.Contact = Contact;
        this.Email = Email;
        this.Type = Type;
        this.Renew_Payment = Renew_Payment;
        this.ExpireDate = ExpireDate;
    }
    
    public String getFirstName(){
        return FirstName;
    }
    
    public String getLastName(){
        return LastName;
    }
    
    public String getGender(){
        return Gender;
    }
    
    public String getRace(){
        return Race;
    }
    
    public String getArea(){
        return Area;
    }
    
    public String getContact(){
        return Contact;
    }
    
    public String getEmail(){
        return Email;
    }
    
    public String getType(){
        return Type;
    }
    
    public String getRenewPayment(){
        return Renew_Payment;
    }
    
    public String getExpireDate(){
        return ExpireDate;
    }
}
