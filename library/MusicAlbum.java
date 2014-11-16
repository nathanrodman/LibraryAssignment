package library;

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
	
	public List<String> getMembers()
	{
		return super.getPeople();
	}
}
