package Question1.java;

public interface TemperatureConverter {

   public double convertToFarenheit(double celsius);
   
   public double convertToCelsius(double Farenheit); 

   public static void  about(){
	      System.out.println("We are  converting the farenheit to celsius  and we also converting a celsius to farenherit");
   }

}
