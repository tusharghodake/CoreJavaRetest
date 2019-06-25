package training.demo.model;

public class Addition {

	 int num1;
	 int num2;
	 
	 
	public Addition() {
		super();
	}


	public Addition(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	 
	 public void Addition(int num1,int num2) throws SumIsGreater
	 {
		 int sum=num1+num2;
		 if(sum>100)
			 throw new SumIsGreater("sum is greater than 100");
		 System.out.println(sum);
	 }
}
