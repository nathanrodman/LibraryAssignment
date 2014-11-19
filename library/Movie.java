package library;

import java.io.PrintStream;
import java.util.*;

class Movie
	extends Item
{
	private String director;
	private int scenes;
	
	public Movie()
	{
		super();
	}
	
	public Movie(String title, String director, int noOfScenes, String...keyword)
	{
		super(title, keyword);
		this.director = director;
		this.scenes = noOfScenes;
		movie = true;
	}
	
	public void addCast(String...theCast)
	{
		super.addPeople(theCast);
	}
	
	public void print(PrintStream out)
	{
		out.println("-Movie-");
		out.printf("director: %s%n", director);
		out.printf("# scences: %d%n", scenes);
		out.printf("cast: ");
		
		List<String> cast = new ArrayList<String>(super.getPeople());
		int i = 1;
		for(String s : cast)
		{
			out.printf("%s", s);
			if (i != cast.size())
				out.printf(", ");
			i++;
		}
		out.printf("%n");
		super.print(out);
	}
	
	public String getDirector()
	{
		return director;
	}
	
}
