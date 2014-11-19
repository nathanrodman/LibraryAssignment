package library;

import java.io.PrintStream;
import java.util.*;

public class Library
{
	// general methods
	private Map<String, Item> items = new TreeMap<String, Item>();
	private List<Book> books = new ArrayList<Book>();
	private List<MusicAlbum> albums = new ArrayList<MusicAlbum>();
	private List<Movie> movies = new ArrayList<Movie>();
	
	// HashMaps by certain key values
	private Map<String, List<Item>> byKeyword = new TreeMap<String, List<Item>>();
	private Map<String, List<Item>> byAuthor = new TreeMap<String, List<Item>>();
	private Map<String, List<Item>> byBandName = new TreeMap<String, List<Item>>();
	private Map<String, List<Item>> byBandMembers = new TreeMap<String, List<Item>>();
	private Map<String, List<Item>> byDirector = new TreeMap<String, List<Item>>();
	private Map<String, List<Item>> byCastMember = new TreeMap<String, List<Item>>();
	
	
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
			removeFromHashMap(byKeyword, bookToRemove, bookToRemove.getKeyWords());
			removeFromHashMap(byAuthor, bookToRemove, ((Book) bookToRemove).getAuthor());
			books.remove(bookToRemove);
			return true;
		}
		else
			return false;
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
		Item remove = new MusicAlbum();
		if(items.containsKey(title))
		{
			remove = items.remove(title);
			removeFromHashMap(byBandName, remove, ((MusicAlbum) remove).getBandName());
			removeFromHashMap(byBandMembers, remove, remove.getPeople());
			removeFromHashMap(byKeyword, remove, remove.getKeyWords());
			albums.remove(remove);
			return true;
		}
		else
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
		Collections.sort(albums, TITLE);
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
			removeFromHashMap(byKeyword, movieToRemove, movieToRemove.getKeyWords());
			removeFromHashMap(byDirector, movieToRemove, ((Movie) movieToRemove).getDirector());
			removeFromHashMap(byCastMember, movieToRemove, movieToRemove.getPeople());
			movies.remove(movieToRemove);
			return true;
		}
		else
			return false;
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
		Collections.sort(movies, TITLE);
		someMovies.addAll(movies);
		return someMovies;
	}	
	

	private void hashByAttribute(Map<String, List<Item>> listby, Item item, String...keys)
	{
		for (String k : keys)
		{
			List<Item> value = new ArrayList<Item>();
			if(listby.containsKey(k))
				value = listby.remove(k);
			value.add(item);
			listby.put(k, value);
		}

	}
	
	private Boolean removeFromHashMap(Map<String, List<Item>> listby, Item item, String...key)
	{
		int j = listby.size();
		String title = item.getTitle();
		for(String k : key)
		{
			List<Item> inList = new ArrayList<Item>(listby.remove(k));
			if(inList.size() == 1)
			{
				inList.remove(0);
				return true;
			}
			Iterator<Item> i = inList.iterator();
			int index = 0;
			while(i.hasNext())
			{
				Item toRemove = i.next();
				if(toRemove.getTitle() == title)
					index = inList.indexOf(toRemove);
			}
			inList.remove(index);
			listby.put(k, inList);
		}
		if (j > listby.size())
			return true;
		else
			return false;
	}
	
	private Boolean removeFromHashMap(Map<String, List<Item>> listby, Item item, Collection<String> key)
	{
		int j = listby.size();
		String title = item.getTitle();
		for(String k : key)
		{
			List<Item> inList = new ArrayList<Item>(listby.remove(k));
			if(inList.size() == 1)
			{
				inList.remove(0);
				return true;
			}
			Iterator<Item> i = inList.iterator();
			int index = 0;
			while(i.hasNext())
			{
				Item toRemove = i.next();
				if(toRemove.getTitle() == title)
					index = inList.indexOf(toRemove);
			}
			inList.remove(index);
			listby.put(k, inList);
		}
		if (j > listby.size())
			return true;
		else
			return false;
	}
	
	public static Comparator<Item> TITLE = new Comparator<Item>() {
	    @Override
	    public int compare(Item o1, Item o2) {
	        return o1.getTitle().compareTo(o2.getTitle());
	    }
	};

}

