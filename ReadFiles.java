import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.util.Arrays; 
import java.io.IOException;


/**
 * 
 * 
 * @elyasse-d
 * @version (0.0.1)
 */

public class ReadFiles {
        //Get Data as array from File
        public static String[] readFile(FileResource fr){
            
            int in = 0,i=0;
            String[] info=new String[8];
            for(String line :fr.lines()){
               
                    switch(in){
                    case 1: info[0]=line;;in=0;break;
                    case 2: info[1]=line;;in=0;break;
                    case 3: info[2]=line;;in=0;break;
                    case 4: info[3]=line;;in=0;break;
                    case 5: info[4]=line;;in=0;break;
                    case 6: info[5]=line;;in=0;break;
                    case 7: info[6]=line;;in=0;break;
                    case 8: info[7]=line;;in=0;break;
                    default:in=0;
                    
                }
                
                if(line.equals("Username")){in =1;continue; };
                if(line.equals("Email Address")){in =2;continue; };
                if(line.equals("First Name")){in =3;continue;}
                if(line.equals("Last Name")){in =4;continue;}
                if(line.equals("Date de naissance")){in =5;continue;}
                if(line.equals("Sexe")){in =6;continue;}
                if(line.equals("TÃ©lÃ©phone")){in =7;continue;}
                if(line.equals("RIB Complet (24 Chiffres)")){in =8;continue;}
                
                }
               return info;   
        }
        //Get the data from multpl files and Storing it
        public void multFile() throws java.io.IOException{
            StorageResource sr = new StorageResource();
            String[] info = new String[8];
            DirectoryResource dr =  new DirectoryResource();
            //The file will be saved as myfile.csv in same folder as this scipt
            BufferedWriter br = new BufferedWriter(new FileWriter("myfile.csv"));
            StringBuilder sb = new StringBuilder();
                for (File f :dr.selectedFiles()){
                    //Open the file
                    FileResource fr = new FileResource(f);
                    //Read array of data from File
                     info = readFile(fr);
                     //Storge The array in csv form in temp Storage but in txt file
                     sr.add(info[0]+","+info[1]+","+info[2]+","+info[3]+","+info[4]+","+info[5]+","+info[6]+","+info[7]);
                     //Collect and append the line of data from temp Storage to finale csv file
                     for(String elem:info){
                         //Write the element
                         sb.append(elem);
                         //Write , to separate itemes
                         sb.append(",");
                        } 
                        //Break the line
                        sb.append("\n");    
                        br.write(sb.toString());
                       
             }
                        //Close the file
                        br.close();
            //Print the collected data to interface
            for(String item : sr.data()) {
                   System.out.println(item);
                  }
                  
                  
               
               
                  
        }
        
    
}
