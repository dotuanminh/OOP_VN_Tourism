package hust.soict.globalict.entity.tourism.natural_attraction;

import hust.soict.globalict.entity.rdf.Prefix;

public class Mountain extends NaturalAttraction{
	public final static String OBJECT_MOUNTAIN="dbc:Mountains_of_Vietnam.";
	private static String elevation;
	private static String prominence;
	public Mountain() {
		super();
		// TODO Auto-generated constructor stub
		this.elevation="?place dbo:elevation ?elevation.";
		this.prominence="?place dbo:prominence ?prominence.";
		this.createRawTtlFile(OBJECT_MOUNTAIN);
	}
	public static String getElevation() {
		return elevation;
	}
	public static String getProminence() {
		return prominence;
	}
	@Override
	public String createSparqlQuery() {
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ OBJECT_MOUNTAIN + "\r\n"
				+ this.getName()+"\r\n"
				+ this.getComment()+"\r\n"
				+ this.getGeoPoint()+"\r\n"
				+ this.getGeoLat()+"\r\n"
				+ this.getGeoLong()+"\r\n"
				+ this.getLocation()+"\r\n"
				+ this.getCountry()+"\r\n"
				+ this.getElevation()+"\r\n"
				+ this.getProminence()+"\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ OBJECT_MOUNTAIN + "\r\n"
				+ "OPTIONAL {"+ this.getName()+"}\r\n"
				+ "OPTIONAL {"+ this.getComment()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoPoint()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLat()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLong()+"}\r\n"
				+ "OPTIONAL {"+ this.getLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getCountry()+"}\r\n"
				+ "OPTIONAL {"+ this.getElevation()+"}\r\n"
				+ "OPTIONAL {"+ this.getProminence()+"}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
				+ "}";
	}

	@Override
	public String createFileName() {
		return "Mountain";
	}
	
}
