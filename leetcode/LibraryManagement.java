
import java.util.ArrayList;
import java.util.List;

/*
Design a library system with:
- Book (title, author, ISBN, availability status)
- Member (name, memberID, list of borrowed books)
- Library (manages books and members)

Include methods to borrow books, return books, search books by title/author.
Handle book availability and member borrowing limits.
*/

class Book
{
    private String	title;
    private String	author;
    private String	isbn;
    private boolean	isAvailable;

    public Book(String title, String author, String isbn)
	{
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.isAvailable = true;
    }
    
    public String getTitle()
	{
		return (title);
	}

	public String getAuthor()
	{
		return (author);
	}

	public String getIsbn()
	{
		return (isbn);
	}

	public boolean availability()
	{
		return (isAvailable);
	}

	public void borrowedBook()
	{
		isAvailable = false;
	}

	public void returnedBook()
	{
		isAvailable = true;
	}

}

class Member
{
    private String	name;
    private String	memberID;
	private int		borrowLimit;
    private List<Book> borrowedBooks;
    
    Member(String name, String memberID, int borrowLimit)
	{
		borrowedBooks = new ArrayList<>();
		this.name = name;
		this.borrowLimit = borrowLimit;
		this.memberID = memberID;
	}

	public String getName()
	{
		return (name);
	}

	public String getMemberID()
	{
		return (memberID);
	}

	public int getBorrowLimit()
	{
		return (borrowLimit);
	}

	public void addBorrowedBooks(Book book)
	{
		borrowedBooks.add(book);
	}

	public void removeBorrowedBook(Book book)
	{
		borrowedBooks.remove(book);
	}

	public int getBorrowedAmount()
	{
		return (borrowedBooks.size());
	}
}

class Library
{
    private List<Book> books;
    private List<Member> members;

    public Library()
	{
		books = new ArrayList<>();
		members = new ArrayList<>();
	}

	public void	addBook(Book book)
	{
		books.add(book);
	}

	public void addMember(Member member)
	{
		members.add(member);
	}

	private Book FindBookIsbn(String isbn)
	{
		for (Book book : books)
		{
			if (book.getIsbn().equals(isbn))
				return (book);
		}

		return (null);
	}

	private Member FindMemberID(String memberID)
	{
		for (Member member : members)
		{
			if (member.getMemberID().equals(memberID))
				return (member);
		}

		return (null);
	}

	public void borrowBook(String isbn, String memberID)
	{
		Book book = FindBookIsbn(isbn);
		Member member = FindMemberID(memberID);

		if (book == null || member == null)
			throw new IllegalArgumentException();

		if (!book.availability())
			throw new IllegalArgumentException();

		if (member.getBorrowedAmount() >= member.getBorrowLimit())
			throw new IllegalArgumentException();
		
		member.addBorrowedBooks(book);
		book.borrowedBook();
	}

	public void returnBook(String isbn, String memberID)
	{
		Book book = FindBookIsbn(isbn);
		Member member = FindMemberID(memberID);

		if (book == null || member == null)
			throw new IllegalArgumentException();

		book.returnedBook();
		member.removeBorrowedBook(book);
	}

	public Book SearchBook(String title, String author)
	{
		for (Book book : books)
		{
			if (book.getTitle().equals(title) && book.getAuthor().equals(author))
				return (book);
		}

		return (null);
	}

}

// Main with all needed Test cases setup by Claude AI

public class LibraryManagement
{
	public static void main(String[] args)
	{
		Library library = new Library();

		library.addBook(new Book("Clean Code", "Robert Martin", "ISBN001"));
		library.addBook(new Book("Java Guide", "John Smith", "ISBN002"));
		library.addBook(new Book("Clean Code", "Different Author", "ISBN003"));
		
		library.addMember(new Member("Alice", "M001", 2));
		library.addMember(new Member("Bob", "M002", 1));
		
		System.out.println("=== Library Setup Complete ===");
		
		try
		{
			library.borrowBook("ISBN001", "M001");
			System.out.println("Alice borrowed Clean Code by Robert Martin");
		}
		catch (Exception e)
		{
			System.out.println("Borrow failed: " + e.getMessage());
		}

		try
		{
			library.borrowBook("ISBN001", "M002");
			System.out.println("Bob borrowed Clean Code");
		}
		catch (Exception e)
		{
			System.out.println("Bob cannot borrow: Book unavailable");
		}
		
		try
		{
			library.borrowBook("ISBN003", "M002");
			System.out.println("Bob borrowed Clean Code by Different Author");
		}
		catch (Exception e)
		{
			System.out.println("Borrow failed: " + e.getMessage());
		}

		try
		{
			library.borrowBook("ISBN002", "M002");
			System.out.println("Bob borrowed Java Guide");
		}
		catch (Exception e)
		{
			System.out.println("Bob cannot borrow: Limit exceeded");
		}

		Book found = library.SearchBook("Clean Code", "Robert Martin");
		if (found != null)
		{
			System.out.println("Found book: " + found.getTitle() + " (Available: " + found.availability() + ")");
		}
		
		Book notFound = library.SearchBook("Nonexistent Book", "Unknown Author");
		if (notFound == null)
		{
			System.out.println("Book not found in library");
		}

		try
		{
			library.returnBook("ISBN001", "M001");
			System.out.println("Alice returned Clean Code");
			
			// Verify book is available again
			Book returned = library.SearchBook("Clean Code", "Robert Martin");
			System.out.println("Clean Code now available: " + returned.availability());
		}
		catch (Exception e)
		{
			System.out.println("Return failed: " + e.getMessage());
		}
	}
}
