// Each book, music album, or movie will be an instance of a subclass of this class.
// Instances of this class should not be created. Specifying it as 'abstract' ensures
// that they cannot.

package library;

import java.util.*;

public abstract class Item
{
	private String title;
	private List<String> keywords = new ArrayList<String>();
	
	public Item()
	{
		title = null;
		keywords = null;
	}
	
	public Item(String theTitle)
	{
		title = theTitle;
	}
	
	public Item(String theTitle, String...keyword)
	{
		title = theTitle;
		for(String s : keyword)
			keywords.add(s);
	}
	
	public void setTitle(String aTitle)
	{
		title = aTitle;
	}
	
	public String getTitle()
	{
		return title;
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
	
}
