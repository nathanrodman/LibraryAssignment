package library;

import java.io.PrintStream;
import java.util.*;

class Movie
	extends Item
{
	private String director;
	private int scenes;
	private List<String> cast = new ArrayList<String>();
	
	public Movie()
	{
		super();
	}
	
	public Movie(String title, String director, int noOfScenes, String...keyword)
	{
		super(title, keyword);
		this.director = director;
		this.scenes = noOfScenes;
	}
	
	public void addCast(String...theCast)
	{
		for (String s : theCast)
			cast.add(s);
	}
	
	public void print(PrintStream out)
	{
		out.println("-Movie-");
		out.printf("director: %s%n", director);
		out.printf("# scences: %d%n", scenes);
		out.printf("cast: ");
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
}
