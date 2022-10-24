package library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class BookManager {
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private ArrayList<Book> bookList = new ArrayList<>();
	private ArrayList<User> userList = new ArrayList<>();
	
	public BookManager() {}
	
	// 메인프린트
	public void printMain() throws NumberFormatException, IOException, ParseException {
		
		int menu = 0;
		
		do {
			System.out.println("-----menu-----");
			System.out.println("1. 도서 관리");
			System.out.println("2. 도서관 이용");
			System.out.println("원하시는 메뉴를 선택해주세요 ^▽^");
			menu = Integer.parseInt(br.readLine());
			
			switch(menu) {
			case 1: libMenu(); break;
			case 2: userMenu(); break;
			default:
				System.out.println("1~2 중 선택해주세요.");
			}
			
		}while(true);
		
		
	}
	
	
	public void libMenu() throws NumberFormatException, IOException, ParseException {
		
		int menu = 0;
		
		System.out.println("-----menu-----");
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 목록");
		System.out.println("3. 도서 수정");
		System.out.println("4. 도서 삭제");
		System.out.println("원하시는 메뉴를 선택해주세요 ^▽^");
		menu = Integer.parseInt(br.readLine());
		
		switch(menu) {
			case 1: addBook(); break;
			case 2: bookList(); break;
			case 3: fixBook(); break;
			case 4: deleteBook(); break;
			default:
				System.out.println("잘못된 입력입니다.");
		}
	}
	
	public void userMenu() throws NumberFormatException, IOException {
		
		int menu = 0;
		
		System.out.println("-----menu-----");
		System.out.println("1. 회원 가입");
		System.out.println("2. 도서 검색");
		System.out.println("3. 도서 대출");
		System.out.println("4. 도서 반납");
		System.out.println("원하시는 메뉴를 선택해주세요 ^▽^");
		menu = Integer.parseInt(br.readLine());
		
		switch(menu) {
			case 1: signUp(); break;
			case 2: searchBook(); break;
			case 3: rentBook(); break;
			case 4: returnBook(); break;
			default:
				System.out.println("1~4 중 선택해주세요.");
		}
	}
	
	
	// 도서등록
	public void addBook() throws IOException, ParseException {
		System.out.println("도서명을 입력해주세요 >>");
		String bookName = br.readLine();
		System.out.println("작가명을 입력해주세요 >>");
		String authorName = br.readLine();
		System.out.println("등록일을 입력해주세요 >>");
		String registerDay = br.readLine();
		Date d = new SimpleDateFormat("yyyyMMdd").parse(registerDay);
		Book b = new Book(bookName, authorName, registerDay);
		bookList.add(b);
		System.out.println("등록이 완료되었습니다.");
	}
	
	// 도서 목록
	public void bookList() {
		for(Book tmp : bookList) {
			System.out.println(tmp);
		}
	}
	
	// 도서 수정
	public void fixBook() throws IOException {
		
		System.out.println("1. 도서명 수정");
		System.out.println("2. 작가명 수정");
		System.out.println("3. 등록일 수정");
		int menu = Integer.parseInt(br.readLine());
		boolean flag = false;
		
		switch(menu) {
			case 1: 
				System.out.println("수정할 도서명 입력 >>");
				String bookName = br.readLine();
				for(Book tmp : bookList) {
					if(tmp.getBookName().equals(bookName)) {
						System.out.println("새로운 도서명을 입력해주세요 >>");
						String newBookName = br.readLine();
						tmp.setBookName(newBookName);
						System.out.println("수정이 완료되었습니다.");
						flag = true;
					}
				}
				break;
			case 2:
				System.out.println("작가명을 수정할 도서명 입력 >>");
				String bookName1 = br.readLine();
				for(Book tmp1 : bookList) {
					if(tmp1.getBookName().equals(bookName1)) {
						System.out.println("새로운 작가명을 입력해주세요 >>");
						String authorName = br.readLine();
						tmp1.setAuthorName(authorName);
						System.out.println("수정이 완료되었습니다.");
						flag = true;
					}
				}
				break;
			case 3:
				System.out.println("등록일을 수정할 도서명 입력 >>");
				String bookName2 = br.readLine();
				for(Book tmp2 : bookList) {
					if(tmp2.getBookName().equals(bookName2)) {
						System.out.println("새로운 등록일을 입력해주세요 >>");
						String registerDay = br.readLine();
						tmp2.setRegisterDay(registerDay);
						System.out.println("수정이 완료되었습니다.");
						flag = true;
					}
				}
				break;
			default:
				System.out.println("1~3 중 선택해주세요.");
		}
		if(flag == false) {
			System.out.println("찾을 수 없습니다. 확인 후 다시 입력해주세요.");
		}
	}
	
	// 도서 삭제
	public void deleteBook() throws IOException {
		System.out.println("삭제하실 도서명을 입력해주세요.");
		String bookName = br.readLine();
		boolean flag = false;
		for(int i=0; i<bookList.size(); i++) {
			if(bookList.get(i).getBookName().equals(bookName)) {
				bookList.remove(i);
				System.out.println("삭제가 완료되었습니다.");
				flag = true;
			}
		}
		if(flag == false) {
			System.out.println("입력하신 도서명이 없습니다.");
		}
	}
	
	// 회원 가입
	public void signUp() throws IOException {
		System.out.println("가입할 회원의 이름을 입력해주세요 >>");
		String name = br.readLine();
		
		for(User user : userList) {
			if(user.getUserName().equals(name)) {
				System.out.println("이미 가입된 회원입니다.");
				return;
			}
		} 
		
		User u = new User(name);
		userList.add(u);
		System.out.println("회원가입이 완료되었습니다.");
	}
	
	// 도서 검색
	public void searchBook() throws IOException {
		
		System.out.println("------검색 메뉴------");
		System.out.println("1. 도서명으로 검색하기");
		System.out.println("2. 저자명으로 검색하기");
		int menu = Integer.parseInt(br.readLine());
		boolean flag = false;
		
		if(menu == 1) {
			System.out.println("도서명을 입력해주세요 >>");
			String bookName = br.readLine();
			for(Book tmp : bookList) {
				if(tmp.getBookName().equals(bookName)) {
					System.out.println(tmp);
					flag = true;
				}
			}
		} else if(menu == 2) {
			System.out.println("저자명을 입력해주세요 >>");
			String authorName = br.readLine();
			for(Book tmp : bookList) {
				if(tmp.getAuthorName().equals(authorName)) {
					System.out.println(tmp);
					flag = true;
				}
			}
		} else {
			System.out.println("1~2 중 선택해주세요.");
		}
		
		if(menu == 1 && flag == false) {
			System.out.println("입력하신 도서를 찾을 수 없습니다.");
		} else if(menu == 2 && flag == false) {
			System.out.println("입력하신 저자를 찾을 수 없습니다.");
		}
	}
	
	// 도서 대출
	public void rentBook() throws IOException {
		System.out.println("회원명을 입력해주세요 >>");
		String userName = br.readLine();
		boolean userFlag = false;
		boolean bookFlag = false;
		boolean rentFlag = false;
		for(User u : userList) {
			if(u.getUserName().equals(userName)) {
				System.out.println("대여할 도서명을 입력해주세요 >>");
				String bookName = br.readLine();
				userFlag = true;
				
				for(Book tmp : bookList) {
					if(tmp.getBookName().equals(bookName)) {
						bookFlag = true;
						if(tmp.isRent() == true) {
							rentFlag = true;
						} else {
						u.insertBook(tmp);
						tmp.setRent(true);
						}
					}
				}
			}
		}
		if(userFlag == false) {
			System.out.println("입력하신 회원을 찾을 수 없습니다.");
		} else if(bookFlag == false) {
			System.out.println("입력하신 도서를 찾을 수 없습니다.");
		} else if(rentFlag == true){
			System.out.println("이미 대출 된 책입니다.");
		}
		
		if(userFlag && bookFlag && !rentFlag) {
			System.out.println("대출이 완료되었습니다.");
		
		}
	}
	
	
	// 도서 반납
	public void returnBook() throws IOException {
		System.out.println("회원 이름을 입력해주세요 >>");
		String userName = br.readLine();
		boolean userFlag = false;
		boolean bookFlag = false;
		boolean rentFlag = false;
		for(User u : userList) {
			if(u.getUserName().equals(userName)) {
				System.out.println("반납할 도서명을 입력해주세요 >>");
				String name = br.readLine();
				userFlag = true;
				
				for(Book b : bookList) {
					if(b.getBookName().equals(name)) {
						bookFlag = true;
						if(b.isRent() == true) {
							u.deleteBook(b);
							b.setRent(false);
						}
					}
				}
			}
		}
		if(userFlag == false) {
			System.out.println("입력하신 회원을 찾을 수 없습니다.");
		} else if(bookFlag == false) {
			System.out.println("입력하신 도서명을 찾을 수 없습니다.");
		}
		
		if(userFlag && bookFlag && !rentFlag) {
			System.out.println("반납이 완료되었습니다.");
		}
	}
	

}
