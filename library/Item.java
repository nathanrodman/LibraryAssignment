// Each book, music album, or movie will be an instance of a subclass of this class.
// Instances of this class should not be created. Specifying it as 'abstract' ensures
// that they cannot.

package library;

import java.io.PrintStream;
import java.util.*;

public abstract class Item
{
	private String title = new String();
	private List<String> keywords = new ArrayList<String>();
	
	public Item()
	{
		title = null;
		keywords = null;
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
	
	public List<String> getKeyWords()
	{
		return keywords;
	}
	
	public Boolean containsKeyWord(String keyword)
	{
		for(String s : keywords)
		{
			if (s == keyword)
				return true;
		}
		return false;
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
		out.printf("%n");
	}
	
}
