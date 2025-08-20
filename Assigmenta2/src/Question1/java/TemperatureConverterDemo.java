package Question1.java;

import java.util.Scanner;

public class TemperatureConverterDemo {
   public static void main(String[] args) { 
       
       TemperatureConverter .about(); // called static method
       
       // Object of TemperatureConverter
       TemperatureConverter obj = new TemperatureConverterImplementation();
      
      System.out.println("converting to 30 celcius to Fahrenheit: " + obj.convertToFarenheit(30));
       System.out.println("converting Fahrenheit: to celcius: " + obj.convertToCelsius(60));
       
    
   }

}

