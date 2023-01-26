import java.lang.Thread;

class mainThread extends Thread{
	private int basicSalary;
	private int finalSalary;
	private int paymentPerDay;
	private int numberOfDays;
	private int allowance;
	private int epf;

	public mainThread(int paymentPerDay, int numberOfDays){
		this.paymentPerDay = paymentPerDay;
		this.numberOfDays = numberOfDays;
	}

	public void run(){
		try{
		basicSalary = paymentPerDay*numberOfDays;
		System.out.println("BasicSalary: "+basicSalary);
		thread1 t1 = new thread1(basicSalary);
		thread2 t2 = new thread2(paymentPerDay);
		t1.start();
		t2.start();
		t1.sleep(100);
		t2.sleep(100);
		if(t1.isAlive() == false && t2.isAlive() == false){
			allowance = t1.getAllowance();
			epf = t2.getEPF();
			finalSalary = basicSalary+allowance+epf;
			System.out.println("Final Employee Salary: "+finalSalary);
		}
		}
		catch(InterruptedException e){}
	}
}

class thread1 extends Thread{
	private int basicSalary;
	private int allowance;

	public thread1(int basicSalary){
		this.basicSalary = basicSalary;
	}

	public int getAllowance(){
		return allowance;
	}

	public void run(){
		allowance = basicSalary*5/100;
		System.out.println("Allowance: "+allowance);
	}
}

class thread2 extends Thread{

	private int paymentPerDay;
	private int epf;

	public thread2(int paymentPerDay){
		this.paymentPerDay = paymentPerDay;
	}

	public int getEPF(){
		return epf;
	}

	public void run(){
		epf = (paymentPerDay*30*12/100)-(paymentPerDay*30*8/100);
		System.out.println("EPF : "+epf);
	}
}

public class c5{
	public static int paymentPerDay = 5000;
	public static int numberOfDays = 15;
	
	public static void main(String[] args){
		mainThread mt = new mainThread(paymentPerDay,numberOfDays);
		System.out.println("Algorith used for calculating the Final Salary");
		System.out.println("----------------------------------------------");
		System.out.println("Basic Salary = Per Day Payment * Number of Days");
		System.out.println("Allowance = 5% of Basic Salary");
		System.out.println("EPF = (12% of PerDayPayment*30) - (8% of PerDayPayment*30)");
		System.out.println("Final Salary = Basic salary + Allowance + EPF");
		System.out.println("PerDayPayment :5000");
		System.out.println("Number of Days :15");
		System.out.println("----------------------------------------------");
		mt.start();
	}
}
