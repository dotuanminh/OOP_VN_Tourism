package hust.soict.globalict.entity.tourism.natural_attraction;

import hust.soict.globalict.entity.rdf.Prefix;

public class Cave extends NaturalAttraction{
	public final static String OBJECT_CAVE="dbc:Caves_of_Vietnam.";
	private static String depth;
	private static String length;
	public static String dicovery;
	private static String geology;
	private static String entrance;
	public Cave() {
		super();
		// TODO Auto-generated constructor stub
		this.depth="?place dbo:depth ?depth.";
		this.length="?place dbo:length ?length.";
		this.dicovery="?place dbp:discovery ?discover.";
		this.geology="?place dbp:geology ?geology.";
		this.entrance="?place dbp:entranceCount ?entrance.";
		this.createRawTtlFile(OBJECT_CAVE);
	}
	public static String getDepth() {
		return depth;
	}
	public static String getLength() {
		return length;
	}
	public static String getDicovery() {
		return dicovery;
	}
	public static String getGeology() {
		return geology;
	}
	public static String getEntrance() {
		return entrance;
	}
	@Override
	public String createSparqlQuery() {
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ OBJECT_CAVE + "\r\n"
				+ this.getName()+"\r\n"
				+ this.getComment()+"\r\n"
				+ this.getGeoPoint()+"\r\n"
				+ this.getGeoLat()+"\r\n"
				+ this.getGeoLong()+"\r\n"
				+ this.getLocation()+"\r\n"
				+ this.getCountry()+"\r\n"
				+ this.getDepth()+"\r\n"
				+ this.getLength()+"\r\n"
				+ this.getDicovery()+"\r\n"
				+ this.getGeology()+"\r\n"
				+ this.getEntrance()+"\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ OBJECT_CAVE + "\r\n"
				+ "OPTIONAL {"+ this.getName()+"}\r\n"
				+ "OPTIONAL {"+ this.getComment()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoPoint()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLat()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLong()+"}\r\n"
				+ "OPTIONAL {"+ this.getLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getCountry()+"}\r\n"
				+ "OPTIONAL {"+ this.getDepth()+"}\r\n"
				+ "OPTIONAL {"+ this.getLength()+"}\r\n"
				+ "OPTIONAL {"+ this.getDicovery()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeology()+"}\r\n"
				+ "OPTIONAL {"+ this.getEntrance()+"}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
				+ "}";
	}
}
