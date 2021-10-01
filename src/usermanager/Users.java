/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanager;

import java.util.ArrayList;

/**
 *
 * @author trieu
 */
public class Users extends ArrayList{
    String username;
    String firstname;
    String lastname;
    String password;
    String email;
    String phone;
    boolean confirm=true;

    public Users(String username, String firstname, String lastname, String password, String email, String phone) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public Users() {
        username="";
        firstname="";
        lastname="";
        password="";
        email="";
        phone="";
    }

   

    public String getUsername() {
        return username;
    }

    public boolean setUsername(String username) {
        if(Validate.validusernames(username)==true)
        {this.username = username;
        return true;
        }
        else{
            System.out.println("Username must be at least 5 characters");
            return false;
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public boolean setFirstname(String firstname) {
        if(firstname==null||firstname.isEmpty())
            return false;
        this.firstname = firstname;
        return true;
    }

    public String getLastname() {
        return lastname;
    }

    public boolean setLastname(String lastname) {
        if(lastname==null||lastname.isEmpty())
            return false ;
        this.lastname = lastname;
        return true;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
           if(Validate.validPass(password)==true)
           {
               this.password = password;
               return true;
    }
        else
        {
            System.out.println("Please follow the rule of password");
            return false;
        }
       
    }

    public String getEmail() {
        
        return email;
    }

    public boolean setEmail(String email) {
        if(Validate.validemail(email)==true)
        {  this.email = email;
        return true;
        }
        else{
            System.out.println("Not a valid email");
            return false;
        }
        
    }

    public String getPhone() {
        return phone;
    }

    public boolean setPhone(String phone) {
        if(Validate.validphone(phone)==true){
        this.phone = phone;
        return true;
        }
        else{
            System.out.println("Not a valid phonenumber");
            return false;
        }
    }
    public boolean confirmation(String repass)
    {
        if(repass.equals(password))
        {
            return true;
        }
        else
            
            System.out.println("Password does not match");
        return false;
        
    }
    public boolean confirmationUsername(String repass)
    {
        
        if(repass.equals(username))
        {
            return true;
        }
        else
            
            System.out.println("Wrong Username");
        return false;
        
    }

    @Override
    public String toString() {
        return "+++++++++++"+"Users" +"+++++++++++"+ "\n Username= " + username + "\n Firstname=" + firstname + ", Lastname=" + lastname + "\n Password=" + password + "\n Email=" + email + "\n Phone=" + phone+"\n" ;
    }
    
    
           
}
