
//defining class Comment
public class Comment {
	
	//declaring the instance variables
	private User user;
	private String comment;

	//Defining constructor
	public Comment(User user, String comment) {
		this.user = user;
		this.comment = comment;
	}
	
	//getting the comment
	public String getComment()
	{
		return comment;
	}
	
	//gettin the user who made the comment
	public User getUser()
	{
		return user;
	}

}
