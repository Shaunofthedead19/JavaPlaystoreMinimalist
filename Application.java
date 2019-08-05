import java.util.ArrayList;

//defininf class Application
public class Application extends Content {

	// declaring instance variables
	private OperatingSystem OS;
	private ArrayList<Comment> comments;

	// constructor 1
	public Application(String ID, String name, double price, String OS) {
		super(ID, name, price);
		this.OS = new OperatingSystem(OS);
		this.comments = new ArrayList<Comment>();
	}

	// constructor 2
	public Application(String ID, String name, String OS) {
		super(ID, name);
		this.OS = new OperatingSystem(OS);
		this.comments = new ArrayList<Comment>();
	}

	public OperatingSystem getOS()// getting OS required
	{
		return OS;
	}

	public ArrayList<Comment> getApplicationComments()// getting all the comments for an application
	{
		return comments;
	}

	// defining method to display details of an application
	public void displayDetails() {
		System.out.println("\nID: " + this.getContentID());
		System.out.println("Name: " + this.getContentName());
		System.out.println("Price: " + this.getContentPrice());
		System.out.println("OS: " + this.getOS().getName());
	}

	// defining method to add a comment
	public void addReview(Comment comment) {
		this.getApplicationComments().add(comment);
	}

	// defining method to display all comments
	public void showReviews() {
		for (int i = 0; i < comments.size(); i++) {
			System.out.println("\nUser: " + this.getApplicationComments().get(i).getUser().getUserID());
			System.out.println("Reply: " + this.getApplicationComments().get(i).getComment());
		}
	}

	// defining method to remove a comment mde by a user
	public void removeReview(User user) {
		for (int i = 0; i < this.getApplicationComments().size(); i++) {
			if (this.getApplicationComments().get(i).getUser() == user)
				this.getApplicationComments().remove(this.getApplicationComments().get(i));
		}
	}

}
