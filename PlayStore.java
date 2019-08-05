
//You may need the following packages
//import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Scanner;

//defining class PlayStore
public class PlayStore {

	// Instance variables that you need.
	// They must all be marked as private
	private ArrayList<Content> contents;
	private ArrayList<User> users;
	private User user;
	private Content content;

	// Declare a private variable (array or similar) to store your Content objects
	// here

	// Declare a private variable (array or similar) to store your User objects here

	// defining constructor
	public PlayStore() {
		// any code you need here
		this.contents = new ArrayList<Content>();
		this.users = new ArrayList<User>();
	}

	// method to add a content to the PlayStore
	public void addContent(Content content) {
		// add the content into your content list
		this.contents.add(content);
	}

	// method to add a user to the PlayStore
	public void addUser(User user) {
		// add the user to your list of users
		this.users.add(user);
	}

	// getting contents
	public ArrayList<Content> getContents() {
		return this.contents;
	}

	// getting users
	public ArrayList<User> getUsers() {
		return this.users;
	}

	// getting a single user
	public User getUser() {
		return this.user;
	}

	// getting a single content
	public Content getContent() {
		return this.content;
	}

	// method to search for a user
	public User searchUser(String userID) throws NullValueReturned {
		for (int i = 0; i < this.users.size(); i++)// iterating through the list of users
			if (this.users.get(i).getUserID().equals(userID))// checking if user exist
				return this.users.get(i);
		throw new NullValueReturned("No User with this ID is present in the playstore.");// handling missing object
	}

	public boolean checkUser(String userID) {

		for (int i = 0; i < this.users.size(); i++)// iterating through the list of users
			if (this.users.get(i).getUserID().equals(userID))// checking if user exist
			{
				System.out.println("A user with this ID already exists. Try again.");
				return true;
			}
		return false;

	}

	// method to search for a content
	public Content searchContent(String contentID) throws NullValueReturned {
		for (int i = 0; i < this.contents.size(); i++)// iterating through the list of users
			if (this.getContents().get(i).getContentID().equals(contentID))// checking if user exist
				return this.getContents().get(i);
		throw new NullValueReturned("No Content with this ID is present in the playstore.");
	}

	public void inputUser(Scanner input) {
		System.out.println("Enter userID: ");// asking for new user's ID
		String userID = input.next();
		input.nextLine();// shifting to next line to accommodate more info

		System.out.print("\nEnter userName: ");// asking user Name
		String userName = input.nextLine();

		System.out.println("\nEnter phoneNo: ");// asking phone no.'s
		String phoneNo = input.next();
		input.nextLine();

		if (checkUser(userID) != true) {
			System.out.println("\ndo you want to enter initial balance? (Y/N):");// asking if user wants to keep a
																					// initial balance in account
			String choice = input.next();

			if (choice.equals("y") || choice.equals("Y")) {
				System.out.println("\nEnter user's balance: ");// asking for balance
				Double balance = input.nextDouble();
				this.user = new User(userID, userName, phoneNo, balance);// calling one of the constructors
			}
			this.user = new User(userID, userName, phoneNo);// calling the other constructor
			addUser(user);
		}

	}

	// method to remove a user
	public void removeUser(User user) {
		users.remove(user);// removing user from list of users
	}

	// method to display details of contents base on choice
	public void showContent(int choice) {
		// add your code here

		// displaying the kind of content or all of it based on choice
		switch (choice) {
		case 1:
			System.out.println("\n\nAvailable Applications: ");

			for (int i = 0; i < contents.size(); i++) {

				if (this.getContents().get(i).getClass().getName() == "Application")// Displaying available Applications
					this.getContents().get(i).displayDetails();

			}
			break;
		case 2:
			System.out.println("\n\nAvailable Books: ");

			for (int i = 0; i < this.getContents().size(); i++) {

				if (this.getContents().get(i).getClass().getName() == "Book")// Displaying available Books
					this.getContents().get(i).displayDetails();

			}
			break;
		case 3:
			System.out.println("\n\nAvailable Magazines: ");

			for (int i = 0; i < this.getContents().size(); i++) {

				if (this.getContents().get(i).getClass().getName() == "Magazine")// Displaying available Magazines
					this.getContents().get(i).displayDetails();

			}
			break;
		case 4:
			System.out.println("\nPlayStore Contents: ");

			// Displaying all the contents of the store.
			for (int i = 0; i < this.getContents().size(); i++) {
				this.getContents().get(i).displayDetails();
			}
			break;
		}

	}

	// displaying details of all the users in PlayStore
	public void showUsers() {
		for (int i = 0; i < this.getUsers().size(); i++)
			this.getUsers().get(i).displayUserDetails();
	}

	// possible methods here

}
