// Each book, music album, or movie will be an instance of a subclass of this class.
// Instances of this class should not be created. Specifying it as 'abstract' ensures
// that they cannot.

package library;

import java.util.*;

public abstract class Item
{

	private List<String> keywords = new ArrayList<String>();

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
