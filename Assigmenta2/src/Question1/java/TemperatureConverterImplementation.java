package Question1.java;

public  class TemperatureConverterImplementation implements  TemperatureConverter {

	@Override
public double convertToFarenheit(double celsius) {
		// TODO Auto-generated method stub
		return (celsius * 9/5 ) + 32;
	}

  @Override
public double convertToCelsius(double Farenheit) {
 // TODO Auto-generated method stub
		return (Farenheit -32) *5 /9;
    }

}
