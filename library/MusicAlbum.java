package library;

import java.io.PrintStream;
import java.util.*;

class MusicAlbum
	extends Item
{
	private String bandName;
	private int tracks;
	
	public MusicAlbum()
	{
		this(null, null, 0, "none");
	}
	
	public MusicAlbum(String albumtitle, String band, int nTracks, String...keywords)
	{
		super(albumtitle, keywords);
		bandName = band;
		tracks = nTracks;
		album = true;
	}
	
	public void setBandName(String band)
	{
		bandName = band;
	}
	
	public String getBandName()
	{
		return bandName;
	}
	
	public void setTracks(int nTracks)
	{
		tracks = nTracks;
	}
	
	public int getTracks()
	{
		return tracks;
	}
	
	public void addMembers(String...members)
	{
		super.addPeople(members);
	}
	
	public Collection<String> getMembers()
	{
		return super.getPeople();
	}
	
	public void print(PrintStream out)
	{
		out.println("-Music Album-");
		out.printf("band: %s%n", bandName);
		out.printf("# songs: %d%n", tracks);
		out.printf("members: ");
		List<String> members = new ArrayList<String>(super.getPeople());
		int i = 1;
		for(String s : members)
		{
			out.printf("%s", s);
			if (i != members.size())
				out.printf(", ");
			i++;
		}
		out.printf("%n");
		super.print(out);
		
	}
}
