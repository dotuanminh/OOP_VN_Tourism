package hust.soict.globalict.backend.tourism.natural_attraction.body_of_water;

import hust.soict.globalict.backend.rdf.ObjectToCollect;
import hust.soict.globalict.backend.rdf.Prefix;

public class Lake extends BodyOfWater {
	private String lakeType;

	public Lake() {
		super();
		this.lakeType = "?place dbo:type ?lakeType.";
	}

	public String getLakeType() {
		return lakeType;
	}

	@Override
	public String createSparqlQuery() {
		this.createRawTtlFile(ObjectToCollect.OBJECT_LAKE);
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ObjectToCollect.OBJECT_LAKE+"\r\n"
				+ this.getName()+"\r\n"
				+ this.getComment()+"\r\n"
				+ this.getGeoPoint()+"\r\n"
				+ this.getGeoLat()+"\r\n"
				+ this.getGeoLong()+"\r\n"
				+ this.getLocation()+"\r\n"
				+ this.getCountry()+"\r\n"
				+ this.getLength()+"\r\n"
				+ this.getLakeType()+"\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ObjectToCollect.OBJECT_LAKE+"\r\n"
				+ "OPTIONAL {"+ this.getName()+"}\r\n"
				+ "OPTIONAL {"+ this.getComment()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoPoint()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLat()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLong()+"}\r\n"
				+ "OPTIONAL {"+ this.getLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getCountry()+"}\r\n"
				+ "OPTIONAL {"+ this.getLength()+"}\r\n"
				+ "OPTIONAL {"+ this.getLakeType()+"}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' )\r\n"
				+ "}";
	}
}
