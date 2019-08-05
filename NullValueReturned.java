
public class NullValueReturned extends Exception {// defining class to handle null values returned

	private String reason;

	public String getReason() {// calling reason for invocation
		return this.reason;
	}

	public NullValueReturned(String reason) {// called to handle exception
		this.reason = reason;
	}

}
