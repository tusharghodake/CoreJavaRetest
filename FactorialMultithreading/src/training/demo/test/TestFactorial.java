package training.demo.test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import training.demo.thread.MyFactThread;

public class TestFactorial {

	public static void main(String[] args) {
		
		ExecutorService ser=Executors.newFixedThreadPool(3);
		ArrayList<Integer> alist=new ArrayList<>();
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String ans=null;
		do
		{
			System.out.println("Enter Number:");
			int num=sc.nextInt();
			alist.add(num);
			System.out.println("Do u want to continue(y/n)?");
			ans=sc.next();
			
		}while(ans.equals("y"));
	
		ArrayList<Future<Integer>> flist=new ArrayList<>();
		
		for(int n:alist)
		{
			Future<Integer> e=ser.submit(new MyFactThread(n));
			flist.add(e);
		}
		
		int i=0;
		for(int n:alist)
		{
			try {
				System.out.println("Factorial of a number "+n+" is:"+flist.get(i++).get());
			} catch (InterruptedException | ExecutionException e) {
				
				e.printStackTrace();
			}
		}
	}

}
