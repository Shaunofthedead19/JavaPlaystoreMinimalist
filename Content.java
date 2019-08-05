
//defining abstract class content
public abstract class Content {

	// declaring instance variables
	private String contentID;
	private String name;
	private int numberOfDownloads;
	private double price;

	// constructor 1
	public Content(String ID, String name, double price) {
		this.contentID = ID;
		this.name = name;
		this.price = price;
		this.numberOfDownloads = 0;
	}

	// constructor 2
	public Content(String ID, String name) {
		this.contentID = ID;
		this.name = name;
		this.price = 0.0;
		this.numberOfDownloads = 0;
	}

	// getting the content ID
	public String getContentID() {
		return this.contentID;
	}

	// getting the content name
	public String getContentName() {
		return this.name;
	}

	// getting the numer of downloads for a content
	public int getContentNumberOfDownloads() {
		return this.numberOfDownloads;
	}

	// getting the price of the content
	public double getContentPrice() {
		return this.price;
	}

	// increasing the number of downloads
	public void addDownload() {
		this.numberOfDownloads++;
	}

	// declaring abstract methods for the class
	public abstract void displayDetails();

	public abstract void addReview(Comment comment);

	public abstract void showReviews();

	public abstract void removeReview(User user);

}
