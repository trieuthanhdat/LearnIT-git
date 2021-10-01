/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author trieu
 */
public class Validate {

   public static boolean Isvaliddate(String d)
   {
       SimpleDateFormat  df=new SimpleDateFormat("dd/mm/yyyy");
       Date dd=null;
       df.setLenient(false);
       try{
           dd=df.parse(d);
           
           return true;
       }
       catch(Exception e)
       {System.out.println("Something went wrong with this date !!!");
           return false;
       }
                   
   }
   public static boolean validphone(String s)
   {
      Pattern em=Pattern.compile("[0-9]{10,12}");
      Matcher match=em.matcher(s);
      if(Pattern.matches("[0-9]{10,12}", s)==true)return true;
      return false;
   }
   public static boolean validid(String id)
   {    
            Pattern pa= Pattern.compile("SE[0-9]{3}",Pattern.CASE_INSENSITIVE);
            Matcher m= pa.matcher(id);
            if(Pattern.matches("SE[0-9]{3}", id)==true) 
            {   
              
                return true;
            }
            return false;
   }
   public static boolean validid2(String id)
   {    
            Pattern pa= Pattern.compile("[0-9]{3}");
            Matcher m= pa.matcher(id);
            if(Pattern.matches("[0-9]{3}", id)==true) 
            {                                   
                                            
                return true;                                                                  
            }                                                                                
            return false;                
   }
   public static boolean validemail(String email)
   {
       
       Pattern ema=Pattern.compile("[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher=ema.matcher(email);
        if(Pattern.matches("(?=[^0-9])+[_A-Za-z0-9\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", email)==true)return true;
        return false;
   }
   public static boolean validategender(String gender)
   {
     if(gender.equals("f")||gender.equals("F")||gender.equals("female")||gender.equals("FEMALE"))
            return true;
     if(gender.equals("m")||gender.equals("M")||gender.equals("male")||gender.equals("MALE"))
            return true;
     
        return false;
   }
   public static boolean validPass(String pass)
   {
       Pattern pa=Pattern.compile("[A-Za-z0-9]{6,}");
       Matcher matcher=pa.matcher(pass);
       if(Pattern.matches("[A-Za-z0-9]{6,}", pass)==true)
       {
           return true;
       }
       return false;
   }
   public static boolean validusernames(String user)
   {
       Pattern pa=Pattern.compile("[A-Za-z0-9]{5,}");
       Matcher matcher=pa.matcher(user);
       if(Pattern.matches("[A-Za-z0-9]{5,}", user)==true)
       {
           return true;
       }
       return false;
   }
 }

