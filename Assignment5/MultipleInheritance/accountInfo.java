class Account {
	private String CustomerName;
	private Integer AccountNumber;

	public String getData(){
		return "NAME: " + CustomerName + "\nACCOUNT NUMBER: " + AccountNumber.toString();
	}

	public void putData(String CustomerName, Integer AccountNumber){
		this.CustomerName = CustomerName;
		this.AccountNumber = AccountNumber;
	}
}

class savingAccount extends Account {
	private Double MinimumBalance;
	private Double SavingsBalance;

	public String getData(){
		return super.getData() + "\nMIN BALANCE: " + this.MinimumBalance + "\nSAVINGS BALANCE: " + this.SavingsBalance;
	}

	public void putData(String CustomerName, Integer AccountNumber, Double MinimumBalance, Double SavingsBalance){
		super.putData(CustomerName, AccountNumber);
		
		this.MinimumBalance = MinimumBalance;
		this.SavingsBalance = SavingsBalance;
	}
}

class accountDetail extends savingAccount {
	private Integer Deposits;
	private Integer Withdrawals;

	public String getData(){
		return super.getData() + "\nDEPOSITS: " + this.Deposits + "\nWITHDRAWALS: " + this.Withdrawals;
	}	

	public void putData(String CustomerName, Integer AccountNumber, Double MinimumBalance, Double SavingsBalance, Integer Deposits, Integer Withdrawals){
		this.Deposits = Deposits;
		this.Withdrawals = Withdrawals;

		super.putData(CustomerName, AccountNumber, MinimumBalance, SavingsBalance);
	}
}

class accountInfo {
	public static void main(String[] args){
		accountDetail account = new accountDetail();
		account.putData("ANKIT DAS", 1907023, 100.0, 100000.0, 56, 25);

		System.out.println(account.getData());
	}
}
