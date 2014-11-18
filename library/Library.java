package library;

import java.io.PrintStream;
import java.util.*;

public class Library
{
	// general methods
	private Map<String, Item> items = new HashMap<String, Item>();
	private List<Book> books = new ArrayList<Book>();
	private List<MusicAlbum> albums = new ArrayList<MusicAlbum>();
	private List<Movie> movies = new ArrayList<Movie>();
	
	// HashMaps by certain key values
	private Map<String, List<Item>> byKeyword = new HashMap<String, List<Item>>();
	private Map<String, List<Item>> byAuthor = new HashMap<String, List<Item>>();
	private Map<String, List<Item>> byBandName = new HashMap<String, List<Item>>();
	private Map<String, List<Item>> byBandMembers = new HashMap<String, List<Item>>();
	private Map<String, List<Item>> byDirector = new HashMap<String, List<Item>>();
	private Map<String, List<Item>> byCastMember = new HashMap<String, List<Item>>();
	
	
	// returns all of the items which have the specified keyword
	public Collection<Item> itemsForKeyword(String keyword)
	{
		return byKeyword.get(keyword);
	}
	
	// print an item from this library to the output stream provided
	public void printItem(PrintStream out, Item item)
	{
		item.print(out);
	}
	
	// book-related methods
	
	// adds a book to the library
	public Item addBook(String title, String author, int nPages, String... keywords)
	{
		Book book = new Book(title, author, nPages, keywords);
		books.add(book);

		hashByAttribute(byKeyword, book, keywords);
		hashByAttribute(byAuthor, book, author);
		items.put(title, book);
		
		return book;
	}
	
	// removes a book from the library
	public boolean removeBook(String title)
	{
		Item bookToRemove = new Book();
		if(items.containsKey(title))
		{
			bookToRemove = items.remove(title);
			for(String k : bookToRemove.getKeyWords())
			{
				List<Item> itemsbykeyword = new ArrayList<Item>();
				itemsbykeyword = byKeyword.remove(k);
				for (Item i : itemsbykeyword)
				{
					if(i.getTitle() == bookToRemove.getTitle())
						itemsbykeyword.remove(i);
					if(!itemsbykeyword.isEmpty())
						byKeyword.put(k, itemsbykeyword);
				}
				
			}
			//Removing from the byAuthor list
			String author = new String(((Book) bookToRemove).getAuthor());
			List<Item> booksbyauthor = new ArrayList<Item>();
			booksbyauthor = byAuthor.remove(author);
			for(Item i : booksbyauthor)
			{
				if(i == bookToRemove)
					booksbyauthor.remove(i);
			}
			byAuthor.put(author, booksbyauthor);
			
		}
		else
			return false;
		return true;
	}
	
	// returns all of the books by the specified author
	public Collection<Item> booksByAuthor(String author)
	{
		return byAuthor.get(author);
	}
	
	// returns all of the books in the library
	public Collection<Item> books()
	{
		List<Item> allBooks = new ArrayList<Item>();
		allBooks.addAll(books);
		
		return allBooks;
	}
	
	// music-related methods
	
	// adds a music album to the library
	public Item addMusicAlbum(String title, String band, int nSongs, String... keywords)
	{
		MusicAlbum album = new MusicAlbum(title, band, nSongs, keywords);
		albums.add(album);
	
		//Adds to a HashMap sorted by keywords
		hashByAttribute(byKeyword, album, keywords);
		hashByAttribute(byBandName, album, band);
		items.put(title, album);
		
		return album;
	}

	// adds the specified band members to a music album
	public void addBandMembers(Item album, String... members)
	{
		album.addPeople(members);
		hashByAttribute(byBandMembers, album, members);
	}
	
	// removes a music album from the library
	public boolean removeMusicAlbum(String title)
	{
		return false;
	}

	// returns all of the music albums by the specified band
	public Collection<Item> musicByBand(String band)
	{
		return byBandName.get(band);
	}
	
	// returns all of the music albums by the specified musician
	public Collection<Item> musicByMusician(String musician)
	{
		return byBandMembers.get(musician);
	}
	
	// returns all of the music albums in the library
	public Collection<Item> musicAlbums()
	{
		List<Item> ret = new ArrayList<Item>();
		ret.addAll(albums);
		return ret;
	}
	
	// movie-related methods
	
	// adds a movie to the library
	public Item addMovie(String title, String director, int nScenes, String... keywords)
	{
		Movie amovie = new Movie(title, director, nScenes, keywords);
		movies.add(amovie);
		
		hashByAttribute(byDirector, amovie, director);
		
		return amovie;
	}

	// adds the specified actors to a movie
	public void addCast(Item movie, String... members)
	{
		movie.addPeople(members);
		hashByAttribute(byCastMember, movie, members);
	}

	// removes a movie from the library
	public boolean removeMovie(String title)
	{
		Item movieToRemove = new Movie();
		if(items.containsKey(title))
		{
			movieToRemove = items.remove(title);
			List<String> keywords = new ArrayList<String>(movieToRemove.getKeyWords());
			List<Item> itemsInKeywords = new ArrayList<Item>();
			for(String k : keywords)
			{
				itemsInKeywords = byKeyword.get(k);
				for (Item i : itemsInKeywords)
				{
					if(i.movie)
					{
						itemsInKeywords.remove(i);
					}
				}
				byKeyword.put(k, itemsInKeywords);
			}
		}
		else
			return false;
		return true;
	}
	
	// returns all of the movies by the specified director
	public Collection<Item> moviesByDirector(String director)
	{
		return byDirector.get(director);
	}
	
	// returns all of the movies by the specified actor
	public Collection<Item> moviesByActor(String actor)
	{
		return byCastMember.get(actor);
	}
	
	// returns all of the movies in the library
	public Collection<Item> movies()
	{
		List<Item> someMovies = new ArrayList<Item>();
		someMovies.addAll(movies);
		return someMovies;
	}	
	

	private void hashByAttribute(Map<String, List<Item>> listby, Item item, String...keys)
	{
		List<Item> value = new ArrayList<Item>();
		for (String k : keys)
		{
			if(listby.containsKey(k))
				value = listby.get(k);
			value.add(item);
			listby.put(k, value);
		}

	}
}
