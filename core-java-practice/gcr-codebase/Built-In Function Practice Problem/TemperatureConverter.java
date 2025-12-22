import java.util.Scanner;
class TemperatureConverter{

static Scanner input = new Scanner(System.in);

static double fahrenheitToCelsius(double fahrenheit){
return (fahrenheit - 32) * 5 / 9;
}

static double celsiusToFahrenheit(double celsius){
return (celsius * 9 / 5) + 32;
}

static double inputDouble(){
double temperature = input.nextDouble();
return temperature;
}

public static void main(String[] args){
System.out.print("Celsius or Fahrenheit ? :");
String temperature = input.nextLine();
System.out.print("Temperature : ");
double temp = inputDouble();
double result;
if(temperature.equals("celsius") || temperature.equals("Celsius")){
result = celsiusToFahrenheit(temp);
System.out.println(temp +" in Celsius will be "+result +" in Fahrenheit");
}
else if(temperature.equals("fahrenheit") || temperature.equals("Fahrenheit")){
result = fahrenheitToCelsius(temp);
System.out.println(temp +" in Fahrenheit will be "+result +" in Celsius");
}
else{
System.out.println("Invalid");
}

}


}