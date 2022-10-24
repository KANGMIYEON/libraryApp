package library;

public class Book {

	private String bookName;
	private String authorName;
	private String registerDay;
	private String condition;
	private boolean isRent;
	
	public Book() {}

	public Book(String bookName, String authorName, String registerDay) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.registerDay = registerDay;
	}
	
	
	
	public boolean isRent() {
		return isRent;
	}

	public void setRent(boolean isRent) {
		this.isRent = isRent;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getRegisterDay() {
		return registerDay;
	}

	public void setRegisterDay(String registerDay) {
		this.registerDay = registerDay;
	}

	@Override
	public String toString() {
		return "도서명: " + bookName + ", 작가명: " + authorName + ", 등록일: " + registerDay;
	}
	
	
	
	
}
