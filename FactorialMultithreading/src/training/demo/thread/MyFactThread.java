package training.demo.thread;

import java.util.concurrent.Callable;

public class MyFactThread implements Callable<Integer> {

	private int num;

	public MyFactThread(int num)
	{
		this.num=num;
	}

	@Override
	public Integer call() throws Exception {
		int fact=1;
		for(int i=num;i>=1;i--)
		
			fact=fact*i;
	
		return fact;
	}
	
}
