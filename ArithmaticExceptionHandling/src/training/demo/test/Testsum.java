package training.demo.test;

import java.util.Scanner;

import training.demo.model.Addition;
import training.demo.model.SumIsGreater;

public class Testsum {

	public static void main(String[] args) throws SumIsGreater {
		
		Addition a=new Addition(); 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Num1:");
		int num1=sc.nextInt();
		
		System.out.println("Enter Num2:");
		int num2=sc.nextInt();
		
		a.Addition(num1, num2);
	}

}
