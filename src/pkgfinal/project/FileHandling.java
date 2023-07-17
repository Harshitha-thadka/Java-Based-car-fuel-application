/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class FileHandling {
    
    /*
    This method will save the recieved data(as a parameter) in a file with given file name
    */
    public void writeDataInFile(String data, String fileName){
        try {
      FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(data);
            
      myWriter.close();
    } catch (IOException e) { //if any exception occurs during file writing, it is caught and printed on console
      System.out.println("An error occurred while writing writing data to file.");
      e.printStackTrace();
    }
    }
    
    /*
    This will read data from the file with given filename and return the data in string format
    */
    public String readDataFromFile(String fileName){
        String dataReadFromFile="";
         try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        dataReadFromFile = dataReadFromFile+myReader.nextLine()+"\n";
      }
      myReader.close();
    } catch (FileNotFoundException e) {//if any exception occurs during file reading, it is caught and printed on console
      System.out.println("An error occurred while reading from file.");
      e.printStackTrace();
    }
          return dataReadFromFile;
    }
}
