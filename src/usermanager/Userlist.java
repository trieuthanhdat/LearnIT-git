/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author trieu
 */
public class Userlist extends ArrayList{
    ArrayList<Users> user;
    public static final String filename="user.txt";
    
    public Userlist() throws IOException {
        user=FileDAO.loadUsers(filename);
    }

   
    
    public boolean adduser(Users x) throws FileNotFoundException
    {
        user.add(x);
        FileDAO.writeUser(user, filename);
        if(user.isEmpty()||user==null)
        {
            return false;
        }
        return true;
    }
     public static void creatfile(ArrayList<Users>Userlist,String filename)
     {
         try{
             File obj= new File(filename);
             if(obj.createNewFile())
             {
                 System.out.println("File created: "+obj.getName());
             }else
                 System.out.println("File already exists.");
         }catch(IOException e)
         {
             System.out.println("Cannot create file");
             e.printStackTrace();
         }
     }
    public void writefile(ArrayList<Users>list,String filename)
    {
        if(list==null||list.isEmpty())return;
        PrintWriter w=null;
        try{
            w=new PrintWriter(filename);
            for(Users us: list)
            {
                w.println(us);
                w.flush();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            try{
                if(w!=null)w.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public int finduser(String username)
    {
        for(int i=0;i<user.size();i++)
        {
            if(user.get(i).getUsername().equals(username))
            { 
                System.out.println("User exist");
                return i;
            
            }
        }
        System.out.println("no user found");
        return -1;
    }
    public int finduser2(String firstname, String lastname)
    {
        for(int i=0;i<user.size();i++)
        {
            if(user.get(i).getFirstname().equals(firstname)|| user.get(i).getLastname().equals(lastname))
            { 
                System.out.println("User exist");
                System.out.println(user.get(i));
                return i;
            
            }
        }
        System.out.println("no user found");
        return -1;
    }
    public boolean update(String username) throws FileNotFoundException
    {
        int pos=finduser(username);
        int choice;
        if(pos!=-1)
        {
             do{
              System.out.println("1. Update name");
              System.out.println("2. Update password");
              System.out.println("3. Update email");
              System.out.println("4. Update phone number");
              System.out.println("others. Stop");
              Scanner ss=new Scanner(System.in);
              choice=ss.nextInt();
              Users result=user.get(pos);
              switch(choice){
                  
                  case 1:   Scanner sw=new Scanner(System.in);
                      do{
                          System.out.println("Enter first name: ");
                           
                        }while(result.setFirstname(sw.nextLine())==false);
                      
                            Scanner sp=new Scanner(System.in);
                       do{
                                                
                          System.out.println("Enter last name: ");
                     }while( result.setLastname(sp.nextLine())==false);
                            break;
                  case 2: Scanner sl=new Scanner(System.in);
                      do{
                          System.out.println("Enter password: ");
                           
                       }while(result.setPassword(sl.nextLine())==false);
                            
                            break;
               
                  case 3:  Scanner se=new Scanner(System.in);
                       do{
                                                  
                          System.out.println("Enter email: ");
                            
                       }while(result.setEmail(se.nextLine())==false);
                            break;
                  case 4:  Scanner sm=new Scanner(System.in);
                       do{
                          System.out.println("Enter phone number: ");
                            
                       }while(result.setPhone(sm.nextLine())==false);
                            break;
                 
                  default: System.out.println("Successed!!");
                            break;
              }
                 FileDAO.writeUser(user, filename);
                 
                }while(choice<=4&&choice>=1);
             }
          return false;
        }
    public boolean removeuser(String username) throws FileNotFoundException
    {
        int pos=finduser(username);
        if(pos==-1)
          return false;
        else 
        user.remove(pos);
        FileDAO.writeUser(user, filename);
        return true;
    }
   public  String encryppass(String pass)
   {
       try{
           MessageDigest md=MessageDigest.getInstance("MD5");
           md.update(pass.getBytes());
           byte byteData[]=md.digest();
           StringBuilder hexString = new StringBuilder();
           for(int i=0;i<byteData.length;i++)
           {
               String hex=Integer.toHexString(0xff & byteData[i]);
               if(hex.length()==1)
               {
                   hexString.append('0');
                   
               }
               hexString.append(hex);
           }
           return hexString.toString();
       }
       catch(java.security.NoSuchAlgorithmException missing) {
        return pass;
        }
       
    }
   public String decryptmpass(String pass)
   {
       return new String(Base64.getMimeDecoder().decode(pass));
   }
   public String checkpass(String pass)
   {
      return "none";
      
   }
   public void saveaccount(String filename, ArrayList list)
   {
       Path filePath = Paths.get(filename);
            try{
                System.out.println("File Saved");
                Files.write(filePath, list, Charset.defaultCharset());
            }catch(IOException e){
                e.printStackTrace();
            }
      
   
            
    }
   public void sortname(ArrayList<Users> list)
   {
       for(Users us: list)
       { 
           Collections.sort(list,Collections.reverseOrder());
       }       
       
   }
   public void ReadFile ()
   {
    try {
      File myObj = new File("user.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  
        
   }
}

