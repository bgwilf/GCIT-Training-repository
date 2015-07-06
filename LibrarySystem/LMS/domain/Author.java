package domain;

import java.lang.reflect.Method;
import java.util.List;

public class Author {
	
	private int authorId;
	private String authorName;
	private List<Book> books;
	
	
	/**
	 * @return the authorId
	 */
	public int getAuthorId() {
		return authorId;
	}
	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}
	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
/*	
	public static void main(String[] args){
		
		try{
			
			String className = "domain.Author";
			String attrib = "authorName";
			
			Author a = new Author();
			Class c = Class.forName(className);
			Object obj = c.newInstance();
			
			a.setAuthorName("testing");
			Method setter = c.getMethod("set" +attrib.substring(0,1).toUpperCase()+attrib.substring(1, attrib.length()), String.class);
			setter.invoke(obj, "test");
			
			System.out.println(a.getAuthorName());
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}*/
	
	
	
}
