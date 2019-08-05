
public class InsufficientFunds extends Exception {// defining class to detect insufficient funds

	private String reason;

	public String getReason() {// calling the reason
		return this.reason;
	}

	public InsufficientFunds(String reason)// called to handle exception
	{
		this.reason = reason;
	}

}
