// Each book, music album, or movie will be an instance of a subclass of this class.
// Instances of this class should not be created. Specifying it as 'abstract' ensures
// that they cannot.

package library;

import java.util.*;

public abstract class Item
{
	private enum Type {
		BOOK, ALBUM, MOVIE
	}
	
	private String title;
	private Type type;
	private List<String> keywords = new ArrayList<String>();
	
	public Item()
	{
		title = "no title";
		type = null;
	}
	
	public Item(String theTitle)
	{
		title = theTitle;
	}
	
	
}
