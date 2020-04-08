package cit285.project.domain;

public class Books {
	
	private int bookId;
	private String authorFName;
	private String authorLName;
	private String isbn;
	private String title;
	private String editor;
	private String edition;
	private Integer year;
	private Integer price;

	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getAuthorFName() {
		return authorFName;
	}
	
	public void setAuthorFName(String authorFName) {
		this.authorFName = authorFName;
	}
	
	public String getAuthorLName() {
		return authorLName;
	}
	
	public void setAuthorLName(String authorLName) {
		this.authorLName = authorLName;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getEditor() {
		return editor;
	}
	
	public void setEditor(String editor) {
		this.editor = editor;
	}
	
	public String getEdition() {
		return edition;
	}
	
	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
