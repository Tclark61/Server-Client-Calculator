import java.io.*;
import java.util.*;
/*
Programmer: Tyler Clark
CNT4704
10/20/2017

*/

import java.lang.*;
import java.math.*;
import java.net.*;

public class CalcProtocol{
	
	
	public String answer(String theInput){
		
		if(theInput == "0/0"){
			return null;
		}
		int length = theInput.length();
		int digitLength = 0, startPoint = -1,numberIn = 0,OperatorLim = 0;
		double[] numbers = new double[2];
		char operator = 'a';
		if(!Character.isDigit(theInput.charAt(0))){
			return "Invalid question! Please enter the math question again.";
		}
		for(int i = 0; i < length; i++){
			if(Character.isDigit(theInput.charAt(i)) || theInput.charAt(i) == '.'){
				if(startPoint == -1)
					startPoint = i;
				digitLength++;
			}
			//If it's not a digit, it's the operating symbol
			else{
				if(theInput.charAt(i) == '+' || theInput.charAt(i) == '-' || theInput.charAt(i) == '*' || theInput.charAt(i) == '/'){
					numbers[numberIn] = Double.parseDouble(theInput.substring(startPoint,i));
					//System.out.println("Number " + numberIn + ": " + numbers[numberIn]);
					startPoint = -1;
					digitLength = 0;
					operator = theInput.charAt(i);
					numberIn++;
					OperatorLim++;
				}
				else{
					return "Invalid question! Please enter the math question again.";
				}
			}
		}
		//List the possible errors since I don't know how to just look for crashes the right way
		if(numberIn > 1 || !Character.isDigit(theInput.charAt(length - 1)) || OperatorLim != 1 ){
			return "Invalid question! Please enter the math question again.";
		}
		numbers[numberIn] = Double.parseDouble(theInput.substring(startPoint,length));
		//System.out.println("Number " + numberIn + ": " + numbers[numberIn]);
		switch(operator){
			case '+': return Double.toString((numbers[0] + numbers[1]));
			
			case '-': return Double.toString((numbers[0] - numbers[1]));
			
			case '/': return Double.toString((numbers[0] / numbers[1]));
			
			case '*': return Double.toString((numbers[0] * numbers[1]));
		}
		//Something went terribly wrong
		return null;
	}
}