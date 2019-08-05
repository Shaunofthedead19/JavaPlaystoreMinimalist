
//defining abstract class publication
public abstract class Publication extends Content {

	// declaring instance variables
	private String publisher;
	private int numberOfPages;

	// constructor 1
	public Publication(String ID, String name, double price, String publisher, int numberOfPages) {
		super(ID, name, price);
		this.publisher = publisher;
		this.numberOfPages = numberOfPages;
	}

	// constructor 2
	public Publication(String ID, String name, String publisher, int numberOfPages) {
		super(ID, name);
		this.publisher = publisher;
		this.numberOfPages = numberOfPages;
	}

	// getting the publisher
	public String getPublisher() {
		return publisher;
	}

	// getting the number of pages for publication
	public int getNumberOfPages() {
		return numberOfPages;
	}

}
