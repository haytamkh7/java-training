package appData;

public class BankAccountApp {

	public static void main(String[] args) {
		BankAccount acc1 = new BankAccount("4092817", 5000);
		acc1.setName("Andrie");
		acc1.makeDeposit(10000);
		acc1.accrue();
		System.out.println(acc1.toString());
	}
}

class BankAccount implements IInterest{
	private static int ID = 1000; //Internal custom ID, defined by the bank
	private String accountNumber; //ID + 2 random digit number + first 2 of SSN
	private static final String routingNumber = "9908";
	private String name;
	private String SSN;
	private double balance;      //Amount of the available money in the account
	
	//Constructor
	public BankAccount(String SSN, double initDeposit) {
		this.balance = initDeposit;
		this.SSN = SSN;
		ID++;
		setAccountNumber();
	}
	
	private void setAccountNumber() {
		String twoRanDigit = String.valueOf( (int) (Math.random() * 100) ); 
		String firstTwoSSN = this.SSN.substring(0, 2);
		this.accountNumber = ID + twoRanDigit + firstTwoSSN;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void payBill(double amount) {
		System.out.println("Paying bill: " + amount);
		this.balance -= amount;
		showBalance();
	}
	
	public void makeDeposit(double amount) {
		System.out.println("Making deposit: " + amount);
		this.balance += amount;
		showBalance();
	}
	
	
	public void showBalance() {
		System.out.println("Balance: " + balance);
	}

	@Override
	public void accrue() {
		balance = balance * (1 + rate/ 100);
	}
	
	@Override
	public String toString() {
		return   "[Name: " + name + "]" + "\n" +
				 "[Account Number: " + accountNumber + "]" + "\n" +
				 "[Routing Number: " + routingNumber + "]" + "\n" +
				 "[Balance: " + balance + "]";
	}
}
