//import java.math.*;
import java.lang.Math;
import javax.swing.*;
import java.text.DecimalFormat;

public class changeCalculator {
//class-wide variables
static String change;
static double decimalChange;
static double firstDecimalChange=0;

static int whole = 0;
static int iquarters = 0;
static int idimes = 0;
static int inickels = 0;
static int ipennies = 0;

//Creating a function rounding the Decimal into String format
public static String formatDecimal(double number)
{
	double epsilon = 0.004;
	if(Math.abs(Math.round(number)-number)<epsilon)
	{
		return String.format("%10.0f", number);	
	}else
	{
		return String.format("%10.2f", number);
	}
}

public static void main(String args[]){
//inputting the user input into a string, checking for empty string
change = JOptionPane.showInputDialog("How much money do you have?");

//checks to see if the input is a number.
boolean check = true;
while(check){
	try
	{
	Double.parseDouble(change);
	check = false;
	}
	catch(NumberFormatException nfe){
		change = JOptionPane.showInputDialog(null,"Please enter a change amount: ");
	}	
}


/*if (change == null)
		System.exit(0);
	if (change == "")
		{
		JOptionPane.showMessageDialog(null,"Please enter a change amount.");
		System.exit(0);
		}
	*/
//formatting the inputed string into a double (0.00 formatting)
firstDecimalChange = Double.parseDouble(change);
DecimalFormat secondDecimalChange = new DecimalFormat("0.00");
decimalChange = new Double(secondDecimalChange.format(firstDecimalChange)).doubleValue();
if(decimalChange <= 0.00)
	{
	JOptionPane.showMessageDialog(null,"Can't give change for less than $0.00");	
	System.exit(0);	
	}

//Nathan's Awesomely Super Algorithm (NASA)
decimalChange = decimalChange*100;
whole =(int)(decimalChange);

if(decimalChange >= 25){
	iquarters = whole / 25;
	whole = whole % 25;
}
if(whole >= 10){
	idimes = whole / 10;
	whole = whole % 10;
}
if(whole >= 5){
	inickels = whole / 5;
	whole = whole % 5;
}
if(whole >= 1){
	ipennies = whole / 1;
}


JOptionPane.showMessageDialog(null, "You have:\n " +
		"Quarters: "+iquarters+"\n " +
		"Dimes: "+idimes+"\n " +
		"Nickels: "+inickels+"\n" +
		"Pennies: "+ipennies+"\n");
System.exit(0);

}
}
