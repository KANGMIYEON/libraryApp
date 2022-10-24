package library;

import java.util.ArrayList;

public class User {
	
	private String userName;
	private ArrayList<Book> rentalList = new ArrayList<>();
	private ArrayList<Book> rentalHistory = new ArrayList<>();
	
	public User () {}
	
	public User(String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ArrayList<Book> getRentalList() {
		return rentalList;
	}

	public void setRentalList(ArrayList<Book> rentalList) {
		this.rentalList = rentalList;
	}

	public ArrayList<Book> getRentalHistory() {
		return rentalHistory;
	}

	public void setRentalHistory(ArrayList<Book> rentalHistory) {
		this.rentalHistory = rentalHistory;
	}
	
	public void insertBook(Book book) {
		rentalList.add(book);
		rentalHistory.add(book);
	}
	
	public void deleteBook(Book book) {
		rentalList.remove(book);
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", rentalList=" + rentalList + ", rentalHistory=" + rentalHistory + "]";
	}

	
	

	
	


	
	

}
