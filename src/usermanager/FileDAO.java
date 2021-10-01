/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.ArrayList;

/**
 *
 * @author trieu
 */
public class FileDAO {
    public static ArrayList<Users> loadUsers(String filename) throws IOException
    {
        FileReader f=null;
        BufferedReader rf=null;
        ArrayList<Users>list=new ArrayList<>();
        try{
            f=new FileReader(filename);
            rf=new BufferedReader(f);
            while(rf.ready())
            {
                String s=rf.readLine();
                String[] arr=s.split(", ");
                if(arr.length==6){
                        Users tmp=new Users(arr[0], arr[1],arr[2],arr[3],arr[4],arr[5]);
                        list.add(tmp);
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            try{
                if(f!=null)f.close();
                if(rf!=null) rf.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return list;
    }
    public static void writeUser(ArrayList<Users> list, String filename) throws FileNotFoundException
    {
        if(list==null||list.isEmpty())return;
        PrintWriter w=null;
       try {
            w=new PrintWriter(filename);
            for(Users us: list)
            {
                w.println(us);
                w.flush();
            }
      
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
           try{
               if(w!=null)w.close();
           }catch(Exception e){
             e.printStackTrace();
           }
       
  
       }
    }
    public static void writeUser2(ArrayList<Users> list, String filename) throws FileNotFoundException
    {
        if(list==null||list.isEmpty())return;
        FileWriter w=null;
       try {
            w=new FileWriter(filename);
            for(Users us: list)
            {
                w.write(filename);
                w.flush();
            }
      
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
           try{
               if(w!=null)w.close();
           }catch(Exception e){
             e.printStackTrace();
           }
       
  
       }
    }
  
    public static void CreateUser( String filename)
    {
         try {
      File myObj = new File(filename);
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
    

}
