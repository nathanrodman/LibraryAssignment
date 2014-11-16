package library;

class Book
	extends Item
{
	private int pages;
	private String author;
	
	public Book()
	{
		this(null, null, 0, "none");
	}
	
	public Book(String title, String author, int nPages, String... keywords)
	{
		super(title, keywords);
		this.author = author;
		pages = nPages;
		book = true;
	}
	
	public void setPages(int nPages)
	{
		pages = nPages;
	}
	
	public int getPages()
	{
		return pages;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public void setAuthor(String anAuthor)
	{
		author = anAuthor;
	}

}
