import java.util.ArrayList;

//Defining class magazine
public class Magazine extends Publication {

	// Declaring instance variables
	private int volume;
	private ArrayList<Comment> comments;

	// Constructor 1
	public Magazine(String ID, String name, double price, String publisher, int numberOfPages, int volume) {
		super(ID, name, price, publisher, numberOfPages);
		this.volume = volume;
		this.comments = new ArrayList<Comment>();
	}

	// Constructor 2
	public Magazine(String ID, String name, String publisher, int numberOfPages, int volume) {
		super(ID, name, publisher, numberOfPages);
		this.volume = volume;
		this.comments = new ArrayList<Comment>();
	}

	// getting the vlume of a magazine
	public int getMagazineVolume() {
		return volume;
	}

	// getting the comments on a magazine
	public ArrayList<Comment> getMagazineComments() {
		return comments;
	}

	// adding a comment on a magazine
	public void addReview(Comment comment) {
		comments.add(comment);
	}

	// displaying all comments for a magazine
	public void showReviews() {
		for (int i = 0; i < this.getMagazineComments().size(); i++) {
			System.out.println("\nUser: " + this.getMagazineComments().get(i).getUser());
			System.out.println("Reply: " + this.getMagazineComments().get(i).getComment());
		}
	}

	// removing a comment
	public void removeReview(User user) {
		for (int i = 0; i < this.getMagazineComments().size(); i++) {
			if (this.getMagazineComments().get(i).getUser() == user)
				this.getMagazineComments().remove(this.getMagazineComments().get(i));
		}
	}

	// displaying the details of a magazine
	public void displayDetails() {
		System.out.println("\n\nID: " + this.getContentID());
		System.out.println("Name: " + this.getContentName());
		System.out.println("Price: " + this.getContentPrice());
		System.out.println("Publisher: " + this.getPublisher());
		System.out.println("No. of Pages: " + this.getNumberOfPages());
		System.out.println("Vol.: " + this.getMagazineVolume());
	}

}
