import java.util.ArrayList;

//defining class book
public class Book extends Publication {

	// declaring instance variables
	private String[] authors;
	private ArrayList<Comment> comments;

	// Constructor 1
	public Book(String ID, String name, double price, String publisher, int numberOfPages, String[] authors) {
		super(ID, name, price, publisher, numberOfPages);
		this.authors = authors;
		this.comments = new ArrayList<Comment>();
	}

	// Constructor 2
	public Book(String ID, String name, String publisher, int numberOfPages, String[] authors) {
		super(ID, name, publisher, numberOfPages);
		this.authors = authors;
		this.comments = new ArrayList<Comment>();
	}

	// getting all authors
	public String[] getAuthors() {
		return authors;
	}

	// getting all the comments
	public ArrayList<Comment> getBookComments() {
		return comments;
	}

	// Adding a comment to the list of comments
	public void addReview(Comment comment) {
		this.getBookComments().add(comment);
	}

	// displaying all the comments
	public void showReviews() {
		for (int i = 0; i < this.getBookComments().size(); i++) {
			System.out.println("\nUser: " + this.getBookComments().get(i).getUser());
			System.out.println("Reply: " + this.getBookComments().get(i).getComment());
		}
	}

	// removing a comment
	public void removeReview(User user) {
		for (int i = 0; i < this.getBookComments().size(); i++) {
			if (this.getBookComments().get(i).getUser() == user)
				this.getBookComments().remove(this.getBookComments().get(i));
		}
	}

	// displaying the details of a book
	public void displayDetails() {
		System.out.println("\n\nID: " + this.getContentID());
		System.out.println("Name: " + this.getContentName());
		System.out.println("Price: " + this.getContentPrice());
		System.out.println("Publisher: " + this.getPublisher());
		System.out.println("No. of Pages: " + this.getNumberOfPages());
		for (int i = 0; i < this.getAuthors().length; i++)// displaying all the details of a book
			System.out.print(this.getAuthors()[i]);
	}

}
