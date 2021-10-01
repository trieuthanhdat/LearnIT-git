/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanager;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import static usermanager.Userlist.filename;

/**
 *
 * @author trieu
 */
public class UserManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code applicati int choice;
        
           int choice;
           String enpass, depass;
           Userlist user=new Userlist();
           ArrayList<Users> newlist=new ArrayList<>();
           System.out.println("Set a password(ex: SHA256): ");
           Scanner pw=new Scanner(System.in);
           enpass=user.encryppass(pw.nextLine());
           System.out.println("Password encrypted: ");
          
           System.out.println(enpass);
           System.out.println("Password decrypted: ");
           depass=user.decryptmpass(enpass);
           System.out.println(depass);
           do
           {
               
               System.out.println("1. Create user account");
               System.out.println("2. Check exist user");
               System.out.println("3. Search user information by name");
               System.out.println("4. Delete user");
               System.out.println("5. Update user");
               System.out.println("6. Save account to file");
               System.out.println("7. Print list user from file");
              
               System.out.println("other. Quit Program");
               Scanner sc= new Scanner(System.in);
               choice=sc.nextInt();
                Users list=new Users();
               switch(choice)
               {
                   case 1: 
                        
                        
                  
                        do{
                            sc=new Scanner(System.in);
                        System.out.println("Enter Username: ");
                        }while(list.setUsername(sc.nextLine())==false);
                        do{
                            sc=new Scanner(System.in);
                        System.out.println("Enter Firstname: ");
                        }while(list.setFirstname(sc.nextLine())==false);
                        do{
                            sc=new Scanner(System.in);
                        System.out.println("Enter Lastname: ");
                        }while(list.setLastname(sc.nextLine())==false);
                        do{
                            sc=new Scanner(System.in);
                        System.out.println("Enter Pawword: ");
                        }while(list.setPassword(sc.nextLine())==false);
                        do{
                            sc=new Scanner(System.in);
                        System.out.println("Confirm Pawword: ");
                        }while(list.confirmation(sc.nextLine())==false);
                        do{
                            sc=new Scanner(System.in);
                        System.out.println("Enter email: ");
                        }while(list.setEmail(sc.nextLine())==false);
                        do{
                            sc=new Scanner(System.in);
                        System.out.println("Enter phone number: ");
                        }while(list.setPhone(sc.nextLine())==false);
                        
                        if(user.adduser(list)==true)
                        {
                        System.out.println("CREATED!!!");
                        }
                        else{
                             
                                System.out.println("Failed to create!!");
                                break;
                        }
                    
                       break;
                   case 2: 
                       System.out.println("Enter user's username to check");
                        sc=new Scanner(System.in);
                       user.finduser(sc.nextLine());
                       break;
                   case 3: 
                        System.out.println("Enter user's firstname and lastname to search for information");
                        sc=new Scanner(System.in);
                        Scanner ss=new Scanner(System.in);
                       user.finduser2(sc.nextLine(),ss.nextLine());
                       break;
                   case 4: 
                       Users list2=new Users();
                       String  pass;
                       System.out.println("Login required!!");
                            sc=new Scanner(System.in);
                               System.out.println("Enter Password: ");
                               pass=user.encryppass(sc.nextLine());
                               
                            if(!pass.equals(enpass))
                              {
                                 System.out.println("y to try again??");
                                 sc=new Scanner(System.in);
                          
                                    if(sc.nextLine().equalsIgnoreCase("y"))
                                        {        
                                              do{sc=new Scanner(System.in);
                                                System.out.println("Renter Password: ");
                                                  pass=user.encryppass(sc.nextLine());
                                              }while(!pass.equals(enpass));
                                        }
                                     System.out.println("Which user u want to remove:");
                                     sc=new Scanner(System.in);
                            
                                        if(user.removeuser(sc.nextLine())==true)
                                            {
                                                System.out.println("Successed");
                                                break;
                                            }
                              }
                              else
                            {         
                                    
                                
                             System.out.println("Which user u want to remove:");
                                            sc=new Scanner(System.in);
                            
                                        if(user.removeuser(sc.nextLine())==true)
                                            {
                                                System.out.println("Successed");
                                                break;
                                            }
                              else{
                                System.out.println("Failed");
                                break;
                                  }
                            }
                                           
                             
                        
                      
                       break;
                   case 5: 
                       System.out.println("Enter User's Username to update: ");
                       sc=new Scanner(System.in);
                       user.update(sc.nextLine());
                       break;
                   case 6: 
                     
                       System.out.println("your account will be saved to user.txt) ");
                      
                       for(int i=0;i<=user.size();i++)
                       FileDAO.writeUser(user, "user.txt");
                       break;
                   case 7:  
                       
                       FileDAO.loadUsers("user.txt");
                       user.ReadFile();
                       
                       break;
                   default:
                       System.out.println("Sayounara!!");
                       break;
                  
                       
               
               }
           }while(choice>=1&&choice<=7);
    }
 
}
