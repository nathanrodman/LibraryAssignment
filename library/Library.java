package library;

import java.io.PrintStream;
import java.util.*;

public class Library
{
	// general methods
	private List<Item> items = new ArrayList<Item>();
	private TreeSet<Book> books = new TreeSet<Book>();
	private TreeSet<MusicAlbum> albums = new TreeSet<MusicAlbum>();
	private TreeSet<Movie> movies = new TreeSet<Movie>();
	
	
	// returns all of the items which have the specified keyword
	public Collection<Item> itemsForKeyword(String keyword)
	{
		List<Item> matches = new ArrayList<Item>();
		
		for (Item i : items)
		{
			if(i.containsKeyWord(keyword))
				matches.add(i);
		}
		
		return matches;
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
		return book;
	}
	
	// removes a book from the library
	public boolean removeBook(String title)
	{
		for(Item b : books)
		{
			if(b.getTitle() == title)
			{
				books.remove(b);
				items.remove(b);
				return true;
			}
		}
		return false;
	}
	
	// returns all of the books by the specified author
	public Collection<Item> booksByAuthor(String author)
	{
		List<Item> byAuthor = new ArrayList<Item>();
		for (Book b : books)
		{
			if(b.getAuthor() == author)
			{
				byAuthor.add(b);
			}
		}
		return byAuthor;
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
		return album;
	}

	// adds the specified band members to a music album
	public void addBandMembers(Item album, String... members)
	{
		album.addPeople(members);
	}
	
	// removes a music album from the library
	public boolean removeMusicAlbum(String title)
	{
		return false;
	}

	// returns all of the music albums by the specified band
	public Collection<Item> musicByBand(String band)
	{
		return null;
	}
	
	// returns all of the music albums by the specified musician
	public Collection<Item> musicByMusician(String musician)
	{
		return null;
	}
	
	// returns all of the music albums in the library
	public Collection<Item> musicAlbums()
	{
		return null;
	}
	
	// movie-related methods
	
	// adds a movie to the library
	public Item addMovie(String title, String director, int nScenes, String... keywords)
	{
		Movie amovie = new Movie(title, director, nScenes, keywords);
		movies.add(amovie);
		return amovie;
	}

	// adds the specified actors to a movie
	public void addCast(Item movie, String... members)
	{
		movie.addPeople(members);
	}

	// removes a movie from the library
	public boolean removeMovie(String title)
	{
		return false;
	}
	
	// returns all of the movies by the specified director
	public Collection<Item> moviesByDirector(String director)
	{
		return null;
	}
	
	// returns all of the movies by the specified actor
	public Collection<Item> moviesByActor(String actor)
	{
		return null;
	}
	
	// returns all of the movies in the library
	public Collection<Item> movies()
	{
		return null;
	}	
}
