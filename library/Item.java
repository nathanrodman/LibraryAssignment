// Each book, music album, or movie will be an instance of a subclass of this class.
// Instances of this class should not be created. Specifying it as 'abstract' ensures
// that they cannot.

package library;

import java.io.PrintStream;
import java.util.*;

public abstract class Item
{
	private String title = new String();
	private Set<String> keywords = new TreeSet<String>();
	private Set<String> people = new TreeSet<String>();
	protected Boolean movie = false;
	protected Boolean book = false;
	protected Boolean album = false;
	
	public Item()
	{
		title = null;
		keywords = null;
		people = null;
	}
	
	public Item(String theTitle, String...keywords)
	{
		this.title = theTitle;
		for(String s : keywords)
			this.keywords.add(s);
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String aTitle)
	{
		title = aTitle;
	}

	public void addKeyWords(String ... keyword)
	{
		for(String s : keyword)
			keywords.add(s);
	}
	
	public Collection<String> getKeyWords()
	{
		return keywords;
	}
	
	public Boolean containsKeyWord(String keyword)
	{
		return keywords.contains(keyword);
	}
	
	public void print(PrintStream out)
	{
		out.printf("title: %s%n", title);
		out.printf("keywords: ");
		int i = 1;
		for(String s : keywords)
		{
			out.printf("%s", s);
			if (i != keywords.size())
				out.printf(", ");
			i++;
		}
		out.printf("%n%n");
	}
	
	public void addPeople(String...people)
	{
		for(String s : people)
			this.people.add(s);
	}
	
	public Collection<String> getPeople()
	{
		return people;
	}
	
}
