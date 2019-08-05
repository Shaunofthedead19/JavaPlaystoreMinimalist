import java.util.*;

public class PlayStoreMain {

	public static void main(String[] args) throws InsufficientFunds {

		// declaring variables and objects
		Scanner input = new Scanner(System.in);
		PlayStore store = new PlayStore();
		User user;
		Content content;

		// hard Coded
		// new publications
		System.out.println("Running hard-coded lines");
		String[] authors1 = { "L. Tolstoy" };
		Book b1 = new Book("b1", "War and Peace", 12.55, "The Russian Messenger", 1225, authors1);

		String[] authors2 = { "F. Scott Fitzgerald" };
		Book b2 = new Book("b2", "The great gatsby", 10, "Charles Scribner's Sons", 180, authors2);

		String[] authors3 = { "Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein" };
		Book b3 = new Book("b3", "Introduction to algorithms", 100, "MIT Press", 1312, authors3);

		Magazine m1 = new Magazine("m1", "Forbes", 8.99, "Forbes Media", 50, 201904);

		// adding publications to playstore
		store.addContent(b1);
		store.addContent(b2);
		store.addContent(b3);
		store.addContent(m1);

		// new Applications
		Application g1 = new Application("g1", "Pokemon", 5.3, "androidV4");
		Application g2 = new Application("g2", "Pokemon", 5, "iOSV10");
		// a free app
		Application app1 = new Application("app1", "Calendar", "androidV3");

		// Adding Applications to playstore
		store.addContent(g1);
		store.addContent(g2);
		store.addContent(app1);

		// Adding new users
		User u1 = new User("u1", "John Doe", "0412000", 200);
		User u2 = new User("u2", "Mary Poppins", "0433191");
		User u3 = new User("u3", "Dave Smith", "0413456", 1000);
		User u4 = new User("u4", "Jackie Chan", "0417654");

		store.addUser(u1);
		store.addUser(u2);
		store.addUser(u3);
		store.addUser(u4);

		// Adding new comments
		Comment comment1 = new Comment(u1, "This is a fantastic game!");
		g1.addReview(comment1);

		Comment comment2 = new Comment(u2, "I never liked this game!");
		g1.addReview(comment2);

		g1.addReview(new Comment(u3, "The game crashes frequently"));

		b1.addReview(new Comment(u2, "I love Tolstoy!"));

		// Simulating transactions, showing content, comments etc etc.
		// They can be driven by menu input as well.
		u1.buyContent(b1);
		u1.buyContent(b3);
		u1.buyContent(m1);

		u4.buyContent(g1);
		u4.becomePremium(input);
		u4.buyContent(m1);

		// calling function to turn premium
		u2.becomePremium(input);

		u2.buyContent(b1);
		u2.buyContent(g1);

		String userID;
		String contentID;

		// catching exceptions
		// Main Menu
		do {

			try {
				// Options
				System.out.println(
						"PlayStore Menu:\n1. Upgrading a Member to Premium Account.\n2. Purchasing One Item for One User.\n3. Listing available Contents.\n4. Showing All purchased Items of a User.\n5. Showing all Comments of a content.");
				System.out.println(
						"6. Add a New User.\n7. Remove Existing User.\n8. Display Users.\n9. Remove a comment.\n10. Exit");

				// user choice
				int choice = input.nextInt();

				// taking appropriate action
				switch (choice) {

				case 1:
					System.out.println("Enter user ID: ");
					userID = input.next();// entering user's ID
					user = store.searchUser(userID);// calling method to identify user
					user.becomePremium(input);// calling method to convert user to premium member
					break;

				case 2:
					System.out.println("Enter user ID: ");
					userID = input.next();// entering user's ID
					System.out.println("Enter content ID: ");
					contentID = input.next();// entering content ID
					user = store.searchUser(userID);// calling method to identify user
					content = store.searchContent(contentID);// calling method to identify content
					user.buyContent(content);// calling method to buy the content for the user
					break;

				case 3:
					do {

						// Content Menu
						System.out.println(
								"Enter the type of content you want to see:\n1. Applications\n2. Books\n3. Magazines\n4. All Contents\n5. Back\n6. Exit");

						choice = input.nextInt();// User's choice

						// Taking appropriate action
						switch (choice) {
						case 1:
						case 2:
						case 3:
						case 4:
							store.showContent(choice);// calling the appropriate implementation of abstract method.
							break;
						case 5:
							System.out.println("Moving to previous Menu..");// going back.
							break;
						case 6:
							System.out.println("Quitting..");// quitting the program
							System.exit(0);// exiting
							break;
						default:
							System.out.println("Choose Appropriately");
							break;

						}

					} while (choice != 5);// to exit the menu
					break;

				case 4:
					System.out.println("Enter user ID: ");
					userID = input.next();
					user = store.searchUser(userID);// finding user
					user.displayUserLibrary();// calling method to display the content he purchased
					break;

				case 5:
					System.out.println("Enter content ID: ");
					contentID = input.next();
					content = store.searchContent(contentID);// identifying content
					content.showReviews();// calling method to display the comments about the content
					break;

				case 6:
					System.out.println("Adding a New User: ");
					store.inputUser(input);// adding a new user
					break;

				case 7:
					System.out.println("Enter the userID of the user you want to remove: ");
					userID = input.next();
					user = store.getUser();
					user = store.searchUser(userID);// identifying user
					store.removeUser(user);// calling method to remove user from play store.
					break;

				case 8:
					store.showUsers();// calling method to display all the users in playstore
					break;

				case 9:
					System.out.println("Enter the userID of the user whose comment you want to remove: ");// asking for
																											// userID
					userID = input.next();
					user = store.getUser();
					user = store.searchUser(userID);// identifying user
					System.out.println("Enter the content ID: ");
					contentID = input.next();
					content = store.getContent();
					content = store.searchContent(contentID);// identifying content
					content.removeReview(user);// calling method to remove the comment made by user on a content
					break;

				case 10:
					System.out.println("Quitting..");
					System.exit(0);// exiting
					break;

				default:
					System.out.println("Please enter the appropriate choice");// prompting the use to enter an
																				// appropriate choice
					break;

				}

			}

			catch (NullValueReturned e)// handling null values
			{
				System.out.println(e.getReason());
			}

			catch (InsufficientFunds e)// handling insufficient funds
			{
				System.out.println(e.getReason());
			} catch (InputMismatchException e) {
				System.out.println("Error: Enter Appropriate Value Please.");
				input.next();
			}

		} while (true);

	}

}
