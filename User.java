import java.util.Scanner;
import java.util.ArrayList;

//defining CLass User
public class User {

	// declaring instance variables
	private String userID;
	private String name;
	private String phoneNo;
	private double balance;
	private ArrayList<Content> userLibrary;
	private boolean isPremium;
	private float discount;
	Scanner input = new Scanner(System.in);

	// constructor 1
	public User(String ID, String name, String phoneNo, double balance) {
		this.userID = ID;
		this.name = name;
		this.phoneNo = phoneNo;
		this.balance = balance;
		this.userLibrary = new ArrayList<Content>();
		this.isPremium = false;
		this.discount = 0;
	}

	// constructor 2
	public User(String ID, String name, String phoneNo) {
		this.userID = ID;
		this.name = name;
		this.phoneNo = phoneNo;
		this.balance = 500.0;
		this.userLibrary = new ArrayList<Content>();
		discount = 0;
	}

	// getting User ID
	public String getUserID() {
		return this.userID;
	}

	// getting user name
	public String getUserName() {
		return this.name;
	}

	// getting user's phone no
	public String getUserPhoneNo() {
		return this.phoneNo;
	}

	// getting user's balance
	public Double getUserBalance() {
		return this.balance;
	}

	// getting the contents bought by user
	public ArrayList<Content> getUserLibrary() {
		return this.userLibrary;
	}

	// getting the IsPremium attribute
	public boolean getIsUserPremium() {
		return this.isPremium;
	}

	// getting the user's discount
	public float getUserDiscount() {
		return this.discount;
	}

	// method to make a user's account premium
	public void becomePremium(Scanner input) throws InsufficientFunds {

		System.out.println("Are you sure about becoming a premium member? (Y/N)");// Confirming user choice
		String choice = input.next();
		switch (choice) {
		case "Y":
		case "y":
			if (this.isPremium != true) {// Checking if user is already premium
				if (this.balance >= 100) {
					this.balance -= 100;
					this.isPremium = true;
					this.discount = 20;
					System.out.println("The user is now a Premium account holder.");
				} else
					throw new InsufficientFunds("Insufficient funds");// throws exception if there are insufficient
																		// funds
			} else
				System.out.println("\nThe user already has a premium account!");
			break;
		case "N":
		case "n":
			System.out.println("Never Mind.");
			break;
		default:
			System.out.println("Invalid input");
			break;
		}

	}

	public boolean userContentCheck(Content content) {
		for (int i = 0; i < this.userLibrary.size(); i++)// iterating through the list of users
			if (this.getUserLibrary().get(i).getContentID().equals(content.getContentID()))// checking if user exist
			{
				System.out.println("The user already has this content");
				return true;
			}
		return false;
	}

	// method to buy content for a user
	public void buyContent(Content content) throws InsufficientFunds {
		System.out.println("Downloading this Application may incur charges. Do you wish to continue? (Y/N)");
		String choice = input.next();
		switch (choice) {
		case "Y":
		case "y":
			if (this.userContentCheck(content) != true) {
				// checking if user is a premium member
				if (this.isPremium == true) {
					// checking is premium user has sufficient funds
					if (this.balance > (content.getContentPrice()
							- ((this.discount * content.getContentPrice()) / 100))) {
						this.balance -= (content.getContentPrice()
								- ((this.discount * content.getContentPrice()) / 100));
						this.userLibrary.add(content);
						content.addDownload();
					} else
						throw new InsufficientFunds("Insufficient funds");
				} else {
					// checking is non-premium user has sufficient funds
					if (this.balance > content.getContentPrice()) {
						this.balance -= content.getContentPrice();
						this.userLibrary.add(content);
						content.addDownload();
						;
					} else
						throw new InsufficientFunds("Insufficient funds");
				}
			}
			break;
		case "n":
		case "N":
			System.out.println("Transaction Cancelled");
			break;
		default:
			// prompting to choose again if choice was invalid
			System.out.println("Invalid Choice. Choose again: ");
			break;
		}
	}

	// displaying the contents of a user's library
	public void displayUserLibrary() throws NullValueReturned {
		if (this.userLibrary.size() > 0)
			for (int i = 0; i < this.userLibrary.size(); i++)
				this.userLibrary.get(i).displayDetails();
		throw new NullValueReturned("The User Library is empty! User has not purchased anything.");

	}

	// displaying the details of a user
	public void displayUserDetails() {
		System.out.println("\nUserID: " + this.userID);
		System.out.println("UserName: " + this.name);
		System.out.println("Phone No.: " + this.phoneNo);
		if (this.isPremium == true)
			System.out.println(this.name + " is a Premium Account Holder!");
	}

}
