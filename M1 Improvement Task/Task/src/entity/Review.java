package entity;

public class Review 
{
	private String username;
	private int rating;
	private String comment;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(String username, int rating, String comment) {
		super();
		this.username = username;
		this.rating = rating;
		this.comment = comment;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}